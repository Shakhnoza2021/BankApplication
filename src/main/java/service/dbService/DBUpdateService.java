package service.dbService;

import model.BankAccount;
import model.Card;
import model.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUpdateService {
    public static void updateAccounts(Connection conn, Card card) throws SQLException {
        Statement st = conn.createStatement();
        st.executeUpdate("UPDATE bank_accounts SET account_sum = " + card.getSum() +
                " WHERE card_id = " + card.getId() + ";");
    }

    public static void updateCards(Connection conn, Card card) throws SQLException {
        Statement st = conn.createStatement();
        st.executeUpdate("UPDATE cards SET card_sum = " + card.getSum() +
                " WHERE card_num = " + card.getCardNum() + ";");
    }

    public static void updateUser(Connection conn, User user) throws SQLException {
        Statement st = conn.createStatement();
        st.executeUpdate("UPDATE users " +
                "SET name = '" + user.getName() + "', last_name = '" + user.getLastName() +
                "', patronymic = '" + user.getPatronymic() + "', phone_number = '" + user.getPhoneNum() +
                "', email = '" + user.getEmail() +
                "' WHERE id = " + user.getId() + " AND phone_number = '" + user.getPhoneNum() + "';");
    }
}
