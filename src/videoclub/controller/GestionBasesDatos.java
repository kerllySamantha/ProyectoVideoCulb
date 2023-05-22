package controller;

import model.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.time.LocalDate;
import java.util.*;

public class GestionBasesDatos {
    private static final StringBuilder TOTAL = new StringBuilder();
    private static final String URL = "jdbc:postgresql://localhost:5432/";
    private static final String DB = "videoclub";
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String USER = "postgres";
    private static final String PASS = "123456";
    static Connection conex = null;

    public static Connection getConexion() {
        try {
            Class.forName(DRIVER);
            conex = DriverManager.getConnection(URL + DB, USER, PASS);
        } catch (Exception e) {
            String error = e.getMessage();
            System.out.println(error);
            return null;
        }
        return conex;
    }

    public static void aniadiscoArrayMultimedia() {
        String titulo, autor;
        Formato formato;
        int anio, duracion, cantidad;
        Disco disco;
        try {
            getConexion();
            try {
                Statement st = Objects.requireNonNull(getConexion()).createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM  DISCO");
                while (rs.next()) {
                    titulo = rs.getString("titulo");
                    autor = rs.getString("autor");
                    formato = Formato.valueOf(rs.getString("formato"));
                    anio = rs.getInt("anio");
                    duracion = rs.getInt("duracion");
                    cantidad = rs.getInt("cantidad");

                    GestionMultimedia.multimedias.add(new Disco(titulo, autor, formato, anio));
                    //disco.agregarCancion(aniadirCancionArrayDisco());
                }
                getConexion().close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateDisco(String titulo, String autor, Formato formato, int anio, String duracion) {
        try {
            getConexion();
            try {
                Statement st = conex.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                String origin = "update disco set ";
                st.executeUpdate(origin + "titulo = '" + titulo + "' where autor = '" + autor + "'");
                st.executeUpdate(origin + "autor = '" + autor + "' where autor = '" + autor + "'");
                st.executeUpdate(origin + "formato = '" + formato + "' where autor = '" + autor + "'");
                st.executeUpdate(origin + "anio = '" + anio + "' where autor = '" + autor + "'");
                st.executeUpdate(origin + "duracion" + duracion + "' where autor = '" + autor + "'");


                Objects.requireNonNull(getConexion()).close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertDisco(String titulo, String autor, Formato formato, int anio, String duracion) {
        try {
            getConexion();
            try {
                Statement st = conex.createStatement();
                st.executeUpdate("insert into disco (titulo, autor, formato, anio, duracion) values "
                        + "('" + titulo + "', '" + autor + "', '" + formato.toString() + "', " + anio + ", '" + duracion + "')");
                //BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

                Objects.requireNonNull(getConexion()).close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void aniadirSocios() {
        String nif, nombre, poblacion;
        LocalDate fecha_nac;
        try {
            getConexion();
            try {
                Statement st = Objects.requireNonNull(getConexion()).createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM  SOCIO");
                while (rs.next()) {
                    nif = rs.getString("nif");
                    nombre = rs.getString("nombre");
                    fecha_nac = LocalDate.parse(rs.getString("fecha_nac"));
                    poblacion = rs.getString("poblacion");
                    GestionSocioVideoClub.socios.add(new Socio(nif, nombre, fecha_nac, poblacion));
                }
                getConexion().close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Cancion> aniadirCancionArrayDisco() {
        ArrayList<Cancion> canciones = new ArrayList<>();
        Cancion cancion = null;
        String tituloDisco, autor = null, nombre = null;
        int duracion;
        String newDuracion = null;
        try {
            getConexion();
            try {
                Statement st = Objects.requireNonNull(getConexion()).createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM  CANCIONES");
                while (rs.next()) {
                    tituloDisco = rs.getString("tituloDisco");
                    nombre = rs.getString("nombre");
                    autor = rs.getString("autor");
                    duracion = rs.getInt("duracion");
                    newDuracion = String.valueOf(duracion);
                    cancion = new Cancion(nombre, newDuracion, autor);
                    canciones.add(cancion);
                }
                getConexion().close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return canciones;
    }
}


