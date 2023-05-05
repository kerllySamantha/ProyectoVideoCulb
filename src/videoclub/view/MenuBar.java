package view;

import model.Disco;

import javax.swing.*;

public class MenuBar {
    private static JMenuBar menuVideoClub;
    private static JMenu altas, bajas, alquileres, devoluciones, listados, salir;
    private static JMenuItem socio, videojuego, pelicula, disco, listMultimedia, listPelisOrden, listVideJAnio,
            listHistorialAlqSocioFecha, listActualSocio, listRecargosPendSocio, botonSalir;
    static FormAltaSocio formAltaSocio = new FormAltaSocio();
    static FormAltaDisco formAltaDisco = new FormAltaDisco();
    static FormAltaPelicula formAltaPelicula = new FormAltaPelicula();
    static FormVideoJuego formAVideoJuego = new FormVideoJuego();
    static FormPrincipalAltas formPrincipalAltas = new FormPrincipalAltas();

    public static JMenuBar crearMenuBar() {
        menuVideoClub = new JMenuBar();

        altas = new JMenu("Altas");
        //bajas = new JMenu("Bajas");
        alquileres = new JMenu("Alquileres");
        devoluciones = new JMenu("Devoluciones");
        listados = new JMenu("Listados");
        salir = new JMenu("Salir");

        menuVideoClub.add(altas);
        //menuVideoClub.add(bajas);
        menuVideoClub.add(alquileres);
        menuVideoClub.add(devoluciones);
        menuVideoClub.add(listados);
        menuVideoClub.add(salir);

        socio = new JMenuItem("Socio");
        pelicula = new JMenuItem("Pelicula");
        videojuego = new JMenuItem("Videojuego");
        disco = new JMenuItem("Disco");

        altas.add(socio);
        altas.add(pelicula);
        altas.add(videojuego);
        altas.add(disco);


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

        botonSalir = new JMenuItem("EXIT");
        salir.add(botonSalir);

        return menuVideoClub;
    }

    public static void visivilidadVentanas() {
        formAVideoJuego.setVisible(false);
        formAltaPelicula.setVisible(false);
        formAltaSocio.setVisible(false);
        formAltaDisco.setVisible(false);
        formPrincipalAltas.setVisible(false);


    }

    public static void gestionDeVentanas() {
        socio.addActionListener(e -> {
            formAltaSocio.setDefaultCloseOperation(formAltaSocio.HIDE_ON_CLOSE);
            formAltaSocio.setBounds(100, 100, 600, 300);
            if (!formAltaSocio.isVisible()) {
                visivilidadVentanas();
                formAltaSocio.setVisible(true);
            }

        });
        disco.addActionListener(e -> {
            formAltaDisco.setDefaultCloseOperation(formAltaDisco.HIDE_ON_CLOSE);
            formAltaDisco.setBounds(100, 100, 600, 300);
            if (!formAltaDisco.isVisible()) {
                visivilidadVentanas();
                formAltaDisco.setVisible(true);
            }
        });
        pelicula.addActionListener(e -> {
            formAltaPelicula.setDefaultCloseOperation(formAltaPelicula.HIDE_ON_CLOSE);
            formAltaPelicula.setBounds(100, 100, 600, 300);
            if (!formAltaPelicula.isVisible()) {
                 visivilidadVentanas();
                 formAltaPelicula.setVisible(true);
            }
        });
        videojuego.addActionListener(e -> {
            formAVideoJuego.setDefaultCloseOperation(formAVideoJuego.HIDE_ON_CLOSE);
            formAVideoJuego.setBounds(100, 100, 600, 300);
            if (!formAVideoJuego.isVisible()) {
                visivilidadVentanas();
                formAVideoJuego.setVisible(true);
            }
        });

        salir.addActionListener(e -> {
            System.exit(0);
        });
    }

}
