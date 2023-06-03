package controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GestionLogs {
    private static final String FILE_PATH = "src/logs.txt";
    private static final DateTimeFormatter FORMATO_FECHA_HORA = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    public static void escribirRegistro(String registro) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true));
            String mensaje = "[" + LocalDateTime.now().format(FORMATO_FECHA_HORA) + "] " + registro;

            writer.write(mensaje);
            writer.newLine();

            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String registrarInicioPrograma() {
        return "Se ha iniciado el programa";
    }

    public static String registroCerrarPrograma() {
        return "Se ha cerrado el programa";
    }

    public static String registroAltaSocio(String nif, String nombre) {
        return "Se ha dado de alta al socio " + nombre + ", con NIF " + nif;
    }

    public static String registroAltaPelicula(String titulo) {
        return "Se ha dado de alta la pelicula '" + titulo + "'";
    }
    public static String registroAltaDisco(String titulo) {
        return "Se ha dado de alta el disco '" + titulo + "'";
    }
    public static String registroAltaVideojuego(String titulo) {
        return "Se ha dado de alta el videojuego '" + titulo + "'";
    }
    public static String registroAlquilerMult(String nif, String titulo, String tipo) {
        return "Se ha alquilado el multimedia '" + titulo + "' (" + tipo + ") a socio con NIF " + nif;
    }

    public static String registroDevolucionMuolt(String nif, String titulo, String tipo) {
        return "Socio con NIF " + nif + " ha devuelto el multimedia'" + titulo + "' (" + tipo + ")";
    }

    public static String registroPagos(String nif) {
        return "Socio con NIF " + nif + " ha pagado los recargos";
    }
}
