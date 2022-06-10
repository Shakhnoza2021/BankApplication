package service;

import exception.UserNotFoundException;
import model.Card;
import service.dbService.*;
import model.User;

import javax.servlet.http.HttpSession;
import java.sql.*;

public class UserService {

    public UserService() {
    }

    public void addUser(User user){
        Connection conn = null;

        try {
            conn = DBConnectService.getConnection();
            DBWriteService.writeUser(conn, user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBConnectService.close(conn);
    }

    public void updateUser(User user) {
        Connection conn = null;

        try {
            conn = DBConnectService.getConnection();
            DBUpdateService.updateUser(conn, user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBConnectService.close(conn);
    }

    public void deleteUser(String phoneNum) {
        DBDeleteService.deleteUser(phoneNum);
    }

    public User getUserByPhoneNum(String phoneNum) throws UserNotFoundException {
        User user = DBSelectService.getUserByPhoneNum(phoneNum);
        if (user == null) {
            throw new UserNotFoundException("Пользователь не найден");
        }
        return user;
    }

    public User getUserByCardNum(String cardNum) throws UserNotFoundException {
        User user = DBSelectService.getUserByCardNum(cardNum);
        if (user == null) {
            throw new UserNotFoundException("Пользователь не найден");
        }
        return user;
    }

    public User getUserByPhoneNum(String login, String password) {
        Connection conn = null;
        User user = new User();
        user.setPhoneNum(login);
        user.setPassword(password);
        try {
            conn = DBConnectService.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT id, name, last_name, patronymic, email, role FROM users WHERE phone_number = '" + login + "' AND password = '" + password + "'");

            while (rs.next()){
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setLastName(rs.getString(3));
                user.setPatronymic(rs.getString(4));
                user.setEmail(rs.getString(5));
                user.setRole(rs.getString(6));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        DBConnectService.close(conn);
        return user;
    }

    public String getUserRole(String login, String password) {
        return getUserByPhoneNum(login, password).getRole();
    }

    public int getUserId(String login, String password) {
        return getUserByPhoneNum(login, password).getId();
    }

    public Card getCard(User user, String number) {
        Card card = null;

        for (Card c: user.getCards()) {
            if (c.getCardNum().equals(number))
                card = c;
        }
        return card;
    }

    public void setSessionAttribute(User user, HttpSession session){
        session.setAttribute("userId", user.getId());
        session.setAttribute("name",user.getName());
        session.setAttribute("lastName",user.getLastName());
        session.setAttribute("patronymic",user.getPatronymic());
        session.setAttribute("userRole", user.getRole());
        session.setAttribute("email",user.getEmail());
        session.setAttribute("login", user.getPhoneNum());
        session.setAttribute("user", user);
    }


}
