package model;

import java.util.ArrayList;

public class Disco extends Multimedia{
    private ArrayList<model.Cancion> canciones;

    public Disco(String titulo, String artista, Formato formato, int anio) {
        super(titulo, artista, formato, anio);
        setCanciones(new ArrayList<>());
    }

    public ArrayList<model.Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(ArrayList<model.Cancion> canciones) {
        this.canciones = canciones;
    }

    public void agregarCancion(model.Cancion cancion) {
        this.canciones.add(cancion);
    }

    public String duracionDisco() {
        int duracionSeg = 0;
        for (model.Cancion cancion : canciones) {
            duracionSeg += cancion.getDuracionCancionSeg();
        }
        int duracionMin = duracionSeg / 60;
        int duracionSegFinal = duracionSeg % 60;
        return String.format("%02d:%02d", duracionMin, duracionSegFinal);
    }

    public String toString() {
        StringBuilder listaCaciones = new StringBuilder();
        for (model.Cancion cancion : this.canciones) {
            listaCaciones.append("\t").append(cancion.getTituloCancion()).append(" - ").append(cancion.getDuracionMinSeg()).append("\n");
        }
        return super.toString() +
                "\nDuración: " + duracionDisco() +
                "\nCanciones: \n" + listaCaciones;


    }
}

