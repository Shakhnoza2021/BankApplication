package servlet;

import model.User;
import service.bankService.CommonService;
import service.bankService.CreditsService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "credits", urlPatterns = {"/credits", "/secure/userView/credits"})
public class CreditsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.setProperty("file.encoding","UTF-8");
        System.out.println("Inside credit Servlet");

        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        CreditsService service = new CreditsService();

        User user = (User) request.getSession().getAttribute("user");
        System.out.println("user  " + user.toString());
        user.setCredits(service.getUserCredits(user));
        request.getSession().setAttribute("credits",user.getCredits());
        request.setAttribute("credits", user.getCredits());
        System.out.println(request.getSession().getAttribute("credits"));
        RequestDispatcher rd = request.getRequestDispatcher("/secure/userView/credits.jsp");
        rd.forward(request, response);
    }
}
