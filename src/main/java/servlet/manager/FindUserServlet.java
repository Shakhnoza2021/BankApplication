package servlet.manager;

import exception.UserNotFoundException;
import model.User;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "findUser", urlPatterns = {"/findUser", "/secure/managerView/findUser"})
public class FindUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        request.setAttribute("user", request.getSession().getAttribute("user"));

        String phoneNum = request.getParameter("phoneNum");
        request.getSession().setAttribute("phoneNum", phoneNum);
        UserService service = new UserService();

        User user = null;
        try {
            user = service.getUserByPhoneNum(phoneNum);
        } catch (UserNotFoundException e) {
            request.setAttribute("error", e.getMessage());
        }

        System.out.println(user.toString());
        if (user.getId() == 0 && phoneNum != null) {
            request.setAttribute("error", "Пользователь не найден");
        }

        request.getSession().setAttribute("client", user);
        RequestDispatcher rd = request.getRequestDispatcher("/secure/managerView/clients.jsp");
        rd.include(request, response);
    }
}
