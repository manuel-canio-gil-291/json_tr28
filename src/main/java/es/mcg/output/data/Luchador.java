package es.mcg.output.data;

public class Luchador {
    private String equipo, nombre;
    private Integer duelos_ganados;

    public Luchador()
    {
        this.equipo = "";
        this.nombre = "";
        this.duelos_ganados = 0;
    }

    public Luchador(String equipo, String nombre, Integer duelos_ganados) {
        this.equipo = equipo;
        this.nombre = nombre;
        this.duelos_ganados = duelos_ganados;
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

    public Integer getDuelos_ganados() {
        return duelos_ganados;
    }

    public void setDuelos_ganados(Integer duelos_ganados) {
        this.duelos_ganados = duelos_ganados;
    }

    @Override
    public String toString() {
        return "Luchador [equipo=" + equipo + ", nombre=" + nombre + ", duelos_ganados=" + duelos_ganados + "]";
    }

    
}
