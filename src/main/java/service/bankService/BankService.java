package service.bankService;

import exception.NotEnoughMoneyException;
import model.BankAccount;
import model.User;
import model.services.CommunalServices;
import model.services.Operations;
import model.services.Service;
import service.UserService;
import service.dbService.DBConnectService;
import service.dbService.DBUpdateService;
import service.dbService.DBWriteService;

import java.sql.Connection;
import java.sql.SQLException;

public class BankService {
    public void transferMoney(User user, String phoneNum){

    }

    public void payForServices(User user, Service service) throws NotEnoughMoneyException {
        UserService userService = new UserService();
        System.out.println("user  " + user.toString());
        System.out.println(service.getAccountNum());
        BankAccount account = userService.getAccount(user, service.getAccountNum());
        System.out.println("account sum " + account.getSum());
        if (account.getSum() >= service.getSum()) {
            account.setSum(account.getSum() - service.getSum());
            System.out.println("account sum " + account.getSum());

            Connection conn = null;
            try {
                conn = DBConnectService.getConnection();
                DBUpdateService.updateAccounts(conn, user, account);
                DBUpdateService.updateCards(conn, user, account);

                System.out.println("user id " + user.getId());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            DBConnectService.close(conn);
        } else throw new NotEnoughMoneyException("Недостаточно денег");
    }

    public void writeComServ(User user, CommunalServices cs, Operations op) {
        Connection conn = null;

        try {
            conn = DBConnectService.getConnection();
            DBWriteService.writeCommService(conn, user,cs, op);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
