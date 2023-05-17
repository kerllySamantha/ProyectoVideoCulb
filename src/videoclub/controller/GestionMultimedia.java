package controller;

import model.Multimedia;
import model.Pelicula;

import java.util.ArrayList;
import java.util.Comparator;

public class GestionMultimedia {
    public static ArrayList<Multimedia>multimedias = new ArrayList<>();


    //metodos de cosas

    public void ordenarMultimedia(ArrayList<Multimedia>multimedia) {

        multimedia.sort(new Comparator<Multimedia>() {
            public int compare(Multimedia p1, Multimedia p2) {
                return p1.getTitulo().compareTo(p2.getTitulo());
            }
        });

//        for (Multimedia multimedia1: multimedia) {
//            //listModel.addElement("Título: " + multimedia1.getTitulo() + "\tAutor: " + multimedia1.getAutor() + "\tTipo: " + multimedia1.getClass().getName().substring(6));
//            listModel.addElement(multimedia1.toString());
//        }
        for (Multimedia multimedia1 : multimedia) {
            //txtListaMultimedia.append("Título: " + multimedia1.getTitulo() + "\nAño: " + multimedia1.getAnio() + "\nTipo: " + multimedia1.getClass().getName().substring(6));
        }
    }

    public void ordenarPeliculas(ArrayList<Multimedia>multimedia) {
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
            System.out.println(p);
            System.out.println("--------------------------");
        }
    }
}
