package view;

import javax.swing.*;

public class MenuBar {
    private static JMenuBar menuVideoClub;
    private static JMenu altas, bajas, alquileres, devoluciones, listados, salir;
    private static JMenuItem socio, videojueo, pelicula, listMultimedia, listPelisOrden, listVideJAnio,
            listHistorialAlqSocioFecha, listActualSocio, listRecargosPendSocio;


    public static JMenuBar crearMenuBar() {
        menuVideoClub = new JMenuBar();

        altas = new JMenu("Altas");
        bajas = new JMenu("Bajas");
        alquileres = new JMenu("Alquileres");
        devoluciones = new JMenu("Devoluviones");
        listados = new JMenu("Listados");
        salir = new JMenu("Salir");

        menuVideoClub.add(altas);
        menuVideoClub.add(bajas);
        menuVideoClub.add(alquileres);
        menuVideoClub.add(devoluciones);
        menuVideoClub.add(listados);
        menuVideoClub.add(salir);

        socio = new JMenuItem("Socio");
        pelicula = new JMenuItem("Pelicula");
        videojueo = new JMenuItem("Videojuego");

        altas.add(socio);
        altas.add(pelicula);
        altas.add(videojueo);

        listMultimedia = new JMenuItem("Multimedias");
        listPelisOrden = new JMenuItem("Peliculas en Orden");
        listVideJAnio = new JMenuItem("Videojuego por año");
        listHistorialAlqSocioFecha = new JMenuItem("Historial de alquiler del Socio por fecha");
        listActualSocio = new JMenuItem("Actual del Socio");
        listRecargosPendSocio = new JMenuItem("Recargos pendientes");

        listados.add(listMultimedia);
        listados.add(listPelisOrden);
        listados.add(listVideJAnio);
        listados.add(listHistorialAlqSocioFecha);
        listados.add(listActualSocio);
        listados.add(listRecargosPendSocio);

        return menuVideoClub;

    }

}
