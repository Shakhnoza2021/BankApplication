package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/secure/userView/*")
public class UserAuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);
        System.out.println("inside filter Auth");

        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String path = request.getRequestURI();
        //Существует ли сессиия
        boolean loggedIn = session != null && session.getAttribute("login") != null && session.getAttribute("userRole") != null;
        if (loggedIn ){
            //Если существует то получаем роль
            String userRole = session.getAttribute("userRole").toString();
            System.out.println("User role " + userRole);

            if (userRole.equals("user")){
                System.out.println("Auth filter user");
                chain.doFilter(request, response);
               /* if(!path.endsWith("/logout")) {
                    RequestDispatcher rd = request.getRequestDispatcher("/secure/managerView/manager.jsp");
                    rd.include(request, response);
                    //response.sendRedirect(request.getContextPath() + "/secure/managerView/manager.jsp");
                } else chain.doFilter(request, response);*/
            } else {
                if(!path.endsWith("/logout")) {
                    System.out.println("From userAuth to manager.jsp");
                    RequestDispatcher rd = request.getRequestDispatcher("/secure/managerView/manager.jsp");
                    rd.include(request, response);
                } else chain.doFilter(request, response);
            }
            //Если нет то на страницу входа.
        }else {
            System.out.println("redirect to login");
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
    }

    @Override
    public void destroy() {
        //Filter.super.destroy();
    }
}