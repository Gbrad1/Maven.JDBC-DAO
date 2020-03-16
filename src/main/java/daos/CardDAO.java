package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class CardDTO implements DAO{

    Connection connection = DatabaseConnectionEngine.getConnection();

    public CardDTO findBySSN(String ssn) {
        try {
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM CARD_DATA WHERE customer_ssn = ssn");
            if (resultSet.next()) {
                return retrieveUserData(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<CardDTO> findAll() {
        return null;
    }

    public Boolean update(CardDTO dto) {
        return null;
    }

    public Boolean create(CardDTO dto) {
        return null;
    }

    public Boolean delete(String ssn) { return null; }

    public CardDTO retrieveUserData(ResultSet resultSet) throws SQLException {
        CardDTO card = new CardDTO();
        card.setSSN(resultSet.getString("customer_ssn"));
        card.setCard_type(resultSet.getString("card_type"));
        card.setCredit_card_number(resultSet.getString("credit_card_number"));
        card.setFirst_name(resultSet.getString("first_name"));
        card.setLast_name(resultSet.getString("last_name"));

        return card;
    }

}
