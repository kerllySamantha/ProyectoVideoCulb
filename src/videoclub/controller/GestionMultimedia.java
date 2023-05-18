package controller;

import model.*;

import java.util.ArrayList;
import java.util.Comparator;

public class GestionMultimedia {
    public static ArrayList<Multimedia>multimedias = new ArrayList<>();

    public static String ordenarMultimedia() {

        String listaMultimedia = "";
        GestionMultimedia.multimedias.sort(new Comparator<Multimedia>() {
            public int compare(Multimedia p1, Multimedia p2) {
                return p1.getTitulo().compareTo(p2.getTitulo());
            }
        });

        for (Multimedia multimedia1 : multimedias) {
            listaMultimedia += "Título: " + multimedia1.getTitulo() + "\nAño: " + multimedia1.getAnio() + "\nTipo: " + multimedia1.getClass().getName().substring(6);
        }
        return listaMultimedia;
    }

    public static String ordenarPeliculas() {
        String listaPeliculas = "";
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        for (Multimedia m : multimedias) {
            if (m instanceof Pelicula) {
                peliculas.add((Pelicula) m);
            }
        }
        peliculas.sort(new Comparator<Pelicula>() {
            public int compare(Pelicula p1, Pelicula p2) {
                return p1.getTitulo().compareTo(p2.getTitulo());
            }
        });

        for (Pelicula p : peliculas) {
            listaPeliculas += "Título: " + p.getTitulo() + "\nAño: " + p.getAnio() + "\nTipo: " + p.getClass().getName().substring(6);

        }
        return listaPeliculas;
    }


    public static String listaVideojuegos() {
        String listaVideojuegos = "";
        ArrayList<Videojuego> videojuegos = new ArrayList<>();
        for (Multimedia m : multimedias) {
            if (m instanceof Pelicula) {
                videojuegos.add((Videojuego) m);
            }
        }
        videojuegos.sort(new Comparator<Videojuego>() {
            public int compare(Videojuego v1, Videojuego v2) {
                return Integer.compare(v1.getAnio(), (v2.getAnio()));
            }
        });
        for (Videojuego v : videojuegos) {
            listaVideojuegos += "Título: " + v.getTitulo() + "\nAño: " + v.getAnio() + "\nTipo: " + v.getClass().getName().substring(6);

        }
        return listaVideojuegos;
    }

    public static String ordenarDiscos() {
        String listaDiscos = "";
        ArrayList<Disco> discos = new ArrayList<>();

        for (Multimedia m : multimedias) {
            if (m instanceof Disco) {
                discos.add((Disco) m);
            }
        }
        for (Disco d : discos) {
            d.getCanciones().sort(new Comparator<Cancion>() {
                public int compare(Cancion c1, Cancion c2) {
                    return Integer.compare(c1.getDuracionCancionSeg(), (c2.getDuracionCancionSeg()));
                }
            });
            listaDiscos += "Nombre del disco: " + d.getTitulo() + "\nCanciones: \n";

            for (Cancion c: d.getCanciones()) {
                listaDiscos += "\t" + c.getTituloCancion() + "\n";
            }
        }
        return listaDiscos;
    }
}