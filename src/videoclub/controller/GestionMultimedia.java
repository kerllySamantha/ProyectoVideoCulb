package controller;

import model.*;

import java.util.ArrayList;
import java.util.Comparator;

public class GestionMultimedia {
    public static ArrayList<Multimedia>multimedias = new ArrayList<>();

    public static String ordenarMultimedia() {

        StringBuilder listaMultimedia = new StringBuilder();
        GestionMultimedia.multimedias.sort(new Comparator<Multimedia>() {
            public int compare(Multimedia p1, Multimedia p2) {

                return p1.getTitulo().compareTo(p2.getTitulo());
            }
        });

        for (Multimedia multimedia1 : multimedias) {
            listaMultimedia.append("Título: ")
                    .append(multimedia1.getTitulo()).append("\nAño: ")
                    .append(multimedia1.getAnio()).append("\nTipo: ")
                    .append(multimedia1.getClass().getName().substring(6)).append("\n");
            //listaMultimedia.append(multimedia1.toString());
        }
        return listaMultimedia.toString();
    }

    public static String ordenarPeliculas() {
        StringBuilder listaPeliculas = new StringBuilder();
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
            listaPeliculas.append("Título: ").append(p.getTitulo()).append("\nAño: ").append(p.getAnio()).append("\nTipo: ")
                    .append(p.getClass().getName().substring(6));

        }
        return listaPeliculas.toString();
    }


    public static String listaVideojuegos() {
        StringBuilder listaVideojuegos = new StringBuilder();
        ArrayList<Videojuego> videojuegos = new ArrayList<>();
        for (Multimedia m : multimedias) {
            if (m instanceof Videojuego) {
                videojuegos.add((Videojuego) m);
            }
        }
        videojuegos.sort(new Comparator<Videojuego>() {
            public int compare(Videojuego v1, Videojuego v2) {
                return Integer.compare(v1.getAnio(), (v2.getAnio()));
            }
        });
        for (Videojuego v : videojuegos) {
            listaVideojuegos.append("Título: ").append(v.getTitulo()).append("\nAño: ").append(v.getAnio())
                    .append("\nTipo: ").append(v.getClass().getName().substring(6));

        }
        return listaVideojuegos.toString();
    }

    public static String ordenarDiscos() {
        StringBuilder listaDiscos = new StringBuilder();
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
            listaDiscos.append("Nombre del disco: ").append(d.getTitulo()).append("\nAutor: ").append(d.getAutor()).append("\nCanciones: \n");

            for (Cancion c: d.getCanciones()) {
                listaDiscos.append("\t").append(c.getTituloCancion()).append("\n");
            }
            listaDiscos.append("\n");
        }
        return listaDiscos.toString();
    }
}
