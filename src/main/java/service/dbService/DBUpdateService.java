package service.dbService;

import model.BankAccount;
import model.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUpdateService {
    public static void updateAccounts(Connection conn, User user, BankAccount account) throws SQLException {
        Statement st = conn.createStatement();
        st.executeUpdate("UPDATE bank_accounts SET account_sum = " + account.getSum() +
                " WHERE user_id = " + user.getId() +
                " AND account_num = " + account.getAccountNum() + ";");
    }

    public static void updateCards(Connection conn, User user, BankAccount account) throws SQLException {
        Statement st = conn.createStatement();
        st.executeUpdate("UPDATE cards SET card_sum = " + account.getSum() +
                " WHERE user_id = " + user.getId() +
                " AND account_id = " + account.getId() + ";");
    }
}
