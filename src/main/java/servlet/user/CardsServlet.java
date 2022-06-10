package servlet.user;

import model.User;
import service.bankService.CardsService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "cards", urlPatterns = {"/cards", "/secure/userView/cards"})
public class CardsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.setProperty("file.encoding","UTF-8");
        System.out.println("Inside card Servlet");

        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        CardsService service = new CardsService();

        User user = (User) request.getSession().getAttribute("user");
        System.out.println("user  " + user.toString());
        user.setCards(service.getUserCards(user));
        request.getSession().setAttribute("cards",user.getCards());
        request.setAttribute("cards", user.getCards());
        System.out.println(request.getSession().getAttribute("cards"));
        RequestDispatcher rd = request.getRequestDispatcher("/secure/userView/cards.jsp");
        rd.forward(request, response);
    }
}