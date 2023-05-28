package controller;

import model.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class GestionAlquilerMul {
    public static final int PRECIO_POR_DEFECTO = 4;
    public static final int ANIO_ACTUAL = 0;
    private Socio socio;
    private Multimedia multimediaAlquilado;
    private LocalDate fechaAlquiler;
    private int precio;

    public static ArrayList<GestionAlquilerMul>alquileres;

    public GestionAlquilerMul(Multimedia multimedia, Socio socio) {

        setFechaAlquiler(LocalDate.now());
        setMultimediaAlquilado(multimedia);
        setPrecio(calcularPrecio(multimedia));
        setSocio(socio);
    }

    public GestionAlquilerMul(Multimedia multimedia, LocalDate fecha, int precio, Socio socio) {
        setPrecio(precio);
        setFechaAlquiler(fecha);
        setMultimediaAlquilado(multimedia);
        setSocio(socio);
    }
    public Multimedia getMultimediaAlquilado() {
        return multimediaAlquilado;
    }

    public void setMultimediaAlquilado(Multimedia multimediaAlquilado) {
        this.multimediaAlquilado = multimediaAlquilado;
    }

    public LocalDate getFechaAlquiler() {
        return fechaAlquiler;
    }

    public void setFechaAlquiler(LocalDate fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public static int calcularPrecio(Multimedia m) {
        int precio = PRECIO_POR_DEFECTO;
        if (m instanceof Pelicula) {
            if (m.getAnio() < 2012) {
                precio--;
            } else if (m.getAnio() == ANIO_ACTUAL) {
                precio++;
            }
        } else if (m instanceof Videojuego) {
            if (m.getAnio() < 2010) {

            } else if (m.getAnio() == ANIO_ACTUAL) {
                precio++;
            }
        } else if (m instanceof Disco) {
            String minutos = ((Disco) m).getDuracion().substring(0, 2);
            if (Integer.parseInt(minutos) < 30) {
                precio--;
            }
        }
        return precio;
    }

    public static void eliminarAlquiler(Socio socio, Multimedia multimedia) {
        for (GestionAlquilerMul alquiler: alquileres) {
            if (alquiler.getMultimediaAlquilado().equals(multimedia) && alquiler.getSocio().equals(socio)) {
                alquileres.remove(alquiler);
            }
        }
    }
}
