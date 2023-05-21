package controller;

import model.*;

import java.sql.*;
import java.util.*;

public class GestionBasesDatos {
    private static final StringBuilder TOTAL = new StringBuilder();
    private static final String URL = "jdbc:postgresql://localhost:5432/";
    private static final String DB = "videoclub";
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String USER = "postgres";
    private static final String PASS = "130420";
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

//    public static void updateDisco(String titulo, String autor, Formato formato, int anio, int duracion, int cantidad) {
//        try {
//            Disco disco = new model.Disco(titulo, autor, formato, anio
//                    );
//            getConexion();
//            try {
//                Statement st = conex.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
//                String origin = "update monitor set ";
//                st.executeUpdate(origin + "titulo = '" + titulo + "' where autor = '" + disco.getAutor() + "'");
//                st.executeUpdate(origin + "autor = '" + autor + "' where autor = '" + disco.getAutor() + "'");
//                st.executeUpdate(origin + "formato = '" + formato + "' where autor = '" + autor + "'");
//                st.executeUpdate(origin + "anio = '" + anio + "' where autor = '" + anio + "'");
//
//                Objects.requireNonNull(getConexion()).close();
//            } catch (Exception e2) {
//                e2.printStackTrace();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public static void aniadirSocios() {
        String nif, nombre, poblacion;
        //Date fecha_nac;
        try {
            getConexion();
            try {
                Statement st = Objects.requireNonNull(getConexion()).createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM  SOCIO");
                while (rs.next()) {
                    nif = rs.getString("nif");
                    nombre = rs.getString("nombre");
                    poblacion = rs.getString("poblacion");
                    //GestionSocioVideoClub.socios.add(new Socio(nif, nombre, poblacion));

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


//    public static ArrayList<Multimedia> aniaadirDiscoAlArrayMultimedias() {
//        ArrayList<Multimedia> monitimedia = new ArrayList<>();
//        try {
//            getConexion();
//            try {
//                Statement st = Objects.requireNonNull(getConexion()).createStatement();
//                ResultSet rs = st.executeQuery("SELECT * FROM  DISCO ");
//                while (rs.next()) {
//                    String titulo = rs.getString("titulo");
//                    String autor = rs.getString("autor");
//                    Formato formato = Formato.valueOf(rs.getString("formato"));
//                    int anio = rs.getInt("anio");
//                    int duracion = rs.getInt("duracion");
//                    int cantidad = rs.getInt("cantidad");
//                    aniaadirDiscoAlArrayMultimedias().add(new Disco(titulo, autor, formato, anio));
//                }
//                getConexion().close();
//                return aniaadirDiscoAlArrayMultimedias();
//
//            } catch (Exception e2) {
//                e2.printStackTrace();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return monitimedia;
//    }

//    public static void updateMultimedia(, String numSerie, String tipo, int pulgadas, float precio, String id) {
//        try {
//            Multimedia monitoresfForm = new Multimedia();
//            getConexion();
//            try {
//                Statement st = conex.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
//                String origin ="update monitor set ";
//                st.executeUpdate(origin + "numserie = '" + numSerie + "' where id = '" + monitor.getId() + "'");
//                st.executeUpdate(origin + "tipo = '" + tipo + "' where id = '" + monitor.getId() + "'");
//                st.executeUpdate(origin + "pulgadas = '" + pulgadas + "' where id = '" + monitor.getId() + "'");
//                st.executeUpdate(origin + "precio = '" + precio + "' where id = '" + monitor.getId() + "'");
//                st.executeUpdate(origin + "id= '" + id + "' where id = '" + monitor.getId() + "'");
//                monitoresfForm.rellenarComboBox();
//                Objects.requireNonNull(getConexion()).close();
//            } catch (Exception e2) {
//                e2.printStackTrace();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
