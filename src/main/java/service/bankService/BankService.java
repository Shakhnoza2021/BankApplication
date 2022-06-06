package service.bankService;

import exception.NotEnoughMoneyException;
import model.BankAccount;
import model.Credit;
import model.User;
import service.dbService.DBService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BankService {
    public void transferMoney(User user, String phoneNum){

    }

    public void payForCommunalServices() {

    }

    public void payTheFine() {

    }

    public void payForPhoneCommunications(User user, String phoneNum, double sum, BankAccount account) throws NotEnoughMoneyException {
        if (account.getSum() >= sum) {
            account.setSum(account.getSum() - sum);

            Connection conn = null;
            try {
                conn = DBService.getConnection();
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery("UPDATE bank_accounts SET account_sum = " + account.getSum() +
                                                   " WHERE user_id = " + user.getId() +
                                                   " AND account_num = " + account.getAccountNum() + ";");

                rs = st.executeQuery("UPDATE cards SET card_sum = " + account.getSum() +
                                         " WHERE user_id = " + user.getId() +
                                         " AND account_id = " + account.getId() + ";");
                System.out.println("user id " + user.getId());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            DBService.close(conn);
        } else throw new NotEnoughMoneyException("Недостаточно денег");
    }
}
