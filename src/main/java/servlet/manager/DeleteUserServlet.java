package servlet.manager;

import model.User;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteUser", urlPatterns = {"/deleteUser", "/secure/managerView/deleteUser"})
public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        request.setAttribute("user", request.getSession().getAttribute("user"));

        String phoneNum = (String) request.getSession().getAttribute("phoneNum");
        System.out.println("phoneNum  " + phoneNum);

        UserService service = new UserService();

        service.deleteUser(phoneNum);
        System.out.println("User deleted");
        RequestDispatcher rd = request.getRequestDispatcher("/secure/managerView/clients.jsp");
        rd.forward(request, response);
    }
}
