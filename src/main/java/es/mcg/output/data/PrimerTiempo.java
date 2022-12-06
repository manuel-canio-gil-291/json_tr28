package es.mcg.output.data;

public class PrimerTiempo {
    private Double espania, italia;

    public PrimerTiempo()
    {
        this.espania = 0.0;
        this.italia = 0.0;
    }

    public PrimerTiempo(Double espania, Double italia) {
        this.espania = espania;
        this.italia = italia;
    }

    public Double getEspania() {
        return espania;
    }

    public void setEspania(Double espania) {
        this.espania = espania;
    }

    public Double getItalia() {
        return italia;
    }

    public void setItalia(Double italia) {
        this.italia = italia;
    }
}
