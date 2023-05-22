package model;

import java.util.ArrayList;

public class Pelicula extends Multimedia {
    private String duracionPelicula, actorPrincipal, actrizPrincipal, genero;



    public Pelicula (String titulo, String autor, Formato formato, int anio, String duracion, String actriz, String actor, String genero) {
        super(titulo, autor, formato, anio);
        setDuracionPelicula(duracion);
        setActorPrincipal(actor);
        setActrizPrincipal(actriz);
    }

    public String getDuracionPelicula() {
        return duracionPelicula;
    }

    public void setDuracionPelicula(String duracion) {
        this.duracionPelicula = duracion;
    }

    public String getActorPrincipal() {
        return actorPrincipal;
    }

    public void setActorPrincipal(String actorPrincipal) {
        this.actorPrincipal = actorPrincipal;
    }

    public String getActrizPrincipal() {
        return actrizPrincipal;
    }

    public void setActrizPrincipal(String actrizPrincipal) {
        this.actrizPrincipal = actrizPrincipal;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public static boolean buscarPelicula(ArrayList<Multimedia> multimedia, String titulo) {
        for (Multimedia pelicula : multimedia) {
            if (titulo.equalsIgnoreCase(pelicula.getTitulo())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nDuración: " + getDuracionPelicula() +
                "\nActor principal: " + getActorPrincipal() +
                "\nActriz principal: " + getActrizPrincipal()+
                "\nGenero: " + getGenero();
    }
}
