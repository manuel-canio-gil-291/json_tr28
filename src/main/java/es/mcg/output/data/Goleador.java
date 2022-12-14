package es.mcg.output.data;

public class Goleador {
    private String equipo, nombre;
    private Integer minuto, segundo;

    public Goleador()
    {
        this.equipo = "";
        this.nombre = "";
        this.minuto = 0;
        this.segundo = 0;
    }

    public Goleador(String equipo, String nombre, Integer minuto, Integer segundo) {
        this.equipo = equipo;
        this.nombre = nombre;
        this.minuto = minuto;
        this.segundo = segundo;
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

    public Integer getMinuto() {
        return minuto;
    }

    public void setMinuto(Integer minuto) {
        this.minuto = minuto;
    }

    public Integer getSegundo() {
        return segundo;
    }

    public void setSegundo(Integer segundo) {
        this.segundo = segundo;
    }

    @Override
    public String toString() {
        return "[\n\tequipo: " + equipo + "\n\tnombre: " + nombre + "\n\tminuto: " + minuto + "\n\tsegundo: " + segundo + "\n]";
    }
}
