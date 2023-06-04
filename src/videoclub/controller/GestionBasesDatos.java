package controller;

import model.*;

import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

public class GestionBasesDatos {
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

    public static void aniadirSocios() {
        String nif, nombre, poblacion;
        LocalDate fecha_nac;
        int recargo;
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
                    recargo = rs.getInt("recargo");
                    GestionSocioVideoClub.socios.add(new Socio(nif, nombre, fecha_nac, poblacion, recargo));
                }
                getConexion().close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void aniadirPelicula() {
        String titulo, autor, genero, duracion, actorPrincipal, actrizPrincipal;
        Formato formato;
        int anio;
        try {
            getConexion();
            try {
                Statement st = Objects.requireNonNull(getConexion()).createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM  PELICULA");
                while (rs.next()) {

                    titulo = rs.getString("titulo");
                    autor = rs.getString("autor");
                    formato = Formato.valueOf(rs.getString("formato"));
                    anio = rs.getInt("anio");
                    genero = rs.getString("genero");
                    duracion = rs.getString("duracion");
                    actorPrincipal = rs.getString("actorprincipal");
                    actrizPrincipal = rs.getString("actrizprincipal");

                    GestionMultimedia.multimedias.add(new Pelicula(titulo, autor, formato, anio, duracion, actorPrincipal, actrizPrincipal, genero));
                }
                getConexion().close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void aniadirVideojuego() {
        String titulo, autor;
        Plataforma plataforma;
        Formato formato;
        int anio;
        try {
            getConexion();
            try {
                Statement st = Objects.requireNonNull(getConexion()).createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM  VIDEOJUEGO");
                while (rs.next()) {

                    titulo = rs.getString("titulo");
                    autor = rs.getString("autor");
                    formato = Formato.valueOf(rs.getString("formato"));
                    anio = rs.getInt("anio");
                    plataforma = Plataforma.valueOf(rs.getString("plataforma"));
                    GestionMultimedia.multimedias.add(new Videojuego(titulo, autor, formato, anio, plataforma));
                }
                getConexion().close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void aniadiscoArrayMultimedia() {
        String titulo, autor;
        Formato formato;
        int anio;
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

                    GestionMultimedia.multimedias.add(new Disco(titulo, autor, formato, anio));
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
        Cancion cancion;
        String autor, nombre, duracionMinSeg;
        int duracion;
        try {
            getConexion();
            try {
                Statement st = Objects.requireNonNull(getConexion()).createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM  CANCIONES");
                while (rs.next()) {
                    nombre = rs.getString("nombre");
                    autor = rs.getString("autor");
                    duracion = rs.getInt("duracion");
                    duracionMinSeg = rs.getString("duracionminseg");

                    cancion = new Cancion(nombre, duracion, duracionMinSeg, autor);
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


    public static void aniadirAlquiler(ArrayList<Multimedia> multimedias, ArrayList<Socio> socios) {
        String titulo, nif, tipo;
        LocalDate fechaAlquiler;
        int precio;
        Formato formato;
        try {
            getConexion();
            try {
                Statement st = Objects.requireNonNull(getConexion()).createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM  ALQUILER");
                while (rs.next()) {
                    titulo = rs.getString("titulo_multimedia");
                    tipo = rs.getString("tipo_multimedia");
                    formato = Formato.valueOf(rs.getString("formato_multimedia"));
                    fechaAlquiler = LocalDate.parse(rs.getString("fecha_alquiler"));
                    precio = rs.getInt("precio_alquiler");
                    nif = rs.getString("nifSocio");

                    for (Multimedia mult : multimedias) {
                        if (mult.getTitulo().equalsIgnoreCase(titulo) && formato == mult.getFormato() &&
                                mult.getClass().getName().substring(6).equalsIgnoreCase(tipo)) {
                            for (Socio socio : socios) {
                                if (socio.getNif().equals(nif)) {
                                    socio.getAlquilerActual().add(new GestionAlquilerMul(mult, fechaAlquiler, precio, socio));
                                    GestionAlquilerMul.alquileres.add(new GestionAlquilerMul(mult, fechaAlquiler, precio, socio));
                                }
                            }
                        }
                    }
                }
                getConexion().close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertAlquiler(String titulo, Formato formato, LocalDate fecha, int precio, String nif, String tipo_multimedia) {
        try {
            getConexion();
            try {
                Statement st = conex.createStatement();
                st.executeUpdate("insert into alquiler values "
                        + "('" + nif + "', '" + titulo + "', '" + tipo_multimedia + "', '" + formato.toString() + "', '" + fecha + "', " + precio + ")");

                Objects.requireNonNull(getConexion()).close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void eliminarAlquiler(String tipo, String titulo, String nif, int precio, LocalDate fecha) {
        try {
            getConexion();
            try {
                String consultaDelete = "DELETE FROM ALQUILER WHERE titulo_multimedia = ? AND nifSocio = ? " +
                        "AND fecha_alquiler = ? AND tipo_multimedia = ? AND precio_alquiler = ?";
                PreparedStatement statement = Objects.requireNonNull(getConexion()).prepareStatement(consultaDelete);
                statement.setString(1, titulo);
                statement.setString(2, nif);
                statement.setDate(3, Date.valueOf(fecha));
                statement.setString(4, tipo);
                statement.setInt(5, precio);
                statement.executeUpdate();
                getConexion().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void insertPelicula(String titulo, String autor, Formato formato, String genero, int anio, String duracion, String actorPrincipal, String atrizPrincipal) {
        try {
            getConexion();
            try {
                Statement st = conex.createStatement();
                st.executeUpdate("insert into pelicula (titulo, autor, formato, genero,  anio, duracion, actorprincipal, actrizprincipal) values "
                        + "('" + titulo + "', '" + autor + "', '" + formato.toString() + "', '" + genero + "', " + anio + ", '" + duracion + "', '" + actorPrincipal + "', '" + atrizPrincipal + "')");

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

                Objects.requireNonNull(getConexion()).close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertCancion(String titulo, String autor, String duracionMinSeg, int duracion, String nombreDisco) {
        try {
            getConexion();
            try {
                Statement st = conex.createStatement();
                st.executeUpdate("INSERT INTO CANCIONES(NOMBRE, DURACION, DURACIONMINSEG, TITULODISCO, AUTOR) VALUES "
                        + "('" + titulo + "', '" + duracion + "', '" + duracionMinSeg + "', '" + nombreDisco + "', '" + autor + "')");

                Objects.requireNonNull(getConexion()).close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void insertViedeojuego(String titulo, String autor, Formato formato, int anio, Plataforma plataforma) {
        try {
            getConexion();
            try {
                Statement st = conex.createStatement();
                st.executeUpdate("insert into videojuego (titulo, autor, formato, anio, plataforma) values "
                        + "('" + titulo + "', '" + autor + "', '" + formato.toString() + "', '" + anio + "', '" + plataforma.toString() + "')");

                Objects.requireNonNull(getConexion()).close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertNuevoSocio(String nif, String nombre, LocalDate fechaNac, String poblacion) {
        try {
            getConexion();
            try {
                Statement st = conex.createStatement();
                st.executeUpdate("insert into socio (nif, nombre, fecha_nac, poblacion) values "
                        + "('" + nif + "', '" + nombre + "', '" + fechaNac + "', '" + poblacion + "')");
                Objects.requireNonNull(getConexion()).close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static boolean comprobarDisponibilidad(String titulo, String tabla) {
        int cantidad = 0;
        try {
            getConexion();
            try {
                Statement st = Objects.requireNonNull(getConexion()).createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM " + tabla + " WHERE TITULO = '" + titulo + "'");
                if (rs.next()) {
                    cantidad = rs.getInt("cantidad");
                }
                getConexion().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cantidad > 0;
    }

    public static void racalcularCantidadDev(String tabla, String titulo, String autor) {
        try {
            getConexion();
            try {
                String consultaUpdate = "UPDATE " + tabla + " SET cantidad = cantidad + 1 WHERE titulo = ? AND autor = ?";
                PreparedStatement statement = Objects.requireNonNull(getConexion()).prepareStatement(consultaUpdate);
                statement.setString(1, titulo);
                statement.setString(2, autor);
                statement.executeUpdate();
                getConexion().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void recalcularCantidadAlquiler(String tabla, String titulo, String autor) {
        try {
            getConexion();
            try {
                String consultaUpdate = "UPDATE " + tabla + " SET cantidad = cantidad - 1 WHERE titulo = ? AND autor = ?";
                PreparedStatement statement = Objects.requireNonNull(getConexion()).prepareStatement(consultaUpdate);
                statement.setString(1, titulo);
                statement.setString(2, autor);
                statement.executeUpdate();
                getConexion().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void eliminarRecargo(String nif) {
        try {
            getConexion();
            try {
                String consultaUpdate = "UPDATE SOCIO SET RECARGO = 0 WHERE NIF = ?";
                PreparedStatement statement = Objects.requireNonNull(getConexion()).prepareStatement(consultaUpdate);
                statement.setString(1, nif);
                statement.executeUpdate();
                getConexion().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void actualizarRecargo(String nif, int recargo) {
        try {
            getConexion();
            try {
                String consultaUpdate = "UPDATE SOCIO SET RECARGO = ? WHERE NIF = ?";
                PreparedStatement statement = Objects.requireNonNull(getConexion()).prepareStatement(consultaUpdate);
                statement.setInt(1, recargo);
                statement.setString(2, nif);
                statement.executeUpdate();
                getConexion().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}


