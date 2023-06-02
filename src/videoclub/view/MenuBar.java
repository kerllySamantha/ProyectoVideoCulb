package view;

import controller.GestionMultimedia;
import controller.GestionSocioVideoClub;

import javax.swing.*;
import java.awt.*;

public class MenuBar {
    public static JMenuBar menuVideoClub;
    public static JMenu altas, bajas, alquileres, devoluciones, listados, salir, pagos;
    public static JMenuItem socio, videojuego, pelicula, disco, listMultimedia, listaPelisOrden, listaVideojAnio,
            listHistorialAlqSocioFecha, listActualSocio, listRecargosPendSocio, listaDiscos, devolver, exit, alquiler, pagoRecargos;
    public static FormAltaSocio formAltaSocio = new FormAltaSocio();
    public static FormAltaDisco formAltaDisco = new FormAltaDisco();
    public static FormAltaPelicula formAltaPelicula = new FormAltaPelicula();
    public static FormVideoJuego formAVideoJuego = new FormVideoJuego();
    public static FormPrincipalAltas formPrincipalAltas = new FormPrincipalAltas();
    public static FormDevoluciones formDevoluciones = new FormDevoluciones();
    public static FormAlquiler formAlquiler = new FormAlquiler();
    public static FormListadosMultimedia formListadosMultimedia = new FormListadosMultimedia();
    public static FormPagoRecargo formPagoRecargo = new FormPagoRecargo();
    public static final int ANCHO_PANTALLA = Toolkit.getDefaultToolkit().getScreenSize().width;
    public static final int ALTO_PANTALLA = Toolkit.getDefaultToolkit().getScreenSize().height;

    public static JMenuBar crearMenuBar() {
        Color fondo = new Color(143,151,203);
        Color fondoBotones = new Color(214,220,255);

        menuVideoClub = new JMenuBar();
        menuVideoClub.setBackground(fondo);

        altas = new JMenu("Altas");
        alquileres = new JMenu("Alquileres");
        devoluciones = new JMenu("Devoluciones");
        listados = new JMenu("Listados");
        pagos = new JMenu("Pagos");
        salir = new JMenu("Salir");


        menuVideoClub.add(altas);
        menuVideoClub.add(alquileres);
        menuVideoClub.add(devoluciones);
        menuVideoClub.add(listados);
        menuVideoClub.add(pagos);
        menuVideoClub.add(salir);

        socio = new JMenuItem("Socio");
        pelicula = new JMenuItem("Pelicula");
        videojuego = new JMenuItem("Videojuego");
        disco = new JMenuItem("Disco");


        altas.add(socio);
        altas.add(pelicula);
        altas.add(videojuego);
        altas.add(disco);

        alquiler = new JMenuItem("Alquilar Multimedia");
        alquileres.add(alquiler);

        devolver = new JMenuItem("Devolver");
        devoluciones.add(devolver);

        listMultimedia = new JMenuItem("Multimedias");
        listaDiscos = new JMenuItem("Discos");
        listaPelisOrden = new JMenuItem("Peliculas en Orden");
        listaVideojAnio = new JMenuItem("Videojuego por año");
        //listHistorialAlqSocioFecha = new JMenuItem("Historial de alquiler del Socio por fecha");
        listActualSocio = new JMenuItem("Actual del Socio");
        listRecargosPendSocio = new JMenuItem("Recargos pendientes");

        listados.add(listMultimedia);
        listados.add(listaPelisOrden);
        listados.add(listaVideojAnio);
        listados.add(listaDiscos);
        //listados.add(listHistorialAlqSocioFecha);
        listados.add(listActualSocio);
        listados.add(listRecargosPendSocio);

        pagoRecargos = new JMenuItem("Pagos Recargos");
        pagos.add(pagoRecargos);

        exit = new JMenuItem("Exit");
        salir.add(exit);

        socio.setBackground(fondo);
        pelicula.setBackground(fondo);
        videojuego.setBackground(fondo);
        disco.setBackground(fondo);
        alquiler.setBackground(fondo);
        devolver.setBackground(fondo);
        listMultimedia.setBackground(fondo);
        listaDiscos.setBackground(fondo);
        listaPelisOrden.setBackground(fondo);
        listaVideojAnio.setBackground(fondo);
        listActualSocio.setBackground(fondo);
        listRecargosPendSocio.setBackground(fondo);
        pagoRecargos.setBackground(fondo);
        exit.setBackground(fondo);

        return menuVideoClub;
    }

