package daos;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class testJDBC {

    CardDAO card = new CardDAO();
    CardDTO cardDTO = new CardDTO(
            "mastercard",
            "JACK",
            "SPARROW",
            "3872015583410474",
            "748-48-8216");

    CardDTO anotherCard = new CardDTO(
            "mastercard",
            "Sonic",
            "The hedgehog",
            "7837211063007428",
            "540-86-9122"
    );

    CardDTO linksCard = new CardDTO(
            "mastercard",
            "Link",
            "link",
            "7308620549979121",
            "740-88-6233"
    );

    @Test
    public void testRetrieveUserData() {
        CardDTO newCard = card.findByCardNumber("6767977022348089");
        Assert.assertEquals("6767977022348089", newCard.getCredit_card_number());
    }

    @Test
    public void testFindCardByNumber() {
        CardDTO newCard = card.findByCardNumber("373434387191992");
        Assert.assertEquals("373434387191992", newCard.getCredit_card_number());
        Assert.assertEquals("Cletus", newCard.getFirst_name());
        Assert.assertEquals("Fallows", newCard.getLast_name());
        Assert.assertEquals("americanexpress", newCard.getCard_type());
    }

    @Test
    public void testCreateCard() {
        Assert.assertTrue(card.create(cardDTO));
        CardDTO newCard = card.findByCardNumber("3872015583410474");
        Assert.assertEquals("3872015583410474", newCard.getCredit_card_number());
        card.delete("3872015583410474");
    }

    @Test
    public void testDeleteCard() {
        Assert.assertTrue(card.create(anotherCard));
        Assert.assertTrue(card.delete("7837211063007428"));
    }

    @Test
    public void testFindAll() {
        List<CardDTO> list = card.findAll();
        int actualSize = list.size();
        int expectedSize = 9;
        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void testAddLinksCard() {
        Assert.assertTrue(card.create(linksCard));
        CardDTO linksCard = card.findByCardNumber("7308620549979121");
        Assert.assertEquals("7308620549979121", linksCard.getCredit_card_number());
        Assert.assertTrue(card.delete("7308620549979121"));
    }

    @Test
    public void testUpdate() {
        card.create(linksCard);
        String newLastName = "Link";
        linksCard.setLast_name(newLastName);
        card.update(linksCard);
        Assert.assertEquals("Link", linksCard.getLast_name());
        card.delete("7308620549979121");
    }

}
