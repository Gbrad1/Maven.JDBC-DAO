package daos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CardDAO implements DAO {

    Connection connection = DatabaseConnectionEngine.getConnection();

    public CardDTO findByCardNumber(String cardNum) {
        try {
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM CARD_DATA WHERE credit_card_number =" + cardNum);
            if (resultSet.next()) {
                return retrieveUserData(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<CardDTO> findAll() {
        List<CardDTO> list = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM CARD_DATA");
            while (resultSet.next()) {
                list.add(retrieveUserData(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Boolean update(CardDTO dto) {
        try {
            PreparedStatement stmt = connection.prepareStatement("UPDATE CARD_DATA SET card_type=?, first_name=?, last_name=?, customer_ssn=? WHERE credit_card_number=?");
            stmt.setString(1, dto.getCard_type());
            stmt.setString(2, dto.getFirst_name());
            stmt.setString(3, dto.getLast_name());
            stmt.setString(4, dto.getSSN());
            stmt.setString(5, dto.getCredit_card_number());

            int i = stmt.executeUpdate();

            if(i == 1){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean create(CardDTO dto) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO CARD_DATA VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, dto.getCard_type());
            ps.setString(2, dto.getFirst_name());
            ps.setString(3, dto.getLast_name());
            ps.setString(4, dto.getCredit_card_number());
            ps.setString(5, dto.getSSN());
            int i = ps.executeUpdate();

            if (i == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean delete(String cardNum) {

        try {
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM CARD_DATA WHERE credit_card_number=" + cardNum);

            if (i == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

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
