package view;

import controller.GestionMultimedia;
import controller.GestionSocioVideoClub;
import model.Disco;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBar {
    public static JMenuBar menuVideoClub;
    public static JMenu altas, bajas, alquileres, devoluciones, listados, salir;
    public static JMenuItem socio, videojuego, pelicula, disco, listMultimedia, listaPelisOrden, listaVideojAnio,
            listHistorialAlqSocioFecha, listActualSocio, listRecargosPendSocio, listaDiscos, devolver, exit, alquiler;
    public static FormAltaSocio formAltaSocio = new FormAltaSocio();
    public static FormAltaDisco formAltaDisco = new FormAltaDisco();
    public static FormAltaPelicula formAltaPelicula = new FormAltaPelicula();
    public static FormVideoJuego formAVideoJuego = new FormVideoJuego();
    public static FormPrincipalAltas formPrincipalAltas = new FormPrincipalAltas();
    public static FormDevoluciones formDevoluciones = new FormDevoluciones();
    public static FormAlquiler formAlquiler = new FormAlquiler();
    public static FormListadosMultimedia formListadosMultimedia = new FormListadosMultimedia();


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

        alquiler = new JMenuItem("Alquilar Multimedia");
        alquileres.add(alquiler);

        devolver = new JMenuItem("Devolver");
        devoluciones.add(devolver);

        listMultimedia = new JMenuItem("Multimedias");
        listaDiscos = new JMenuItem("Discos");
        listaPelisOrden = new JMenuItem("Peliculas en Orden");
        listaVideojAnio = new JMenuItem("Videojuego por año");
        listHistorialAlqSocioFecha = new JMenuItem("Historial de alquiler del Socio por fecha");
        listActualSocio = new JMenuItem("Actual del Socio");
        listRecargosPendSocio = new JMenuItem("Recargos pendientes");

        listados.add(listMultimedia);
        listados.add(listaPelisOrden);
        listados.add(listaVideojAnio);
        listados.add(listaDiscos);
        listados.add(listHistorialAlqSocioFecha);
        listados.add(listActualSocio);
        listados.add(listRecargosPendSocio);

        exit = new JMenuItem("Exit");
        salir.add(exit);

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



        devolver.addActionListener(e -> {
            formDevoluciones.setDefaultCloseOperation(formDevoluciones.HIDE_ON_CLOSE);
            formDevoluciones.setBounds(100,100,600,300);
            if(!formDevoluciones.isVisible()) {
                visivilidadVentanas();
                formDevoluciones.setVisible(true);
            }
        });

        alquiler.addActionListener(e -> {
            formAlquiler.setDefaultCloseOperation(formDevoluciones.HIDE_ON_CLOSE);
            formAlquiler.setBounds(100,100,600,300);
            if(!formAlquiler.isVisible()) {
                visivilidadVentanas();
                formAlquiler.setVisible(true);
            }
        });

        listMultimedia.addActionListener(e ->{
            formListadosMultimedia.setDefaultCloseOperation(formListadosMultimedia.HIDE_ON_CLOSE);
            formListadosMultimedia.setBounds(100,100,600,300);
            if(!formListadosMultimedia.isVisible()) {
                visivilidadVentanas();
                formListadosMultimedia.setVisible(true);
            }
            FormListadosMultimedia.txtListaMultimedia.setText(GestionMultimedia.ordenarMultimedia());
            FormListadosMultimedia.ocultarBtnTxtAlquilerSocio();

        });


        listaPelisOrden.addActionListener(e ->{
            formListadosMultimedia.setDefaultCloseOperation(formListadosMultimedia.HIDE_ON_CLOSE);
            formListadosMultimedia.setBounds(100,100,600,300);
            if(!formListadosMultimedia.isVisible()) {
                visivilidadVentanas();
                formListadosMultimedia.setVisible(true);
            }
            FormListadosMultimedia.txtListaMultimedia.setText(GestionMultimedia.ordenarPeliculas());
            FormListadosMultimedia.ocultarBtnTxtAlquilerSocio();
        });

        listActualSocio.addActionListener(e ->{
            formListadosMultimedia.setDefaultCloseOperation(formListadosMultimedia.HIDE_ON_CLOSE);
            formListadosMultimedia.setBounds(100,100,600,300);
            if(!formListadosMultimedia.isVisible()) {
                visivilidadVentanas();
                formListadosMultimedia.setVisible(true);
            }
            FormListadosMultimedia.listaAlquileresCLiente();

        });


        listRecargosPendSocio.addActionListener(e ->{
            formListadosMultimedia.setDefaultCloseOperation(formListadosMultimedia.HIDE_ON_CLOSE);
            formListadosMultimedia.setBounds(100,100,600,300);
            if(!formListadosMultimedia.isVisible()) {
                visivilidadVentanas();
                formListadosMultimedia.setVisible(true);
            }
            FormListadosMultimedia.txtListaMultimedia.setText(GestionSocioVideoClub.listaSociosRecargos());
            FormListadosMultimedia.ocultarBtnTxtAlquilerSocio();

        });

        listaVideojAnio.addActionListener(e ->{
            formListadosMultimedia.setDefaultCloseOperation(formListadosMultimedia.HIDE_ON_CLOSE);
            formListadosMultimedia.setBounds(100,100,600,300);
            if(!formListadosMultimedia.isVisible()) {
                visivilidadVentanas();
                formListadosMultimedia.setVisible(true);
            }
            FormListadosMultimedia.txtListaMultimedia.setText(GestionMultimedia.listaVideojuegos());
            FormListadosMultimedia.ocultarBtnTxtAlquilerSocio();

        });


        listaDiscos.addActionListener(e ->{
            formListadosMultimedia.setDefaultCloseOperation(formListadosMultimedia.HIDE_ON_CLOSE);
            formListadosMultimedia.setBounds(100,100,600,300);
            if(!formListadosMultimedia.isVisible()) {
                visivilidadVentanas();
                formListadosMultimedia.setVisible(true);
            }
            FormListadosMultimedia.txtListaMultimedia.setText(GestionMultimedia.ordenarDiscos());
            FormListadosMultimedia.ocultarBtnTxtAlquilerSocio();
        });

        exit.addActionListener(e->{
            System.exit(0);
        });
    }

}
