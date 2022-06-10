package servlet.user;

import model.User;
import model.services.Operations;
import service.bankService.AccountService;
import service.bankService.OperationsService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "history", urlPatterns = {"/history", "/secure/userView/history"})
public class HistoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        AccountService service = new AccountService();
        OperationsService opService = new OperationsService();

        User user = (User) request.getSession().getAttribute("user");
        System.out.println("user  " + user.toString());
        user.setAccounts(service.getUserAccounts(user));
        request.getSession().setAttribute("accounts", user.getAccounts());
        request.setAttribute("accounts", user.getAccounts());

        String accountNum = request.getParameter("account");
        System.out.println("account " + accountNum);
        List<Operations> operations;
        if (accountNum == null){
             operations = opService.getAccOperations();
            request.setAttribute("operations", operations);
        } else {
            operations = opService.getAccOperations(accountNum);
            request.setAttribute("operations", operations);
        }



        RequestDispatcher rd = request.getRequestDispatcher("/secure/userView/history.jsp");
        rd.forward(request, response);
    }
}
