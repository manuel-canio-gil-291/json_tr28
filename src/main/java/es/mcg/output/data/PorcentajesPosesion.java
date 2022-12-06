package es.mcg.output.data;

public class PorcentajesPosesion {
    private PrimerTiempo primer_tiempo;
    private SegundoTiempo segundo_tiempo;
    private PartidoCompleto partido_completo;

    public PorcentajesPosesion()
    {

    }
    
    public PorcentajesPosesion(PrimerTiempo primer_tiempo, SegundoTiempo segundo_tiempo,
            PartidoCompleto partido_completo) {
        this.primer_tiempo = primer_tiempo;
        this.segundo_tiempo = segundo_tiempo;
        this.partido_completo = partido_completo;
    }

    public PrimerTiempo getPrimer_tiempo() {
        return primer_tiempo;
    }

    public void setPrimer_tiempo(PrimerTiempo primer_tiempo) {
        this.primer_tiempo = primer_tiempo;
    }

    public SegundoTiempo getSegundo_tiempo() {
        return segundo_tiempo;
    }

    public void setSegundo_tiempo(SegundoTiempo segundo_tiempo) {
        this.segundo_tiempo = segundo_tiempo;
    }

    public PartidoCompleto getPartido_completo() {
        return partido_completo;
    }

    public void setPartido_completo(PartidoCompleto partido_completo) {
        this.partido_completo = partido_completo;
    }
}
