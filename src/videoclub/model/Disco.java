package model;

import controller.GestionMultimedia;

import java.util.ArrayList;

public class Disco extends Multimedia {
    private String duracion;
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

    public static void agregarCancion(ArrayList<Multimedia> multimedias, ArrayList<Cancion>canciones) {
        for (Cancion cancion: canciones) {
            for (Multimedia m : multimedias) {
                if (m instanceof Disco) {
                    if(m.getAutor().equalsIgnoreCase(cancion.getAutor())){
                        ((Disco) m).getCanciones().add(cancion);
                        ((Disco) m).setDuracion(((Disco) m).duracionDisco());
                    }
                }
            }
        }
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
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
        StringBuilder listaCaciones = new StringBuilder();
        for (model.Cancion cancion : this.canciones) {
            listaCaciones.append("\t").append(cancion.getTituloCancion()).append(" - ").append(cancion.getDuracionMinSeg()).append("\n");
        }
        return super.toString() +
                "\nDuración: " + getDuracion() +
                "\nAutor: " + getAutor()+
                "\nCanciones: \n\t" + listaCaciones + "\n";
    }
}

