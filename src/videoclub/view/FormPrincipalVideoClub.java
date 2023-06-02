package view;

import controller.*;
import model.Disco;

import javax.swing.*;
import java.awt.*;

public class FormPrincipalVideoClub extends JFrame {
    JPanel panelPrincipal;
    JButton botonAltas;
    JButton btnAlquiler;
    //JButton btnBajas;
    JButton btnDevolucion;
    JButton btnListados;
    JButton btnPagos;


    public FormPrincipalVideoClub() {
        Color fondo = new Color(143, 151, 203);
        Color fondoBotones = new Color(214, 220, 255);


        super.setLayout(null);
        super.setResizable(false);
        super.setBounds((MenuBar.ANCHO_PANTALLA/2)-200, (MenuBar.ALTO_PANTALLA/2)-150, 400,400);
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);

        panelPrincipal = new JPanel();
        panelPrincipal.setBackground(fondo);
        super.setContentPane(panelPrincipal);
        panelPrincipal.setBounds((MenuBar.ANCHO_PANTALLA/2)-250, (MenuBar.ALTO_PANTALLA/2)-125, 250,500);
        panelPrincipal.setLayout(null);

        botonAltas = new JButton("Altas");
        botonAltas.setBounds((super.getWidth()/2)-125, 20, 250,50);
        botonAltas.setFont(new Font("Arial", Font.BOLD, 20));
        botonAltas.setBackground(fondoBotones);
        panelPrincipal.add(botonAltas);

        btnAlquiler = new JButton("Alquiler");
        btnAlquiler .setFont(new Font("Arial", Font.BOLD, 20));
        btnAlquiler .setBounds((super.getWidth()/2)-125, 80, 250,50);
        btnAlquiler.setBackground(fondoBotones);
        panelPrincipal.add(btnAlquiler);

        btnDevolucion = new JButton("Devolución");
        btnDevolucion.setFont(new Font("Arial", Font.BOLD, 20));
        btnDevolucion.setBounds((super.getWidth()/2)-125, 140, 250,50);
        btnDevolucion.setBackground(fondoBotones);
        panelPrincipal.add(btnDevolucion);

        btnListados = new JButton("Listar");
        btnListados.setFont(new Font("Arial", Font.BOLD, 20));
        btnListados.setBounds((super.getWidth()/2)-125, 200, 250,50);
        btnListados.setBackground(fondoBotones);
        panelPrincipal.add(btnListados);

        btnPagos = new JButton("Pagos");
        btnPagos.setFont(new Font("Arial", Font.BOLD, 20));
        btnPagos.setBounds((super.getWidth()/2)-125, 260, 250,50);
        btnPagos.setBackground(fondoBotones);
        panelPrincipal.add(btnPagos);


        GestionBasesDatos.aniadiscoArrayMultimedia();
        GestionBasesDatos.aniadirSocios();
        GestionBasesDatos.aniadirVideojuego();
        GestionBasesDatos.aniadirPelicula();

        GestionBasesDatos.aniadirAlquiler(GestionMultimedia.multimedias, GestionSocioVideoClub.socios);
        Disco.agregarCancion(GestionMultimedia.multimedias, GestionBasesDatos.aniadirCancionArrayDisco());



        botonAltas.addActionListener(e -> {
            MenuBar.formPrincipalAltas.setDefaultCloseOperation(MenuBar.formPrincipalAltas.HIDE_ON_CLOSE);
//            MenuBar.formPrincipalAltas.setBounds(100, 100, 600, 300);
            if (!MenuBar.formPrincipalAltas.isVisible()) {
                MenuBar.formPrincipalAltas.setVisible(true);
            }
        });

        btnAlquiler.addActionListener(e -> {
            MenuBar.formAlquiler.setDefaultCloseOperation(MenuBar.formAlquiler.HIDE_ON_CLOSE);
            MenuBar.formAlquiler.setBounds(100, 100, 600, 300);
            if (!MenuBar.formAlquiler.isVisible()) {
                MenuBar.formAlquiler.setVisible(true);
            }
        });

        btnDevolucion.addActionListener(e -> {
            MenuBar.formDevoluciones.setDefaultCloseOperation(MenuBar.formDevoluciones.HIDE_ON_CLOSE);
            MenuBar.formDevoluciones.setBounds(100, 100, 600, 300);
            if (!MenuBar.formDevoluciones.isVisible()) {
                MenuBar.formDevoluciones.setVisible(true);
            }
        });

        btnListados.addActionListener(e -> {
            MenuBar.formListadosMultimedia.setDefaultCloseOperation(MenuBar.formListadosMultimedia.HIDE_ON_CLOSE);
            MenuBar.formListadosMultimedia.setBounds(100, 100, 600, 300);
            if (!MenuBar.formListadosMultimedia.isVisible()) {
                MenuBar.formListadosMultimedia.setVisible(true);
            }
        });

        btnPagos.addActionListener(e -> {
            MenuBar.formPagoRecargo.setDefaultCloseOperation(MenuBar.formPagoRecargo.HIDE_ON_CLOSE);
            MenuBar.formPagoRecargo.setBounds(100, 100, 600, 300);
            if (!MenuBar.formPagoRecargo.isVisible()) {
                MenuBar.formPagoRecargo.setVisible(true);
            }
        });
    }
}
