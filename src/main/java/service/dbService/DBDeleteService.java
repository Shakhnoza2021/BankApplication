package service.dbService;

import model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBDeleteService {
    public static void deleteUser(String phoneNum) {
        Connection conn = null;
        try {
            conn = DBConnectService.getConnection();
            Statement st = conn.createStatement();
            st.executeUpdate("DELETE FROM users WHERE phone_number = '" + phoneNum + "';");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        DBConnectService.close(conn);
    }
}
