package servlet.user;

import model.User;
import service.bankService.AccountService;
import service.bankService.CardsService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "accounts", urlPatterns = {"/accounts", "/secure/userView/accounts"})
public class AccountsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.setProperty("file.encoding", "UTF-8");
        System.out.println("Inside account Servlet");

        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        AccountService service = new AccountService();

        User user = (User) request.getSession().getAttribute("user");
        System.out.println("user  " + user.toString());
        user.setAccounts(service.getUserAccounts(user));
        request.getSession().setAttribute("accounts", user.getAccounts());
        request.setAttribute("accounts", user.getAccounts());
        System.out.println(request.getSession().getAttribute("accounts"));
        RequestDispatcher rd = request.getRequestDispatcher("/secure/userView/accounts.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}