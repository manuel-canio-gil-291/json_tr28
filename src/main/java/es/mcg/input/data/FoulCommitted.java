package es.mcg.input.data;

public class FoulCommitted {
    private Boolean advantage;
    private Card card;

    public FoulCommitted()
    {
        this.advantage = false;
    }

    public Boolean getAdvantage() {
        return advantage;
    }

    public void setAdvantage(Boolean advantage) {
        this.advantage = advantage;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
