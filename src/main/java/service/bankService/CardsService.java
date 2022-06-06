package service.bankService;

import model.Card;
import model.User;
import service.dbService.DBService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CardsService {
    public List<Card> getUserCards(User user) {
        Connection conn = null;
        List<Card> cards = new ArrayList<>();

        try {
            conn = DBService.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM cards WHERE user_id = " + user.getId() + ";");
            //System.out.println("rs  " + rs.getInt("id"));
            System.out.println("user id " + user.getId());
            while (rs.next()){
                Card card = new Card();
                CommonService.setFieldsFromResultSet(card, rs);
                cards.add(card);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println("cards " + cards);
        DBService.close(conn);
        return cards;
    }
}
