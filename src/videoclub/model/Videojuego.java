package model;

public class Videojuego extends Multimedia {
    private static final String [] plataformasDisponibles = {"PlayStation" , "Nintendo Switch", "XBox", "PC"};
    private String plataforma;


    public Videojuego() {
        super();
        plataforma = "";
    }

    public Videojuego(String titulo, String autor, Formato formato, int anio, String plataforma) {
        super(titulo, autor, formato, anio);
        setPlataforma(plataforma);
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = comprobarPlataforma(plataforma);
    }
    public String comprobarPlataforma(String plataforma) {
        for (int i = 0; i < plataformasDisponibles.length; i++) {
            if (plataformasDisponibles[i].equalsIgnoreCase(plataforma)) {
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
