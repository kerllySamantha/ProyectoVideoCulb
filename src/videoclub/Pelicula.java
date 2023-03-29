public class Pelicula extends Multimedia {
    private int duracion;
    private String actorPrincipal;
    private String actrizPrincipal;


    public Pelicula (String titulo, String autor, Formato formato, int anio, int duracion, String actor, String actriz) {
        super(titulo, autor, formato, anio);
        setDuracion(duracion);
        setActorPrincipal(actor);
        setActrizPrincipal(actriz);
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
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
                "\nDuración: " + getDuracion() +
                "\nActor principal: " + getActorPrincipal() +
                "\nActriz principal: " + getActrizPrincipal();
    }
}
