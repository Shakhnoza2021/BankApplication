package servlet.user;

import model.User;
import model.services.Operations;
import service.UserService;
import service.bankService.OperationsService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "editProfile", urlPatterns = {"/editProfile", "/secure/userView/editProfile"})
public class EditProfile extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        request.setAttribute("user", request.getSession().getAttribute("user"));
        System.out.println(request.getSession().getAttribute("user").toString());


        RequestDispatcher rd = request.getRequestDispatcher("/secure/userView/editProfile.jsp");
        rd.forward(request, response);
    }
}
