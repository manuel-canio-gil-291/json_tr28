package es.mcg.input.data;

public class Dribble {
    private Boolean nutmeg;
    private Outcome outcome;
    private Boolean overrun;

    public Dribble()
    {
        this.nutmeg = false;
        this.overrun = false;
    }

    public Boolean getNutmeg() {
        return nutmeg;
    }

    public void setNutmeg(Boolean nutmeg) {
        this.nutmeg = nutmeg;
    }

    public Outcome getOutcome() {
        return outcome;
    }

    public void setOutcome(Outcome outcome) {
        this.outcome = outcome;
    }

    public Boolean getOverrun() {
        return overrun;
    }

    public void setOverrun(Boolean overrun) {
        this.overrun = overrun;
    }
}
