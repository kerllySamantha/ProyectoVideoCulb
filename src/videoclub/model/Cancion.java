package model;

public class Cancion {
    private String tituloCancion;
    private String duracionMinSeg;
    private int duracionCancionSeg;

    public Cancion(String titulo, int duracion) {
        setNombreCancion(titulo);
        setDuracionCancion(duracion);
    }

    public Cancion(String titulo, String duracion) {
        setNombreCancion(titulo);
        setDuracionMinSeg(duracion);
        String[] tiempo = duracion.split(":");
        setDuracionCancion(Integer.parseInt(tiempo[0]) * 60 + Integer.parseInt(tiempo[1]));
    }

    public String getDuracionMinSeg() {
        return duracionMinSeg;
    }

    public void setDuracionMinSeg(String duracionMinSeg) {
        this.duracionMinSeg = duracionMinSeg;
    }

    public String getTituloCancion() {
        return tituloCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.tituloCancion = nombreCancion;
    }

    public double getDuracionCancionSeg() {
        return duracionCancionSeg;
    }

    public void setDuracionCancion(int duracionCancionSeg) {
        this.duracionCancionSeg = duracionCancionSeg;
    }
}

