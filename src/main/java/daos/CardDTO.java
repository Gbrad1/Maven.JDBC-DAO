package daos;

public class CardDTO {

    private String card_type;
    private String first_name;
    private String last_name;
    private String credit_card_number;
    private String ssn;

    public CardDTO(String card_type, String first_name, String last_name, String credit_card_number, String ssn) {
        this.card_type = card_type;
        this.first_name = first_name;
        this.last_name = last_name;
        this.credit_card_number = credit_card_number;
        this.ssn = ssn;
    }

    public CardDTO() { }

    public String getCard_type() {
        return card_type;
    }

    public void setCard_type(String card_type) {
        this.card_type = card_type;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getCredit_card_number() {
        return credit_card_number;
    }

    public void setCredit_card_number(String credit_card_number) {
        this.credit_card_number = credit_card_number;
    }

    public String getSSN() {
        return ssn;
    }

    public void setSSN(String ssn) {
        this.ssn = ssn;
    }
}
