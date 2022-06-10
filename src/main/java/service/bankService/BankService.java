package service.bankService;

import exception.NotEnoughMoneyException;
import model.BankAccount;
import model.Card;
import model.User;
import model.services.*;
import service.UserService;
import service.dbService.DBConnectService;
import service.dbService.DBSelectService;
import service.dbService.DBUpdateService;
import service.dbService.DBWriteService;

import java.sql.Connection;
import java.sql.SQLException;

public class BankService {
    public void transferMoney(String cardNumFrom, String cardNumTo, double sum) throws NotEnoughMoneyException {
        Card cardFrom = DBSelectService.getCard(cardNumFrom);
        Card cardTo = DBSelectService.getCard(cardNumTo);
        if (cardFrom.getSum() >= sum) {
            cardFrom.setSum(cardFrom.getSum() - sum);
            cardTo.setSum(cardTo.getSum() + sum);
        } else throw new NotEnoughMoneyException("Недостаточно денег на карте");

        Connection conn = null;
        try {
            conn = DBConnectService.getConnection();
            DBUpdateService.updateCards(conn, cardFrom);
            DBUpdateService.updateCards(conn, cardTo);
            DBUpdateService.updateAccounts(conn, cardFrom);
            DBUpdateService.updateAccounts(conn, cardTo);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void payForServices(User user, Operations operation) throws NotEnoughMoneyException {
        UserService userService = new UserService();
        System.out.println("user  " + user.toString());
        System.out.println(operation.getCardNum());
        Card card = userService.getCard(user, operation.getCardNum());
        System.out.println("card sum " + card.getSum());
        if (card.getSum() >= operation.getSum()) {
            card.setSum(card.getSum() - operation.getSum());
            System.out.println("card sum " + card.getSum());

            Connection conn = null;
            try {
                conn = DBConnectService.getConnection();
                DBUpdateService.updateAccounts(conn, card);
                DBUpdateService.updateCards(conn, card);

                System.out.println("user id " + user.getId());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            DBConnectService.close(conn);
        } else throw new NotEnoughMoneyException("Недостаточно денег");
    }

    public void writeOperation(User user, PhoneCommunication phc, Operations op) {
        Connection conn = null;

        try {
            conn = DBConnectService.getConnection();
            DBWriteService.writeOperation(conn, op, phc);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBConnectService.close(conn);
    }

    public void writeOperation(User user, CommunalServices cs, Operations op) {
        Connection conn = null;

        try {
            conn = DBConnectService.getConnection();
            DBWriteService.writeOperation(conn, op, cs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBConnectService.close(conn);
    }

    public void writeOperation(User user, Fine fine, Operations op) {
        Connection conn = null;

        try {
            conn = DBConnectService.getConnection();
            DBWriteService.writeOperation(conn, op, fine);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBConnectService.close(conn);
    }
    public void writeOperation(User user, Transfer transfer, Operations op) {
        Connection conn = null;

        try {
            conn = DBConnectService.getConnection();
            DBWriteService.writeOperation(conn, op, transfer);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBConnectService.close(conn);
    }

}
