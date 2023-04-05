package model;

public class Pelicula extends Multimedia {
    private int duracionPelicula;
    private String actorPrincipal;
    private String actrizPrincipal;


    public Pelicula (String titulo, String autor, Formato formato, int anio, int duracion, String actriz, String actor) {
        super(titulo, autor, formato, anio);
        setDuracionPelicula(duracion);
        setActorPrincipal(actor);
        setActrizPrincipal(actriz);
    }

    public int getDuracionPelicula() {
        return duracionPelicula;
    }

    public void setDuracionPelicula(int duracion) {
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

    @Override
    public String toString() {
        return super.toString() +
                "\nDuración: " + getDuracionPelicula() +
                "\nActor principal: " + getActorPrincipal() +
                "\nActriz principal: " + getActrizPrincipal();
    }
}
