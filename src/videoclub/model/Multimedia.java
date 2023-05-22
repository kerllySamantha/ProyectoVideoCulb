package model;

public abstract class Multimedia {
    private String titulo;
    private String autor;
    private Formato formato;
    private int anio;

    public Multimedia() {
        titulo = "";
        autor = "";
        formato = Formato.CD;
        anio = 0;
    }

    public Multimedia(String titulo, String autor, Formato fromato, int anio) {
        setTitulo(titulo);
        setAutor(autor);
        setFormato(fromato);
        setAnio(anio);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Formato getFormato() {
        return formato;
    }

    public void setFormato(Formato formato) {
        this.formato = comprobarFormato(formato);
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String toString() {
        return "Título: " + getTitulo() +
                "\nAutor: " + getAutor() +
                "\nFormato: " + getFormato() +
                "\nAño: " + getAnio();
    }

    public Formato comprobarFormato(Formato formato) {
        for (int i = 0; i < Formato.values().length; i++) {
            if (Formato.values()[i].equals(formato)) {
                return Formato.values()[i];
            }
        }
        return Formato.ARCHIVO;
    }

    @Override
    public boolean equals(Object obj) {
        Multimedia m = (Multimedia) obj;
        return (m.autor.equals(getAutor()) && m.titulo.equals(getTitulo()));
    }
}
