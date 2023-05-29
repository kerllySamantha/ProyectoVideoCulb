package controller;

import model.*;

import javax.swing.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class GestionSocioVideoClub {

    public static ArrayList<Socio> socios = new ArrayList<>();


    public static DefaultListModel<String> mostarMultSocio(String nif) {
        DefaultListModel<String> listaMultimedia = new DefaultListModel<>();
        if (buscarSocio(nif, socios) != -1) {
            int index = buscarSocio(nif, socios);
            for (int i = 0; i < socios.get(index).getAlquilerActual().size(); i++) {
                listaMultimedia.addElement(socios.get(index).getAlquilerActual().get(i).getMultimediaAlquilado().getTitulo());
            }
        }
        return listaMultimedia;
    }

    public static void devolverMultimedia(String nif, String titlulo) {
        if (comprobarNif(socios, nif)) {
            int index = buscarSocio(nif, socios);
            for (int i = 0; i < socios.get(index).getAlquilerActual().size(); i++) {
                if (socios.get(index).getAlquilerActual().get(i).getMultimediaAlquilado().getTitulo().equals(titlulo)) {
                    calcularRecargoDev(socios.get(index).getAlquilerActual().get(i).getFechaAlquiler(), socios.get(index));
                    socios.get(index).getAlquilerActual().remove(i);
                    GestionAlquilerMul.eliminarAlquiler(socios.get(index), socios.get(index).getAlquilerActual().get(i).getMultimediaAlquilado());
                    break;
                }
            }
        }
    }



    public static void calcularRecargoDev(LocalDate fecha, Socio socio) {
        int recargo = 0;
        LocalDate fechaActual = LocalDate.now();
        Period period = Period.between(fecha, fechaActual);
        int dias = period.getDays();
        if (dias > 3) {
            recargo = 2 * (dias - 3);
        }
        socio.setRecargo(recargo);
    }

    public static void pagarRecargo(String nif) {
        if (buscarSocio(nif, socios) != -1) {
            socios.get(buscarSocio(nif, socios)).setRecargo(0);
            JOptionPane.showMessageDialog(null, "El socio con NIF " + nif + " ha realizado el pago de los recargos");
        } else {
            JOptionPane.showMessageDialog(null, "No se ha encontrado el socio");
        }
    }

    public static int buscarTitulo(String titulo, ArrayList<Multimedia> multimedia) {
        int index = 0;
        for (int i = 0; i < multimedia.size(); i++) {
            if (multimedia.get(i).getTitulo().equalsIgnoreCase(titulo)) {
                index = i;
                return index;
            }
        }
        return -1;
    }

//    public static int buscarTituloAlquilados(String titulo, Socio s) {
//        int index = 0;
//        for (int i = 0; i < s.getHistorial().size(); i++) {
//            if (s.getHistorial().get(i).getTitulo().equalsIgnoreCase(titulo)) {
//                index = i;
//                return index;
//            }
//        }
//        return -1;
//    }

    public static int buscarSocio(String nif, ArrayList<Socio> socios) {
        int index = 0;
        for (int i = 0; i < socios.size(); i++) {
            if (socios.get(i).getNif().equalsIgnoreCase(nif)) {
                index = i;
                return index;
            }
        }
        return -1;
    }

    public static boolean comprobarNif(ArrayList<Socio> socios, String nif) {
        for (Socio socio : socios) {
            if (nif.equalsIgnoreCase(socio.getNif())) {
                return true;
            }
        }
        return false;
    }


    public static String listaSociosRecargos() {
        String listasSocios = "Socios con recargos pendientes: \n";

        for (Socio s : socios) {
            if (s.getRecargo() >  0) {
                listasSocios += "NIF: " + s.getNif() + "\nNombre: " + s.getNombre() + "\nRecargo: " + s.getRecargo();
            }
        }
        return listasSocios;
    }

    public static String listaAlquilerActual(String nif) {
        String listaAlquileres = "";
        if (buscarSocio(nif, socios) != -1) {
            try {
                int indexSocio = buscarSocio(nif, socios);
                listaAlquileres += "Nombre: " + socios.get(indexSocio).getNombre() +
                        "\nAlquileres actuales del socio:";

                for (int i = 0; i < socios.get(indexSocio).getAlquilerActual().size(); i++) {
                    listaAlquileres += "\t" + socios.get(indexSocio).getAlquilerActual().get(i).getMultimediaAlquilado().getTitulo();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "El socio introducido no tiene ningún alquiler actualmente");
            }
        } else {
            JOptionPane.showMessageDialog(null, "El NIF introducido no coincide con ningú socio registrado");
        }
        return listaAlquileres;
    }
}



//
//    public static void listaHistorial(ArrayList<Socio> socios) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Introduce el NIF del socio que quieras consultar");
//        String nif = sc.nextLine();
//        if (buscarSocio(nif, socios) != -1) {
//            try {
//                System.out.println("Histórico de alquileres del socio");
//                System.out.println("-----------------------------------------");
//                for (int i = 0; i < socios.get(buscarSocio(nif, socios)).getHistorial().size(); i++) {
//                    System.out.println(socios.get(buscarSocio(nif, socios)).getHistorial().get(i));
//                    System.out.println("--------------------------");
//                }
//            } catch (Exception e) {
//                System.out.println("El historial está vacio");
//            }
//        } else {
//            System.out.println("No se ha encontrado el socio");
//        }
//    }
//


