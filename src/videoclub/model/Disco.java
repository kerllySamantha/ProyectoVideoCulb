package model;

import java.util.ArrayList;

public class Disco extends Multimedia{
    private double duracionDisco;
    private ArrayList<Cancion> canciones;

    public Disco(String titulo, String artista, Formato formato, int anio) {
        super(titulo, artista, formato, anio);
        setDuracionDisco(0);
        setCanciones(new ArrayList<>());
    }

    public double getDuracionDisco() {
        return duracionDisco;
    }

    public void setDuracionDisco(double duracion) {
        this.duracionDisco = duracion;
    }

    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(ArrayList<Cancion> canciones) {
        this.canciones = canciones;
    }

    public void agregarCancion(String nombre, double duracion) {
        Cancion cancion = new Cancion(nombre, duracion);
        this.canciones.add(cancion);
        this.duracionDisco += getDuracionDisco() + duracion;
    }

    public void eliminarCancion(Cancion cancion) {
        this.duracionDisco -= cancion.getDuracionCancion();
        getCanciones().remove(cancion);
    }

    public String toString() {
        String listaCaciones = "";
        for (Cancion cancion : this.canciones) {
            listaCaciones += cancion.getNombreCancion() + " - " + cancion.getDuracionCancion() + "\n";
        }
        return super.toString() +
                "\nDuración: " + getDuracionDisco() +
                "\nCanciones: \n" + listaCaciones;


    }
}
