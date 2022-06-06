package service.bankService;

import model.BankAccount;
import model.Card;
import model.Credit;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommonService {

    public static void setFieldsFromResultSet(Credit credit, ResultSet rs) throws SQLException {
        credit.setName(rs.getString("credit_name"));
        credit.setId(rs.getInt("id"));
        credit.setTerm(rs.getInt("term"));
        credit.setSum(rs.getDouble("credit_sum"));
        credit.setPercent(rs.getDouble("percent"));
        credit.setMonthlyPayment(rs.getDouble("monthly_payment"));
        credit.setDateOfIssue(rs.getDate("date_of_issue"));
        credit.setLastPayment(rs.getDate("last_payment"));
        credit.setTotalPayed(rs.getDouble("total_payed"));
        credit.setRemainsToPay(rs.getDouble("remains_to_pay"));
        credit.setUserId(rs.getInt("user_id"));
    }

    public static void setFieldsFromResultSet(Card card, ResultSet rs) throws SQLException {
        card.setId((rs.getInt("id")));
        card.setName((rs.getString("card_name")));
        card.setType((rs.getString("card_type")));
        card.setSum((rs.getDouble("card_sum")));
        card.setPercent((rs.getDouble("percent")));
        card.setCardNum((rs.getString("card_num")));
        card.setUserId((rs.getInt("user_id")));
    }

    public static void setFieldsFromResultSet(BankAccount account, ResultSet rs) throws SQLException {
        account.setId((rs.getInt("id")));
        account.setName((rs.getString("account_name")));
        account.setSum((rs.getDouble("account_sum")));
        account.setAccountNum((rs.getString("account_num")));
    }
}
