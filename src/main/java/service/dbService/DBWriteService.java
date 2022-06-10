package service.dbService;

import model.User;
import model.services.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBWriteService {
    public static void writeUser(Connection conn, User user) throws SQLException {
        Statement st = conn.createStatement();
        st.executeUpdate("INSERT users(name, last_name, patronymic, phone_number, email) " +
                "VALUES ('" + user.getName() + "', '" + user.getLastName() +
                "', '" + user.getPatronymic() + "', '" + user.getPhoneNum() +
                "', '" + user.getEmail() + "');");
    }

    public static int getCommServiceId(Connection con, CommunalServices cs) throws SQLException {
        Statement st = con.createStatement();
        st.executeUpdate("INSERT communal_services(name, sum, company, personal_account, doc_num) " +
                "VALUES ('" + cs.getName() + "', " +cs.getSum() + ", '" + cs.getCompany() + "', '" + cs.getPersonalAcc() + "', '" +
                cs.getDocNumber() + "');");

        Statement statement = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT id FROM communal_services WHERE doc_num = '" + cs.getDocNumber() + "' AND personal_account = '" + cs.getPersonalAcc() + "'");

        while (rs.next()){
            cs.setId(rs.getInt(1));
        }

        return cs.getId();
    }

    public static int getFineId(Connection con, Fine fine) throws SQLException {
        Statement st = con.createStatement();
        st.executeUpdate("INSERT fines(company, sum, doc_num) " +
                "VALUES ('" + fine.getCompany() + "', " + fine.getSum() + ", '" + fine.getDocNumber() + "');");

        Statement statement = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT id FROM fines WHERE doc_num = '" + fine.getDocNumber() + "'");

        while (rs.next()){
            fine.setId(rs.getInt(1));
        }

        return fine.getId();
    }

    public static int getPhoneComId(Connection con, PhoneCommunication phc) throws SQLException {
        Statement st = con.createStatement();
        st.executeUpdate("INSERT phone_communications(provider, phone_num, sum) " +
                "VALUES ('" + phc.getProvider() + "', '" + phc.getPhoneNumber() + "', " + phc.getSum() + ");");

        Statement statement = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT id FROM phone_communications WHERE phone_num = '" + phc.getPhoneNumber() + "'");

        while (rs.next()){
            phc.setId(rs.getInt(1));
        }

        return phc.getId();
    }

    public static int getTransferId(Connection con, Transfer transfer) throws SQLException {
        Statement st = con.createStatement();
        st.executeUpdate("INSERT transfer(card_from, card_to, sum) " +
                "VALUES ('" + transfer.getCardFrom() +
                "', '" + transfer.getCardTo() + "', " + transfer.getSum() + ");");

        Statement statement = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT id FROM transfer " +
                "WHERE card_from = '" + transfer.getCardFrom() + "' AND card_to = '" + transfer.getCardTo() + "';");

        while (rs.next()){
            transfer.setId(rs.getInt(1));
        }

        return transfer.getId();
    }

    public static void writeOperation(Connection con, Operations op, PhoneCommunication phc) throws SQLException {
        Statement st = con.createStatement();
        st.executeUpdate("INSERT operations(op_name, op_type, sum, card_number, user_id, phone_com_id) VALUES ('" + op.getName() +
                "', '" + op.getType() + "', " + op.getSum() + ", '" + op.getCardNum() + "', " + op.getUserId() + ", " + getPhoneComId(con, phc) + ");");
    }

    public static void writeOperation(Connection con, Operations op, CommunalServices cs) throws SQLException {
        Statement st = con.createStatement();
        st.executeUpdate("INSERT operations(op_name, op_type, sum, card_number, user_id, com_serv_id) VALUES ('" + op.getName() +
                "', '" + op.getType() + "', " + op.getSum() + ", '" + op.getCardNum() + "', " + op.getUserId() + ", " + getCommServiceId(con, cs) + ");");
    }
    public static void writeOperation(Connection con, Operations op, Fine fine) throws SQLException {
        Statement st = con.createStatement();
        st.executeUpdate("INSERT operations(op_name, op_type, sum, card_number, user_id, fine_id) VALUES ('" + op.getName() +
                "', '" + op.getType() + "', " + op.getSum() + ", '" + op.getCardNum() + "', " + op.getUserId() + ", " + getFineId(con, fine) + ");");
    }

    public static void writeOperation(Connection con, Operations op, Transfer transfer) throws SQLException {
        Statement st = con.createStatement();
        st.executeUpdate("INSERT operations(op_name, op_type, sum, card_number, user_id, fine_id) VALUES ('" + op.getName() +
                "', '" + op.getType() + "', " + op.getSum() + ", '" + op.getCardNum() + "', " + op.getUserId() + ", " + getTransferId(con, transfer) + ");");
    }

}
