package es.mcg.output.data;

public class DataOutput {
    private Goleador goleador;
    private Referencia referencia;
    private PorteroJugador portero_jugador;
    private Luchador luchador;
    private PorcentajesPosesion porcentajes_posesion;

    public DataOutput()
    {

    }

    public Goleador getGoleador() {
        return goleador;
    }

    public void setGoleador(Goleador goleador) {
        this.goleador = goleador;
    }

    public Referencia getReferencia() {
        return referencia;
    }

    public void setReferenciaEs(Referencia referencia) {
        this.referencia = referencia;
    }

    public void setReferenciaIt(Referencia referencia) {
        this.referencia = referencia;
    }

    public PorteroJugador getPortero_jugador() {
        return portero_jugador;
    }

    public void setPortero_jugador(PorteroJugador portero_jugador) {
        this.portero_jugador = portero_jugador;
    }

    public Luchador getLuchador() {
        return luchador;
    }

    public void setLuchador(Luchador luchador) {
        this.luchador = luchador;
    }

    public PorcentajesPosesion getPorcentajes_posesion() {
        return porcentajes_posesion;
    }

    public void setPorcentajes_posesion(PorcentajesPosesion porcentajes_posesion) {
        this.porcentajes_posesion = porcentajes_posesion;
    }

    @Override
    public String toString() {
        return "Goleador: " + goleador + "\nreferencia: " + referencia + "\nportero_jugador: "
                + portero_jugador + "\nluchador: " + luchador + "\nporcentajes_posesion: " + porcentajes_posesion;
    }

    
}
