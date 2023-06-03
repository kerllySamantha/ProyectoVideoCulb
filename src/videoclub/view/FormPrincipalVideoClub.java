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

//    public static FormPrincipalAltas formPrincipalAltas = new FormPrincipalAltas();
//    public  static FormAlquiler formAlquiler = new FormAlquiler();
//    public static FormDevoluciones formDevoluciones = new FormDevoluciones();
//    public static FormListadosMultimedia formListadosMultimedia = new FormListadosMultimedia();
//    public static  FormPagoRecargo formPagoRecargo = new FormPagoRecargo();

    public FormPrincipalVideoClub() {
        Color fondo = new Color(143,151,203);
        Color fondoBotones = new Color(214,220,255);

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
        botonAltas.setForeground(fondo);
        botonAltas.setFont(new Font("Arial",Font.BOLD,18));
        panelPrincipal.add(botonAltas);


        GestionBasesDatos.aniadiscoArrayMultimedia();
        GestionBasesDatos.aniadirSocios();
        GestionBasesDatos.aniadirVideojuego();
        GestionBasesDatos.aniadirPelicula();

        GestionBasesDatos.aniadirAlquiler(GestionMultimedia.multimedias, GestionSocioVideoClub.socios);
        Disco.agregarCancion(GestionMultimedia.multimedias, GestionBasesDatos.aniadirCancionArrayDisco());


//        btnBajas = new JButton("Bajas");
//        btnBajas.setMinimumSize(new Dimension(20, 20));
//        btnBajas.setMaximumSize(new Dimension(250, 60));
//        btnBajas.setPreferredSize(new Dimension(200, 30));
//        panelPrincipal.add(btnBajas);
        //btnBajas.setFont(new Font("Titulo", Font.BOLD, 30));

        btnAlquiler = new JButton("Alquiler");
        btnAlquiler .setFont(new Font("Arial", Font.BOLD, 20));
        btnAlquiler .setBounds((super.getWidth()/2)-125, 80, 250,50);
        btnAlquiler.setBackground(fondoBotones);
        btnAlquiler.setForeground(fondo);
        btnAlquiler.setFont(new Font("Arial",Font.BOLD,16));
        panelPrincipal.add(btnAlquiler);

        btnDevolucion = new JButton("Devolución");
        btnDevolucion.setFont(new Font("Arial", Font.BOLD, 20));
        btnDevolucion.setBounds((super.getWidth()/2)-125, 140, 250,50);
        btnDevolucion.setBackground(fondoBotones);
        btnDevolucion.setForeground(fondo);
        btnDevolucion.setFont(new Font("Arial",Font.BOLD,16));
        panelPrincipal.add(btnDevolucion);

        btnListados = new JButton("Listar");
        btnListados.setFont(new Font("Arial", Font.BOLD, 20));
        btnListados.setBounds((super.getWidth()/2)-125, 200, 250,50);
        btnListados.setBackground(fondoBotones);
        btnListados.setForeground(fondo);
        btnListados.setFont(new Font("Arial",Font.BOLD,16));
        panelPrincipal.add(btnListados);

        btnPagos = new JButton("Pagos");
        btnPagos.setFont(new Font("Arial", Font.BOLD, 20));
        btnPagos.setBounds((super.getWidth()/2)-125, 260, 250,50);
        btnPagos.setBackground(fondoBotones);
        btnPagos.setForeground(fondo);
        btnPagos.setFont(new Font("Arial",Font.BOLD,16));
        panelPrincipal.add(btnPagos);


        botonAltas.addActionListener(e -> {
            MenuBar.formPrincipalAltas.setDefaultCloseOperation(MenuBar.formPrincipalAltas.HIDE_ON_CLOSE);
            MenuBar.formPrincipalAltas.setBounds((MenuBar.ANCHO_PANTALLA/2)-200, (MenuBar.ALTO_PANTALLA/2)-225, 400,400);
            if (!MenuBar.formPrincipalAltas.isVisible()) {
                MenuBar.formPrincipalAltas.setVisible(true);
            }
        });

        btnAlquiler.addActionListener(e -> {
            MenuBar.formAlquiler.setDefaultCloseOperation(MenuBar.formAlquiler.HIDE_ON_CLOSE);
            MenuBar.formAlquiler.setBounds((MenuBar.ANCHO_PANTALLA/2)-250, (MenuBar.ALTO_PANTALLA/2)-275, 500,500);
            if (!MenuBar.formAlquiler.isVisible()) {
                MenuBar.formAlquiler.setVisible(true);
            }
        });

        btnDevolucion.addActionListener(e -> {
            MenuBar.formDevoluciones.setDefaultCloseOperation(MenuBar.formDevoluciones.HIDE_ON_CLOSE);
            MenuBar.formDevoluciones.setBounds((MenuBar.ANCHO_PANTALLA/2)-250, (MenuBar.ALTO_PANTALLA/2)-275, 500,500);
            if (!MenuBar.formDevoluciones.isVisible()) {
                MenuBar.formDevoluciones.setVisible(true);
            }
        });

        btnListados.addActionListener(e -> {
            MenuBar.formListadosMultimedia.setDefaultCloseOperation(MenuBar.formListadosMultimedia.HIDE_ON_CLOSE);
            MenuBar.formListadosMultimedia.setBounds((MenuBar.ANCHO_PANTALLA/2)-250, (MenuBar.ALTO_PANTALLA/2)-275, 500,500);
            if (!MenuBar.formListadosMultimedia.isVisible()) {
                MenuBar.formListadosMultimedia.setVisible(true);
            }
        });

        btnPagos.addActionListener(e -> {
            MenuBar.formPagoRecargo.setDefaultCloseOperation(MenuBar.formPagoRecargo.HIDE_ON_CLOSE);
            MenuBar.formPagoRecargo.setBounds((MenuBar.ANCHO_PANTALLA/2)-250, (MenuBar.ALTO_PANTALLA/2)-275, 500,500);
            if (!MenuBar.formPagoRecargo.isVisible()) {
                MenuBar.formPagoRecargo.setVisible(true);
            }
        });
    }
}
