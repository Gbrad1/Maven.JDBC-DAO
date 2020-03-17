package daos;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class testJDBC {

    CardDAO card = new CardDAO();
    CardDTO cardDTO = new CardDTO();

    @Test
    public void testRetrieveCard() {

        CardDTO newCard = card.findByCardNumber("6767977022348089");
        Assert.assertEquals("6767977022348089", newCard.getCredit_card_number());
    }

    @Test
    public void testFindCardByNumber() {
        CardDTO newCard = card.findByCardNumber("373434387191992");
        Assert.assertEquals("373434387191992", newCard.getCredit_card_number());
        Assert.assertEquals("Cletus", newCard.getFirst_name());
        Assert.assertEquals("Fallows", newCard.getLast_name());
    }
}
