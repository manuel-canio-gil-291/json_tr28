package es.mcg.output.data;

public class Referencia {
    private String equipo, nombre;
    private Integer pases;

    public Referencia()
    {
        this.equipo = "";
        this.nombre = "";
        this.pases = 0;
    }

    public Referencia(String equipo, String nombre, Integer pases) {
        this.equipo = equipo;
        this.nombre = nombre;
        this.pases = pases;
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

    @Override
    public String toString() {
        return "[\n\tequipo: " + equipo + "\n\tnombre: " + nombre + "\n\tpases: " + pases + "\n]";
    }

    
}
