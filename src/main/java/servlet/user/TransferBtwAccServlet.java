package servlet.user;

import exception.NotEnoughMoneyException;
import model.User;
import model.services.Operations;
import model.services.PhoneCommunication;
import service.UserService;
import service.bankService.CardsService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "transferBtw", urlPatterns = {"/transferBtw", "/secure/userView/transferBtw"})
public class TransferBtwAccServlet extends HttpServlet {
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
        System.out.println(request.getSession().getAttribute("cards"));

        String number = request.getParameter("number");
        System.out.println("number  = " + number);

        UserService service = new UserService();
        if (number != null) {

        }

        RequestDispatcher rd = request.getRequestDispatcher("/secure/userView/transfer.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
