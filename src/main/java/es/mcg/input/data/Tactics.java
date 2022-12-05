package es.mcg.input.data;

public class Tactics {
    private Integer formation;
    private Lineup lineup;

    public Tactics()
    {
        this.formation = 0;
    }

    public Integer getFormation() {
        return formation;
    }

    public void setFormation(Integer formation) {
        this.formation = formation;
    }

    public Lineup getLineup() {
        return lineup;
    }

    public void setLineup(Lineup lineup) {
        this.lineup = lineup;
    }
}
