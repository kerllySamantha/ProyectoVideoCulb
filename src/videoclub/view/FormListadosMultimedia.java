package view;

import controller.*;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormListadosMultimedia extends JFrame {
    private JPanel panel;
    public static JTextArea txtListaMultimedia;
    private static JTextField txtNif;
    private static JButton btnListaAlquileres, btnBuscarNif;
    private JLabel lblListados;
    private JButton btnListaMult, btnListaPeliculas, btnListaVideojuego, btnListaDisco,  btnListaRecargos;


    public FormListadosMultimedia() {
        this.setTitle("");
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setSize(450, 500);
        //this.setResizable(false);
        super.setJMenuBar(MenuBar.crearMenuBar());
        MenuBar.gestionDeVentanas();

        panel = new JPanel();
        panel.setBounds(0, 0, 450, 500);
        this.setContentPane(panel);
        panel.setLayout(null);

        txtNif = new JTextField();
        txtNif.setBounds(170, 20, 100, 25);
        panel.add(txtNif);

        lblListados = new JLabel("Listados");
        lblListados.setBounds(35, 35, 100, 25);
        lblListados.setFont(new Font(lblListados.getFont().getFontName(), Font.BOLD, 16));
        panel.add(lblListados);


        txtListaMultimedia = new JTextArea();
        //txtListaMultimedia.setBounds(200, 50, 430, 410);
        txtListaMultimedia.setEditable(false);
        txtListaMultimedia.setLineWrap(true);
        txtListaMultimedia.setWrapStyleWord(true);
        //panel.add(txtListaMultimedia);

        JScrollPane scrollPane = new JScrollPane(txtListaMultimedia);
        scrollPane.setBounds(200, 50, 430, 210);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        panel.add(scrollPane);

        crearBotones();
        listaAlquileresCLiente();
        ocultarBtnTxtAlquilerSocio();

        JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
        verticalScrollBar.setValue(verticalScrollBar.getMinimum());


    }

    public void crearBotones() {
        btnListaMult = new JButton("Multimedia alfabéticamente");
        btnListaMult.setBounds(20, 80, 150, 25);
        panel.add(btnListaMult);

        btnListaPeliculas = new JButton("Peliculas por año");
        btnListaPeliculas.setBounds(20, 110, 150, 25);
        panel.add(btnListaPeliculas);

        btnListaDisco = new JButton("Discos por duración");
        btnListaDisco.setBounds(20, 140, 150, 25);
        panel.add(btnListaDisco);

        btnListaVideojuego = new JButton("VIdeojuegos por año");
        btnListaVideojuego.setBounds(20, 170, 150, 25);
        panel.add(btnListaVideojuego);

        btnListaAlquileres = new JButton("Alquiler actual");
        btnListaAlquileres.setBounds(20, 200, 150, 25);
        panel.add(btnListaAlquileres);


        btnListaRecargos = new JButton("Socios con recargo");
        btnListaRecargos.setBounds(20, 230, 150, 25);
        panel.add(btnListaRecargos);

        btnBuscarNif = new JButton("Buscar Socio");
        btnBuscarNif.setBounds(300, 20, 125, 25);
        panel.add(btnBuscarNif);


        btnListaMult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtNif.setVisible(false);
                btnBuscarNif.setVisible(false);
                txtListaMultimedia.setText(GestionMultimedia.ordenarMultimedia());
            }
        });

        btnListaPeliculas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtNif.setVisible(false);
                btnBuscarNif.setVisible(false);
                txtListaMultimedia.setText(GestionMultimedia.ordenarPeliculas());

            }
        });

        btnListaVideojuego.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtNif.setVisible(false);
                btnBuscarNif.setVisible(false);
                txtListaMultimedia.setText(GestionMultimedia.listaVideojuegos());
            }
        });

        btnListaDisco.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtNif.setVisible(false);
                btnBuscarNif.setVisible(false);
                txtListaMultimedia.setText(GestionMultimedia.ordenarDiscos());
            }
        });

        btnListaAlquileres.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtNif.setVisible(true);
                btnBuscarNif.setVisible(true);
            }
        });
        btnListaAlquileres.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtListaMultimedia.setText("");
                txtNif.setVisible(false);
                btnBuscarNif.setVisible(false);
            }
        });

        btnBuscarNif.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtListaMultimedia.setText(GestionSocioVideoClub.listaAlquilerActual(txtNif.getText()));
            }
        });

        btnListaRecargos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtListaMultimedia.setText(GestionSocioVideoClub.listaSociosRecargos());
            }
        });
    }

    public static void listaAlquileresCLiente() {
        txtListaMultimedia.setText("");
        txtNif.setVisible(true);
        btnBuscarNif.setVisible(true);
    }

    public static void ocultarBtnTxtAlquilerSocio() {
        txtNif.setVisible(false);
        btnBuscarNif.setVisible(false);
    }
}
