package service;

import service.dbService.DBService;
import model.User;

import javax.servlet.http.HttpSession;
import java.sql.*;

public class UserService {

    public UserService() {
    }

    public void addUser(){

    }

    public User getUser(String login, String password) {
        Connection conn = null;
        User user = new User();
        user.setPhoneNum(login);
        user.setPassword(password);
        try {
            conn = DBService.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT id, name, first_name, role FROM users WHERE phone_number = '" + login + "' AND password = '" + password + "'");

            while (rs.next()){
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setFirstname(rs.getString(3));
                user.setRole(rs.getString(4));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        DBService.close(conn);
        return user;
    }

    public String getUserRole(String login, String password) {
        return getUser(login, password).getRole();
    }

    public int getUserId(String login, String password) {
        return getUser(login, password).getId();
    }

    public void setSessionAttribute(User user, HttpSession session){
        session.setAttribute("userId", user.getId());
        session.setAttribute("name",user.getName());
        session.setAttribute("firstName",user.getFirstname());
        session.setAttribute("userRole", user.getRole());
        session.setAttribute("login", user.getPhoneNum());
        session.setAttribute("user", user);
    }
}
