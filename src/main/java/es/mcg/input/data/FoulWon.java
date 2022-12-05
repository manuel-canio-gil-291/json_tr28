package es.mcg.input.data;

public class FoulWon {
    private Boolean defensive, advantage;

    public FoulWon()
    {
        this.defensive = false;
        this.advantage = false;
    }

    public Boolean getDefensive() {
        return defensive;
    }

    public void setDefensive(Boolean defensive) {
        this.defensive = defensive;
    }

    public Boolean getAdvantage() {
        return advantage;
    }

    public void setAdvantage(Boolean advantage) {
        this.advantage = advantage;
    }
}
