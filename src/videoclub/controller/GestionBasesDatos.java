package controller;

import model.Disco;
import model.Formato;
import model.Multimedia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class GestionBasesDatos {
    private static String tabla = "";
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

    public static String gestionBaseDatos() {
        try {
            getConexion();
            try {
                Statement st = Objects.requireNonNull(getConexion()).createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM  DISCO");
                tabla = "Titulo:" + " \t" + "Autor:" + "\t\t" + "Formato:" + "\t\t" + "Anio" + "\t\t" + "Duracion:" + "\t\t" + "Cantidad:" + "\t\t " + "\n";
                while (rs.next()) {
                    String titulo = rs.getString("titulo");
                    String autor = rs.getString("autor");
                    String formato = rs.getString("formato");
                    Date anio = rs.getDate("anio");
                    int duracion = rs.getInt("duracion");
                    int cantidad = rs.getInt("cantidad");

                    TOTAL.append(titulo).append("\t").append(autor).append("\t\t\t").append(formato).append(anio).append(duracion).append(cantidad).append("\n");
                }
                getConexion().close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tabla + TOTAL;
    }

    public static ArrayList<Multimedia> aniaadirDiscoAlArrayMultimedias() {
        ArrayList<Multimedia> monitimedia = new ArrayList<>();
        try {
            getConexion();
            try {
                Statement st = Objects.requireNonNull(getConexion()).createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM  DISCO ");
                while (rs.next()) {
                    String titulo = rs.getString("titulo");
                    String autor = rs.getString("autor");
                    Formato formato = Formato.valueOf(rs.getString("formato"));
                    int anio = rs.getInt("anio");
                    int duracion = rs.getInt("duracion");
                    int cantidad = rs.getInt("cantidad");
                    aniaadirDiscoAlArrayMultimedias().add(new Disco(titulo, autor, formato, anio));
                }
                getConexion().close();
                return aniaadirDiscoAlArrayMultimedias();

            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return monitimedia;
    }

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
