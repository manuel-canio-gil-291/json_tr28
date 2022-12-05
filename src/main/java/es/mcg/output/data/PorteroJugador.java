package es.mcg.output.data;

public class PorteroJugador {
    private String equipo, nombre;
    private Integer pases;

    public PorteroJugador()
    {
        this.equipo = "";
        this.nombre = "";
        this.pases = 0;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPases() {
        return pases;
    }

    public void setPases(Integer pases) {
        this.pases = pases;
    }

    
}
