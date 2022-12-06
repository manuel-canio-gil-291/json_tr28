package es.mcg.output.data;

public class PartidoCompleto {
    private Double espania, italia;

    public PartidoCompleto()
    {
        this.espania = 0.0;
        this.italia = 0.0;
    }

    public PartidoCompleto(Double espania, Double italia) {
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
