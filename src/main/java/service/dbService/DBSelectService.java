package service.dbService;

import model.Card;
import model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBSelectService {
    public static User getUserByPhoneNum(String phoneNum) {
        Connection conn = null;
        User user = new User();
        try {
            conn = DBConnectService.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM users WHERE phone_number = " + phoneNum + ";");
            while (rs.next()){
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setLastName(rs.getString(3));
                user.setPatronymic(rs.getString(4));
                user.setPhoneNum(rs.getString(5));
                user.setEmail(rs.getString(6));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        DBConnectService.close(conn);
        return user;
    }

    public static User getUserByCardNum(String cardNum) {
        Connection conn = null;
        User user = new User();
        try {
            conn = DBConnectService.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT users.id, users.name, users.last_name, users.patronymic, users.phone_number, users.email " +
                    "FROM users " +
                    "INNER JOIN cards ON users.id = cards.user_id " +
                    "WHERE cards.card_num = '" + cardNum +"';");
            while (rs.next()){
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setLastName(rs.getString(3));
                user.setPatronymic(rs.getString(4));
                user.setPhoneNum(rs.getString(5));
                user.setEmail(rs.getString(6));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        DBConnectService.close(conn);
        return user;
    }

    public static Card getCard(String number) {
        Card card = new Card();
        Connection conn = null;

        try {
            conn = DBConnectService.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM cards " +
                    "WHERE card_num = '" + number + "'");

            while (rs.next()){
                card.setId(rs.getInt("id"));
                card.setName(rs.getString("card_name"));
                card.setType(rs.getString("card_type"));
                card.setSum(rs.getDouble("card_sum"));
                card.setPercent(rs.getDouble("percent"));
                card.setCardNum(rs.getString("card_num"));
                card.setUserId(rs.getInt("user_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return card;
    }
}
