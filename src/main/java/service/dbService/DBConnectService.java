package service.dbService;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBConnectService {

    public static Connection getConnection() throws SQLException {
        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = getConnectionDM();
            System.out.println("Подключение к базе данных выполнено успешно");
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return conn;
    }


    private static Connection getConnectionDM() throws IOException, SQLException {
        //Properties props = new Properties();
        //System.out.println(Paths.get("database.properties"));
        ResourceBundle props = ResourceBundle.getBundle("database");
/*        try(InputStream in = Files.newInputStream(Paths.get("database.properties"))){
            System.out.println(in);
            props.load(in);
        }*/
        String url = props.getString("url");
        String username = props.getString("username");
        String password = props.getString("password");

        return DriverManager.getConnection(url, username, password);
    }

    public static void close(Connection conn){
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
