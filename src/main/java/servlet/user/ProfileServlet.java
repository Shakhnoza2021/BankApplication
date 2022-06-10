package servlet.user;

import model.services.Operations;
import service.bankService.OperationsService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "profile", urlPatterns = {"/profile", "/secure/userView/profile"})
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        request.setAttribute("user", request.getSession().getAttribute("user"));
        //System.out.println(request.getAttribute("user").toString());
        System.out.println(request.getSession().getAttribute("user").toString());

        OperationsService opService = new OperationsService();
        List<Operations> operations = opService.getAccOperations();
        request.setAttribute("operations", operations);

        RequestDispatcher rd = request.getRequestDispatcher("/secure/userView/profile.jsp");
        rd.forward(request, response);
    }
}
