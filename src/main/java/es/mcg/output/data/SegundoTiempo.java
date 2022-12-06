package es.mcg.output.data;

public class SegundoTiempo {
    private Double espania, italia;

    public SegundoTiempo()
    {
        this.espania = 0.0;
        this.italia = 0.0;
    }

    public SegundoTiempo(Double espania, Double italia) {
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
