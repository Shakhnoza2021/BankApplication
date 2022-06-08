package service.dbService;

import model.User;
import model.services.CommunalServices;
import model.services.Operations;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBWriteService {
    public static void writeCommService(Connection con, User user, CommunalServices cs, Operations op) throws SQLException {
        Statement st = con.createStatement();
        st.executeUpdate("INSERT communal_services(name, sum, company, personal_account, doc_num, operations_id) " +
                "VALUES ('" + cs.getName() + "', " +cs.getSum() + ", '" + cs.getCompany() + "', '" + cs.getPersonalAcc() + "', '" +
                cs.getDocNumber() + "', " + getOperationsId(con, op) + ");");


    }

    private static int getOperationsId(Connection con, Operations op) throws SQLException {
        Statement st = con.createStatement();
        st.executeUpdate("INSERT operations(op_name, op_type, sum, user_id) VALUES ('" + op.getName() + "', '" + op.getType() + "', " + op.getSum() + ", " + op.getUserId() + ");");

        Statement statement = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT id FROM operations WHERE user_id = '" + op.getUserId() + "' AND sum = '" + op.getSum() + "'");

        while (rs.next()){
            op.setId(rs.getInt(1));
        }

        return op.getId();
    }
}
