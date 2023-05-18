package model;

import java.util.ArrayList;

public class Disco extends Multimedia{
    private ArrayList<Cancion> canciones;

    public Disco(String titulo, String artista, Formato formato, int anio) {
        super(titulo, artista, formato, anio);
        setCanciones(new ArrayList<>());
    }

    public ArrayList<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(ArrayList<Cancion> canciones) {
        this.canciones = canciones;
    }

    public void agregarCancion(Cancion cancion) {
        this.canciones.add(cancion);
    }

    public String duracionDisco() {
        int duracionSeg = 0;
        for (Cancion cancion : canciones) {
            duracionSeg += cancion.getDuracionCancionSeg();
        }
        int duracionMin = duracionSeg / 60;
        int duracionSegFinal = duracionSeg % 60;
        return String.format("%02d:%02d", duracionMin, duracionSegFinal);
    }

    public String toString() {
        String listaCaciones = "";
        for (Cancion cancion : this.canciones) {
            listaCaciones += "\t" + cancion.getTituloCancion() + " - " + cancion.getDuracionMinSeg() + "\n";
        }
        return super.toString() +
                "\nDuración: " + duracionDisco() +
                "\nCanciones: \n" + listaCaciones;
    }
}

