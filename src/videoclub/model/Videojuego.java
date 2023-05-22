package model;

public class Videojuego extends Multimedia {
    private static final String [] plataformasDisponibles = {"PlayStation" , "Nintendo Switch", "XBox", "PC"};
    //private String plataforma;
    private Plataforma plataforma;

    public Videojuego() {
        super();
        setPlataforma(plataforma);
    }

    public Videojuego(String titulo, String autor, Formato formato, int anio, Plataforma plataforma) {
        super(titulo, autor, formato, anio);
        setPlataforma(plataforma);
    }
    private void setPlataforma(Plataforma plataforma) {
        this.plataforma=plataforma;
    }

    public Plataforma getPlataforma() {
        return plataforma;
    }

    public String comprobarPlataforma(Plataforma plataforma) {
        for (int i = 0; i < plataformasDisponibles.length; i++) {
            if (plataformasDisponibles[i].equalsIgnoreCase(String.valueOf(plataforma))) {
                return plataformasDisponibles[i];
            }
        }
        return "PC";
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nPlataforma: " + getPlataforma();
    }
}
