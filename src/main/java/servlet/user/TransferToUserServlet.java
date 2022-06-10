package servlet.user;

import exception.NotEnoughMoneyException;
import exception.UserNotFoundException;
import model.User;
import model.services.Operations;
import model.services.Transfer;
import service.UserService;
import service.bankService.BankService;
import service.bankService.CardsService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "transferTo", urlPatterns = {"/transferTo", "/secure/userView/transferTo"})
public class TransferToUserServlet extends HttpServlet {

    private final String bankClient = "bankClient";
    private final String btwAccounts = "btwAccounts";
    private final String phoneNum = "phoneNum";
    private final String cardNum = "cardNum";
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        CardsService cardServ = new CardsService();

        User user = (User) request.getSession().getAttribute("user");
        System.out.println("user  " + user.toString());
        user.setCards(cardServ.getUserCards(user));
        //request.getSession().setAttribute("cards", user.getCards());
        request.setAttribute("cards", user.getCards());

        String number = request.getParameter("number");
        System.out.println("number  = " + number);

        User client = null;
        BankService service = new BankService();
        UserService userService = new UserService();

        if (number != null) {
            try {
                if (number.length() == 11) {
                    client = userService.getUserByPhoneNum(number);
                    System.out.println("length = 11");
                } else if (number.length() == 6){
                    client = userService.getUserByCardNum(number);
                    System.out.println("length = 12");
                } else {
                    request.setAttribute("errorUser", "Пользователь не найден");
                }
            } catch (UserNotFoundException e) {
                request.setAttribute("errorUser", "Пользователь не найден");
            }

            if (client != null) {
                System.out.println("client " + client.toString());
                request.setAttribute("client", client);
                String transferSum = request.getParameter("transferSum");
                System.out.println("transferSum " + transferSum);

                String cardNum = request.getParameter("fromCard");
                System.out.println("cardNum " + cardNum);
                if (transferSum != null && cardNum != null) {
                    double sum = Double.parseDouble(transferSum);
                    try {
                        service.transferMoney(cardNum, number, sum);
                        request.setAttribute("cards", cardServ.getUserCards(user));
                    } catch (NotEnoughMoneyException e) {
                        request.setAttribute("errorSum", e.getMessage());
                    }

                    Transfer transfer = new Transfer();
                    transfer.setCardFrom(cardNum);
                    transfer.setCardTo(number);
                    transfer.setSum(sum);

                    Operations op = new Operations();
                    op.setName("Перевод клиенту банка");
                    op.setType("Перевод");
                    op.setSum(sum);
                    op.setCardNum(cardNum);
                    op.setUserId(user.getId());

                    service.writeOperation(user, transfer, op);
                }
            }

        }

        RequestDispatcher rd = request.getRequestDispatcher("/secure/userView/transfer.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
