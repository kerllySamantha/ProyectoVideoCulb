package view;

import controller.*;
import model.Disco;

import javax.swing.*;
import java.awt.*;

public class FormPrincipalVideoClub extends JFrame {
    JPanel panelPrincipal;
    JButton botonAltas;
    JButton btnAlquiler;
    JButton btnBajas;
    JButton btnDevolucion;
    JButton btnListados;

    FormPrincipalAltas formPrincipalAltas = new FormPrincipalAltas();
    FormDevoluciones formDevoluciones = new FormDevoluciones();
//    FormListadosMultimedia formListadosMultimedia = new FormListadosMultimedia();


    public FormPrincipalVideoClub() {
        super.setResizable(false);
        super.setLayout(null);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setBounds(100, 100, 250, 500);

        panelPrincipal = new JPanel();
        super.setContentPane(panelPrincipal);
        //add(panelPrincipal, BorderLayout.CENTER);
        super.setLocationRelativeTo(null);
        panelPrincipal.setLayout(new FlowLayout());

        botonAltas = new JButton("Altas");
        botonAltas.setMinimumSize(new Dimension(20, 20));
        botonAltas.setMaximumSize(new Dimension(250, 60));
        botonAltas.setPreferredSize(new Dimension(200, 30));
        panelPrincipal.add(botonAltas);


        GestionBasesDatos.aniadiscoArrayMultimedia();
        GestionBasesDatos.aniadirSocios();
        GestionBasesDatos.aniadirVideojuego();
        GestionBasesDatos.aniadirPelicula();


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
        panelPrincipal.add(btnAlquiler);

        btnDevolucion = new JButton("Devolución");
        btnDevolucion.setMinimumSize(new Dimension(20, 20));
        btnDevolucion.setMaximumSize(new Dimension(250, 60));
        btnDevolucion.setPreferredSize(new Dimension(200, 30));
        panelPrincipal.add(btnDevolucion);


        btnListados = new JButton("Listar");
        btnListados.setMinimumSize(new Dimension(20, 20));
        btnListados.setMaximumSize(new Dimension(250, 60));
        btnListados.setPreferredSize(new Dimension(200, 30));
        panelPrincipal.add(btnListados);


        botonAltas.addActionListener(e -> {
            formPrincipalAltas.setDefaultCloseOperation(formPrincipalAltas.HIDE_ON_CLOSE);
            formPrincipalAltas.setBounds(100, 100, 600, 300);
            if (!formPrincipalAltas.isVisible()) {
                formPrincipalAltas.setVisible(true);
            }
        });

        btnDevolucion.addActionListener(e -> {
            formDevoluciones.setDefaultCloseOperation(formDevoluciones.HIDE_ON_CLOSE);
            formDevoluciones.setBounds(100,100,600,300);
            if (!formDevoluciones.isVisible()) {
                formDevoluciones.setVisible(true);
            }
        });

//        btnListados.addActionListener(e -> {
//            formListadosMultimedia.setDefaultCloseOperation(formListadosMultimedia.HIDE_ON_CLOSE);
//            formListadosMultimedia.setBounds(100,100,600,300);
//            if (!formListadosMultimedia.isVisible()) {
//                formListadosMultimedia.setVisible(true);
//            }
//        });
    }
}
