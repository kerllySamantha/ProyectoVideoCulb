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
        super.setLayout(null);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setBounds(100, 100, 250, 500);

        panelPrincipal = new JPanel();
        panelPrincipal.setBackground(fondo);
        super.setContentPane(panelPrincipal);
        //add(panelPrincipal, BorderLayout.CENTER);
        super.setLocationRelativeTo(null);
        panelPrincipal.setLayout(new FlowLayout());

        botonAltas = new JButton("Altas");
        botonAltas.setMinimumSize(new Dimension(20, 20));
        botonAltas.setMaximumSize(new Dimension(250, 60));
        botonAltas.setPreferredSize(new Dimension(200, 30));
        botonAltas.setBackground(fondoBotones);
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
        btnAlquiler.setMinimumSize(new Dimension(20, 20));
        btnAlquiler.setMaximumSize(new Dimension(250, 60));
        btnAlquiler.setPreferredSize(new Dimension(200, 30));
        btnAlquiler.setBackground(fondoBotones);
        panelPrincipal.add(btnAlquiler);

        btnDevolucion = new JButton("Devolución");
        btnDevolucion.setMinimumSize(new Dimension(20, 20));
        btnDevolucion.setMaximumSize(new Dimension(250, 60));
        btnDevolucion.setPreferredSize(new Dimension(200, 30));
        btnDevolucion.setBackground(fondoBotones);
        panelPrincipal.add(btnDevolucion);

        btnListados = new JButton("Listar");
        btnListados.setMinimumSize(new Dimension(20, 20));
        btnListados.setMaximumSize(new Dimension(250, 60));
        btnListados.setPreferredSize(new Dimension(200, 30));
        btnListados.setBackground(fondoBotones);
        panelPrincipal.add(btnListados);

        btnPagos = new JButton("Pagos");
        btnPagos.setMinimumSize(new Dimension(20, 20));
        btnPagos.setMaximumSize(new Dimension(250, 60));
        btnPagos.setPreferredSize(new Dimension(200, 30));
        btnPagos.setBackground(fondoBotones);
        panelPrincipal.add(btnPagos);


        botonAltas.addActionListener(e -> {
            MenuBar.formPrincipalAltas.setDefaultCloseOperation(MenuBar.formPrincipalAltas.HIDE_ON_CLOSE);
            MenuBar.formPrincipalAltas.setBounds(100, 100, 600, 300);
            if (!MenuBar.formPrincipalAltas.isVisible()) {
                MenuBar.formPrincipalAltas.setVisible(true);
            }
        });

        btnAlquiler.addActionListener(e -> {
            MenuBar.formAlquiler.setDefaultCloseOperation(MenuBar.formAlquiler.HIDE_ON_CLOSE);
            MenuBar.formAlquiler.setBounds(100,100,600,300);
            if(!MenuBar.formAlquiler.isVisible()) {
                MenuBar.formAlquiler.setVisible(true);
            }
        });

        btnDevolucion.addActionListener(e -> {
            MenuBar.formDevoluciones.setDefaultCloseOperation(MenuBar.formDevoluciones.HIDE_ON_CLOSE);
            MenuBar.formDevoluciones.setBounds(100,100,600,300);
            if (!MenuBar.formDevoluciones.isVisible()) {
                MenuBar.formDevoluciones.setVisible(true);
            }
        });

        btnListados.addActionListener(e -> {
            MenuBar.formListadosMultimedia.setDefaultCloseOperation(MenuBar.formListadosMultimedia.HIDE_ON_CLOSE);
            MenuBar.formListadosMultimedia.setBounds(100,100,600,300);
            if (!MenuBar.formListadosMultimedia.isVisible()) {
                MenuBar.formListadosMultimedia.setVisible(true);
            }
        });

        btnPagos.addActionListener(e -> {
            MenuBar.formPagoRecargo.setDefaultCloseOperation(MenuBar.formPagoRecargo.HIDE_ON_CLOSE);
            MenuBar.formPagoRecargo.setBounds(100,100,600,300);
            if (!MenuBar.formPagoRecargo.isVisible()) {
                MenuBar.formPagoRecargo.setVisible(true);
            }
        });
    }
}