    public static void visivilidadVentanas() {
        formAVideoJuego.setVisible(false);
        formAltaPelicula.setVisible(false);
        formAltaSocio.setVisible(false);
        formAltaDisco.setVisible(false);
        formPrincipalAltas.setVisible(false);
        formDevoluciones.setVisible(false);
        formListadosMultimedia.setVisible(false);
        formAlquiler.setVisible(false);
        formListadosMultimedia.setVisible(false);
        formPagoRecargo.setVisible(false);

    }

    public static void gestionDeVentanas() {
        socio.addActionListener(e -> {
            formAltaSocio.setDefaultCloseOperation(formAltaSocio.HIDE_ON_CLOSE);
            formAltaSocio.setResizable(false);
            formAltaSocio.setBounds((ANCHO_PANTALLA/2)-250, (ALTO_PANTALLA/2)-275, 500,500);
            if (!formAltaSocio.isVisible()) {
                visivilidadVentanas();
                formAltaSocio.setVisible(true);
            }

        });
        disco.addActionListener(e -> {
            formAltaDisco.setDefaultCloseOperation(formAltaDisco.HIDE_ON_CLOSE);
            formAltaDisco.setResizable(false);
            formAltaDisco.setBounds((ANCHO_PANTALLA/2)-250, (ALTO_PANTALLA/2)-275, 500,500);
            if (!formAltaDisco.isVisible()) {
                visivilidadVentanas();
                formAltaDisco.setVisible(true);
            }
        });
        pelicula.addActionListener(e -> {
            formAltaPelicula.setDefaultCloseOperation(formAltaPelicula.HIDE_ON_CLOSE);
            formAltaPelicula.setResizable(false);
            formAltaPelicula.setBounds((ANCHO_PANTALLA/2)-250, (ALTO_PANTALLA/2)-275, 500,500);
            if (!formAltaPelicula.isVisible()) {
                visivilidadVentanas();
                formAltaPelicula.setVisible(true);
            }
        });
        videojuego.addActionListener(e -> {
            formAVideoJuego.setDefaultCloseOperation(formAVideoJuego.HIDE_ON_CLOSE);
            formAVideoJuego.setBounds((ANCHO_PANTALLA/2)-250, (ALTO_PANTALLA/2)-275, 500,500);
            if (!formAVideoJuego.isVisible()) {
                visivilidadVentanas();
                formAVideoJuego.setVisible(true);
            }
        });



        devolver.addActionListener(e -> {
            formDevoluciones.setDefaultCloseOperation(formDevoluciones.HIDE_ON_CLOSE);
            formDevoluciones.setBounds((ANCHO_PANTALLA/2)-250, (ALTO_PANTALLA/2)-275, 500,500);
            if(!formDevoluciones.isVisible()) {
                visivilidadVentanas();
                formDevoluciones.setVisible(true);
            }
        });

        alquiler.addActionListener(e -> {
            formAlquiler.setDefaultCloseOperation(formDevoluciones.HIDE_ON_CLOSE);
            formAlquiler.setBounds((ANCHO_PANTALLA/2)-250, (ALTO_PANTALLA/2)-275, 500,500);
            if(!formAlquiler.isVisible()) {
                visivilidadVentanas();
                formAlquiler.setVisible(true);
            }
        });

        listMultimedia.addActionListener(e ->{
            formListadosMultimedia.setDefaultCloseOperation(formListadosMultimedia.HIDE_ON_CLOSE);
            formListadosMultimedia.setBounds((ANCHO_PANTALLA/2)-250, (ALTO_PANTALLA/2)-275, 500,500);
            if(!formListadosMultimedia.isVisible()) {
                visivilidadVentanas();
                formListadosMultimedia.setVisible(true);
            }
            FormListadosMultimedia.txtListaMultimedia.setText(GestionMultimedia.ordenarMultimedia());
            FormListadosMultimedia.ocultarBtnTxtAlquilerSocio();

        });


        listaPelisOrden.addActionListener(e ->{
            formListadosMultimedia.setDefaultCloseOperation(formListadosMultimedia.HIDE_ON_CLOSE);
            formListadosMultimedia.setBounds((ANCHO_PANTALLA/2)-250, (ALTO_PANTALLA/2)-275, 500,500);
            if(!formListadosMultimedia.isVisible()) {
                visivilidadVentanas();
                formListadosMultimedia.setVisible(true);
            }
            FormListadosMultimedia.txtListaMultimedia.setText(GestionMultimedia.ordenarPeliculas());
            FormListadosMultimedia.ocultarBtnTxtAlquilerSocio();
        });

        listActualSocio.addActionListener(e ->{
            formListadosMultimedia.setDefaultCloseOperation(formListadosMultimedia.HIDE_ON_CLOSE);
            formListadosMultimedia.setBounds((ANCHO_PANTALLA/2)-250, (ALTO_PANTALLA/2)-275, 500,500);
            if(!formListadosMultimedia.isVisible()) {
                visivilidadVentanas();
                formListadosMultimedia.setVisible(true);
            }
            FormListadosMultimedia.listaAlquileresCLiente();

        });


        listRecargosPendSocio.addActionListener(e ->{
            formListadosMultimedia.setDefaultCloseOperation(formListadosMultimedia.HIDE_ON_CLOSE);
            formListadosMultimedia.setBounds((ANCHO_PANTALLA/2)-250, (ALTO_PANTALLA/2)-275, 500,500);
            if(!formListadosMultimedia.isVisible()) {
                visivilidadVentanas();
                formListadosMultimedia.setVisible(true);
            }
            FormListadosMultimedia.txtListaMultimedia.setText(GestionSocioVideoClub.listaSociosRecargos());
            FormListadosMultimedia.ocultarBtnTxtAlquilerSocio();

        });

        listaVideojAnio.addActionListener(e ->{
            formListadosMultimedia.setDefaultCloseOperation(formListadosMultimedia.HIDE_ON_CLOSE);
            formListadosMultimedia.setBounds((ANCHO_PANTALLA/2)-250, (ALTO_PANTALLA/2)-275, 500,500);
            if(!formListadosMultimedia.isVisible()) {
                visivilidadVentanas();
                formListadosMultimedia.setVisible(true);
            }
            FormListadosMultimedia.txtListaMultimedia.setText(GestionMultimedia.listaVideojuegos());
            FormListadosMultimedia.ocultarBtnTxtAlquilerSocio();

        });


        listaDiscos.addActionListener(e ->{
            formListadosMultimedia.setDefaultCloseOperation(formListadosMultimedia.HIDE_ON_CLOSE);
            formListadosMultimedia.setBounds((ANCHO_PANTALLA/2)-250, (ALTO_PANTALLA/2)-275, 500,500);
            if(!formListadosMultimedia.isVisible()) {
                visivilidadVentanas();
                formListadosMultimedia.setVisible(true);
            }
            FormListadosMultimedia.txtListaMultimedia.setText(GestionMultimedia.ordenarDiscos());
            FormListadosMultimedia.ocultarBtnTxtAlquilerSocio();
        });

        pagoRecargos.addActionListener(e -> {
            formPagoRecargo.setDefaultCloseOperation(formPagoRecargo.HIDE_ON_CLOSE);
            formPagoRecargo.setBounds((ANCHO_PANTALLA/2)-250, (ALTO_PANTALLA/2)-275, 500,500);
            if(!formPagoRecargo.isVisible()) {
                visivilidadVentanas();
                formPagoRecargo.setVisible(true);
            }
        });

        exit.addActionListener(e->{
            System.exit(0);
        });
    }

}
