package service.bankService;

import service.dbService.DBConnectService;
import model.Credit;
import model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CreditsService {
    public List<Credit> getUserCredits(User user) {
        Connection conn = null;
        List<Credit> credits = new ArrayList<>();

        try {
            conn = DBConnectService.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM credits WHERE user_id = " + user.getId() + ";");
            //System.out.println("rs  " + rs.getInt("id"));
            System.out.println("user id " + user.getId());
            while (rs.next()){
                Credit credit = new Credit();
                CommonService.setFieldsFromResultSet(credit, rs);
                credits.add(credit);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println("credits " + credits);
        DBConnectService.close(conn);
        return credits;
    }
}
