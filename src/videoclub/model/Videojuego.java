package model;

public class Videojuego extends Multimedia {
    private Plataforma plataforma;


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

    public Plataforma comprobarPlataforma(Plataforma plataforma) {
        for (int i = 0; i < Plataforma.values().length; i++) {
            if (Plataforma.values()[i].equals(plataforma)) {
                return Plataforma.values()[i];
            }
        }
        return Plataforma.PC;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nPlataforma: " + getPlataforma();
    }
}
