package servlet.user;

import exception.NotEnoughMoneyException;
import model.User;
import model.services.CommunalServices;
import model.services.Fine;
import model.services.Operations;
import model.services.PhoneCommunication;
import service.UserService;
import service.bankService.AccountService;
import service.bankService.BankService;
import service.bankService.CardsService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "payments", urlPatterns = {"/payments", "/secure/userView/payments"})
public class PaymentsServlet extends HttpServlet {
    private final String phoneComm = "phoneType";
    private final String fines = "fineType";
    private final String commServ = "comServType";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        CardsService cardServ = new CardsService();

        User user = (User) request.getSession().getAttribute("user");
        System.out.println("user  " + user.toString());
        user.setCards(cardServ.getUserCards(user));
        request.getSession().setAttribute("cards", user.getCards());
        request.setAttribute("cards", user.getCards());
        System.out.println(request.getSession().getAttribute("cards"));

        BankService service = new BankService();

        String payments = request.getParameter("paymentType");
        System.out.println("paymentType  = " + payments);

        if (payments != null) {
            String paymentType = request.getParameter("selectedLabel");
            System.out.println("selectedLabel " + paymentType);

            if (payments.equals(phoneComm)) {
                String provider = request.getParameter("provider");
                String phoneNum = request.getParameter("numOfPhone");
                String cardNum = request.getParameter("card");

                double sum = Double.parseDouble(request.getParameter("sumPhone"));
                Operations op = new Operations();
                op.setName(paymentType);
                op.setType("оплата");
                op.setSum(sum);
                op.setCardNum(cardNum);
                op.setUserId(user.getId());

                PhoneCommunication phoneCom = new PhoneCommunication();
                phoneCom.setPhoneNumber(phoneNum);
                phoneCom.setProvider(provider);
                phoneCom.setSum(sum);

                phoneCom.setType("оплата");

                System.out.println("phone comm " + phoneCom.toString());

                try {
                    service.payForServices(user, op);
                    service.writeOperation(user, phoneCom, op);
                } catch (NotEnoughMoneyException e) {
                    request.setAttribute("error", e.getMessage());
                    System.out.println("------ error------" + e.getMessage());
                }
            }

            if (payments.equals(fines)) {
                String company = request.getParameter("fine");
                String docNum = request.getParameter("docNum");
                String cardNum = request.getParameter("card");

                double sum = Double.parseDouble(request.getParameter("fineSum"));

                Operations op = new Operations();
                op.setName(paymentType);
                op.setType("оплата");
                op.setSum(sum);
                op.setCardNum(cardNum);
                op.setUserId(user.getId());

                Fine fine = new Fine();
                fine.setCompany(company);
                fine.setDocNumber(docNum);
                fine.setSum(sum);
                fine.setType("оплата");

                try {
                    service.payForServices(user, op);
                    service.writeOperation(user, fine, op);
                } catch (NotEnoughMoneyException e) {
                    request.setAttribute("error", e.getMessage());
                    System.out.println("------ error------" + e.getMessage());
                }
            }

            if (payments.equals(commServ)) {
                String name = request.getParameter("comServ");
                String company = request.getParameter("org");
                String personalAcc = request.getParameter("personalAcc");
                String cardNum = request.getParameter("card");

                double sum = Double.parseDouble(request.getParameter("comServSum"));

                Operations op = new Operations();
                op.setName(paymentType);
                op.setType("оплата");
                op.setSum(sum);
                op.setCardNum(cardNum);
                op.setUserId(user.getId());

                CommunalServices cs = new CommunalServices();
                cs.setName(name);
                cs.setCompany(company);
                cs.setPersonalAcc(personalAcc);
                cs.setSum(sum);
                cs.setType("оплата");

                try {
                    service.payForServices(user, op);
                    service.writeOperation(user, cs, op);
                } catch (NotEnoughMoneyException e) {
                    request.setAttribute("error", e.getMessage());
                    System.out.println("------ error------" + e.getMessage());
                }
            }
        }

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/secure/userView/payments.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
