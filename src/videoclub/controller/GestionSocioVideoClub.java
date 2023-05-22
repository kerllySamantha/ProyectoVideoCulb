package controller;

import model.Multimedia;
import model.Socio;

import javax.swing.*;
import java.util.ArrayList;

public class GestionSocioVideoClub {

  public static ArrayList<Socio> socios = new ArrayList<>();

    public static void alquilarMultSocio(ArrayList<Multimedia> multimedia, ArrayList<Socio> socios) {

        // System.out.println("Introduce el título que quiera alquilar el socio");
        String titMult = "";
        if (buscarTitulo(titMult, multimedia) != -1) {
            System.out.println("Introduce el NIF del socio");
            String nif = "";
            if (buscarSocio(nif, socios) != -1) {
                if (socios.get(buscarSocio(nif, socios)).getRecargo() == 0) {
                    //socios.get(buscarSocio(nif, socios)).setRecargo(calcularPrecio(multimedia.get(buscarTitulo(titMult, multimedia))));
                    socios.get(buscarSocio(nif, socios)).getHistorial().add(multimedia.get(buscarTitulo(titMult, multimedia)));
                    socios.get(buscarSocio(nif, socios)).getAlquilerActual().add(multimedia.get(buscarTitulo(titMult, multimedia)));
                } else {
                    System.out.println("Socio con recargos. No puede alquilar");
                }
            } else {
                System.out.println("No se ha encontrado el socio");
            }
        } else {
            System.out.println("No se ha encontrado el título");
        }
    }

//    public static int calcularPrecio(Multimedia m) {
//        int precio = 4;
//        if (tipoMultimedia(m) == 0) {
//            if (m.getAnio() < 2012) {
//                precio = precio - 1;
//            }
//        } else if (tipoMultimedia(m) == 1) {
//            if (m.getAnio() < 2010) {
//                precio = precio - 1;
//            }
//        }
//        return precio;
//    }

    public static Object[] devolverMult(ArrayList<Multimedia> multimedia, ArrayList<Socio> socios) {
        System.out.println("Introduce el titulo que se va a devolver");
        String titMult = "sc.nextLine()";
        if (buscarTitulo(titMult, multimedia) != -1) {
            System.out.println("Introduce el NIF del socio");
            String nif = " sc.nextLine()";
            if (buscarSocio(nif, socios) != -1) {
                if (buscarTituloAlquilados(titMult, socios.get(buscarSocio(nif, socios))) != -1) {
                    System.out.println("Introduce los dias pasados desde que se realizó el alquiler");
                    int dias = 0;
                    socios.get(buscarSocio(nif, socios)).getAlquilerActual().remove(buscarTituloAlquilados(titMult, socios.get(buscarSocio(nif, socios))));
                    socios.get(buscarSocio(nif, socios)).setRecargo(socios.get(buscarSocio(nif, socios)).getRecargo() + calcularRecargoDev(dias));
                } else {
                    System.out.println("Este título no ha sido alquilado por el socio");
                }
            } else {
                System.out.println("No se ha encontrado el socio");
            }
        } else {
            System.out.println("No se ha encontrado el título");
        }
        return new Object[0];
    }

    public static int calcularRecargoDev(int dias) {
        int recargo = 0;
        if (dias > 3) {
            recargo = 2 * (dias - 3);
        }
        return recargo;
    }

    public static String pagarRecargo(ArrayList<Socio> socios) {

        System.out.println("Indica que socio va a realizar el pago");
        String nif = "";
        if (buscarSocio(nif, socios) != -1) {
            socios.get(buscarSocio(nif, socios)).setRecargo(0);
            return "Se ha pagado los recargos pendientes";
        } else {
            return "No se ha encontrado el socio";
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

    public static int buscarTituloAlquilados(String titulo, Socio s) {
        int index = 0;
        for (int i = 0; i < s.getHistorial().size(); i++) {
            if (s.getHistorial().get(i).getTitulo().equalsIgnoreCase(titulo)) {
                index = i;
                return index;
            }
        }
        return -1;
    }

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
                    listaAlquileres += "\t" + socios.get(indexSocio).getAlquilerActual().get(i).getTitulo();
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


