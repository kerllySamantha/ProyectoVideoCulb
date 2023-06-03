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
        txtNif.setBounds(230, 20, 100, 25);
        panel.add(txtNif);

        lblListados = new JLabel("Listados");
        lblListados.setBounds(35, 35, 100, 25);
        lblListados.setFont(new Font(lblListados.getFont().getFontName(), Font.BOLD, 16));
        panel.add(lblListados);


        txtListaMultimedia = new JTextArea();
        txtListaMultimedia.setEditable(false);
        txtListaMultimedia.setLineWrap(true);
        txtListaMultimedia.setWrapStyleWord(true);


        JScrollPane scrollPane = new JScrollPane(txtListaMultimedia);
        scrollPane.setBounds(200, 50, 250, 210);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        panel.add(scrollPane);

        crearBotones();
        listaAlquileresCLiente();
        ocultarBtnTxtAlquilerSocio();

        JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
        verticalScrollBar.setValue(verticalScrollBar.getMinimum());


    }

    public void crearBotones() {
        btnListaMult = new JButton("Multimedia");
        btnListaMult.setBounds(20, 80, 150, 25);
        panel.add(btnListaMult);

        btnListaPeliculas = new JButton("Peliculas A-Z");
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
        btnBuscarNif.setBounds(350, 20, 125, 25);
        panel.add(btnBuscarNif);


        btnListaMult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtNif.setVisible(false);
                btnBuscarNif.setVisible(false);
                txtListaMultimedia.setText(GestionMultimedia.ordenarMultimedia());
                txtListaMultimedia.setCaretPosition(0);
            }
        });

        btnListaPeliculas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtNif.setVisible(false);
                btnBuscarNif.setVisible(false);
                txtListaMultimedia.setText(GestionMultimedia.ordenarPeliculas());
                txtListaMultimedia.setCaretPosition(0);
            }
        });

        btnListaVideojuego.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtNif.setVisible(false);
                btnBuscarNif.setVisible(false);
                txtListaMultimedia.setText(GestionMultimedia.listaVideojuegos());
                txtListaMultimedia.setCaretPosition(0);
            }
        });

        btnListaDisco.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtNif.setVisible(false);
                btnBuscarNif.setVisible(false);
                txtListaMultimedia.setText(GestionMultimedia.ordenarDiscos());
                txtListaMultimedia.setCaretPosition(0);
            }
        });

        btnListaAlquileres.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtListaMultimedia.setText("");
                txtNif.setVisible(true);
                btnBuscarNif.setVisible(true);
                txtListaMultimedia.setCaretPosition(0);
            }
        });

        btnBuscarNif.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtListaMultimedia.setText(GestionSocioVideoClub.listaAlquilerActual(txtNif.getText()));
                txtListaMultimedia.setCaretPosition(0);
            }
        });

        btnListaRecargos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtListaMultimedia.setText(GestionSocioVideoClub.listaSociosRecargos());
                txtListaMultimedia.setCaretPosition(0);
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
