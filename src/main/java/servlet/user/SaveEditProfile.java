package servlet.user;


import model.User;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "saveEdit", urlPatterns = {"/saveEdit", "/secure/userView/saveEdit"})
public class SaveEditProfile extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        User user = (User) request.getSession().getAttribute("user");

        String name = request.getParameter("name");
        if (!name.equals("")){
            user.setName(name);
        }

        String lastName = request.getParameter("lastName");
        if (!lastName.equals("")){
            user.setLastName(lastName);
        }

        String patronymic = request.getParameter("patronymic");
        if (!patronymic.equals("")){
            user.setPatronymic(patronymic);
        }

        String phoneNum = request.getParameter("phoneNum");
        if (!phoneNum.equals("")){
            user.setPhoneNum(phoneNum);
        }

        String email = request.getParameter("email");
        if (!email.equals("")){
            user.setEmail(email);
        }

        UserService service = new UserService();
        service.updateUser(user);

        request.setAttribute("user", user);
        request.getSession().setAttribute("user", user);

        RequestDispatcher rd = request.getRequestDispatcher("/secure/userView/profile.jsp");
        rd.forward(request, response);
    }
}
