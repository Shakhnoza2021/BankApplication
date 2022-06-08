package service.bankService;

import model.BankAccount;
import model.User;
import service.dbService.DBConnectService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccountService {
    public List<BankAccount> getUserAccounts(User user) {
        Connection conn = null;
        List<BankAccount> accounts = new ArrayList<>();

        try {
            conn = DBConnectService.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM bank_accounts WHERE user_id = " + user.getId() + ";");
            //System.out.println("rs  " + rs.getInt("id"));
            System.out.println("user id " + user.getId());
            while (rs.next()){
                BankAccount account = new BankAccount();
                CommonService.setFieldsFromResultSet(account, rs);
                accounts.add(account);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println("accounts " + accounts);
        DBConnectService.close(conn);
        return accounts;
    }
}
