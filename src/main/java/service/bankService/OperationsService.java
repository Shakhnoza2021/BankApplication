package service.bankService;

import model.BankAccount;
import model.User;
import model.services.Operations;
import service.dbService.DBConnectService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OperationsService {
    public List<Operations> getAccOperations(String accNum) {
        Connection conn = null;
        List<Operations> operations = new ArrayList<>();

        try {
            conn = DBConnectService.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM operations WHERE account_num = " + accNum + ";");

            while (rs.next()){
                Operations o = new Operations();
                CommonService.setFieldsFromResultSet(o, rs);
                operations.add(o);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println("operations  " + operations);
        DBConnectService.close(conn);
        return operations;
    }

    public List<Operations> getAccOperations() {
        Connection conn = null;
        List<Operations> operations = new ArrayList<>();

        try {
            conn = DBConnectService.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM operations;");

            while (rs.next()){
                Operations o = new Operations();
                CommonService.setFieldsFromResultSet(o, rs);
                operations.add(o);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println("operations  " + operations);
        DBConnectService.close(conn);
        return operations;
    }
}
