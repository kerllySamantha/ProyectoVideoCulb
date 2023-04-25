package model;

public class Cancion {
    private String nombreCancion;
    private double duracionCancion;

    public Cancion(String nombre, double duracion) {
        setNombreCancion(nombre);
        setDuracionCancion(duracion);
    }

    public String getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    public double getDuracionCancion() {
        return duracionCancion;
    }

    public void setDuracionCancion(double duracionCancion) {
        this.duracionCancion = duracionCancion;
    }
}
