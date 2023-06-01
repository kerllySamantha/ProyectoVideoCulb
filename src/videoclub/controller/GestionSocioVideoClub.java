package controller;

import model.*;

import javax.swing.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class GestionSocioVideoClub {

    public static ArrayList<Socio> socios = new ArrayList<>();


    public static Set<String> mostarMultAlquiladosSocio(String nif) {
        Set<String> listaMultimedia = new HashSet<>();
        //DefaultListModel<String> listaMultimedia = new DefaultListModel<>();
        if (buscarSocio(nif, socios) != -1) {
            int index = buscarSocio(nif, socios);
            for (int i = 0; i < socios.get(index).getAlquilerActual().size(); i++) {
                listaMultimedia.add(socios.get(index).getAlquilerActual().get(i).getMultimediaAlquilado().getTitulo());
            }
        }
        return listaMultimedia;
    }

    public static void devolverMultimedia(String nif, String titlulo) {
        int diasRecargo = 0;
        int index;
        if (comprobarNif(socios, nif)) {
            index = buscarSocio(nif, socios);
            for (int i = 0; i < socios.get(index).getAlquilerActual().size(); i++) {
                if (socios.get(index).getAlquilerActual().get(i).getMultimediaAlquilado().getTitulo().equals(titlulo)) {

                    diasRecargo = calcularRecargoDev(socios.get(index).getAlquilerActual().get(i).getFechaAlquiler(), socios.get(index));

                    GestionLogs.escribirRegistro(GestionLogs.registroDevolucionMuolt(socios.get(index).getNif(),
                            socios.get(index).getAlquilerActual().get(i).getMultimediaAlquilado().getTitulo(),
                            socios.get(index).getAlquilerActual().get(i).getMultimediaAlquilado().getClass().getName().substring(6)));

                    GestionBasesDatos.racalcularCantidadDev(socios.get(index).getAlquilerActual().get(i).getMultimediaAlquilado().getClass().getName().substring(6).toLowerCase(),
                            socios.get(index).getAlquilerActual().get(i).getMultimediaAlquilado().getTitulo(),
                            socios.get(index).getAlquilerActual().get(i).getMultimediaAlquilado().getAutor());

                    GestionBasesDatos.eliminarAlquiler(socios.get(index).getAlquilerActual().get(i).getMultimediaAlquilado().getClass().getName().substring(6),
                            socios.get(index).getAlquilerActual().get(i).getMultimediaAlquilado().getTitulo(),
                            socios.get(index).getAlquilerActual().get(i).getSocio().getNif(),
                            socios.get(index).getAlquilerActual().get(i).getPrecio(),
                            socios.get(index).getAlquilerActual().get(i).getFechaAlquiler());

                    socios.get(index).getAlquilerActual().remove(i);
                    break;
                }
            }
            if (socios.get(index).getRecargo() > 0) {
                int respuesta = JOptionPane.showConfirmDialog(null, "Se ha pasado " + diasRecargo
                        + " días del periodo máximo de alquiler." + "\nRecargo actual del socio: "
                        + socios.get(index).getRecargo() + ".\n¿Pagar ahora?", "Alerta", JOptionPane.YES_NO_OPTION);

                if (respuesta == JOptionPane.YES_OPTION) {
                    socios.get(index).setRecargo(0);
                }
            }
        }

    }

    public static void alquilarMultimedia(Multimedia multimediaAlquilado, Socio socio) {
        if (socio.getRecargo() == 0) {
            GestionAlquilerMul alquiler = new GestionAlquilerMul(multimediaAlquilado, socio);
            socio.getAlquilerActual().add(alquiler);
            GestionAlquilerMul.alquileres.add(alquiler);

            GestionLogs.escribirRegistro(GestionLogs.registroAlquilerMult(socio.getNif(),
                    multimediaAlquilado.getTitulo(),
                    multimediaAlquilado.getClass().getName().substring(6)));

            GestionBasesDatos.recalcularCantidadAlquiler(multimediaAlquilado.getClass().getName().substring(6).toLowerCase(),
                    multimediaAlquilado.getTitulo(), multimediaAlquilado.getAutor());

            GestionBasesDatos.insertAlquiler(alquiler.getMultimediaAlquilado().getTitulo(), alquiler.getMultimediaAlquilado().getFormato(),
                    alquiler.getFechaAlquiler(), alquiler.getPrecio(), alquiler.getSocio().getNif(),
                    alquiler.getMultimediaAlquilado().getClass().getName().substring(6).toUpperCase());

            JOptionPane.showMessageDialog(null,
                    "El aquiler del socio con identificacion "
                            + socio.getNif() + "se ha realiado correctamente"
                            + "\nPrecio a pagar: " + alquiler.getPrecio());
        } else {
            JOptionPane.showMessageDialog(null, "El socio tiene recargos, no puede alquilar");
        }
    }


    public static int calcularRecargoDev(LocalDate fecha, Socio socio) {
        int recargo = 0;
        LocalDate fechaActual = LocalDate.now();
        Period period = Period.between(fecha, fechaActual);
        int dias = period.getDays();
        if (dias > 3) {
            recargo = 2 * (dias - 3);
        }
        socio.setRecargo(recargo);
        return period.getDays() - 3;
    }

    public static void pagarRecargo(String nif) {
        if (buscarSocio(nif, socios) != -1) {
            int index = buscarSocio(nif, socios);
            if (socios.get(index).getRecargo() > 0) {
                socios.get(buscarSocio(nif, socios)).setRecargo(0);
                JOptionPane.showMessageDialog(null, "El socio con NIF " + nif + " ha realizado el pago de los recargos");
            }
            JOptionPane.showMessageDialog(null, "El socio con NIF " + nif + " no tiene recargos pendiente");
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


