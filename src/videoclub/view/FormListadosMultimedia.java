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
        panel.setBackground(new Color(143,151,203));

        txtNif = new JTextField();
        txtNif.setBounds(170, 20, 100, 25);
        panel.add(txtNif);

        lblListados = new JLabel("Listados");
        lblListados.setBounds(35, 35, 100, 25);
        lblListados.setFont(new Font(lblListados.getFont().getFontName(), Font.BOLD, 16));
        lblListados.setForeground(new Color(214,220,255));
        panel.add(lblListados);


        txtListaMultimedia = new JTextArea();
        //txtListaMultimedia.setBounds(200, 50, 430, 410);
        txtListaMultimedia.setEditable(false);
        txtListaMultimedia.setLineWrap(true);
        txtListaMultimedia.setWrapStyleWord(true);
        txtListaMultimedia.setBackground(new Color(214,220,255));
        txtListaMultimedia.setForeground(new Color(143,151,203));
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
        btnListaMult.setBackground(new Color(214,220,255));
        btnListaMult.setForeground(new Color(143,151,203));
        panel.add(btnListaMult);

        btnListaPeliculas = new JButton("Peliculas por año");
        btnListaPeliculas.setBounds(20, 110, 150, 25);
        btnListaPeliculas.setBackground(new Color(214,220,255));
        btnListaPeliculas.setForeground(new Color(143,151,203));
        panel.add(btnListaPeliculas);

        btnListaDisco = new JButton("Discos por duración");
        btnListaDisco.setBounds(20, 140, 150, 25);
        btnListaDisco.setBackground(new Color(214,220,255));
        btnListaDisco.setForeground(new Color(143,151,203));
        panel.add(btnListaDisco);

        btnListaVideojuego = new JButton("VIdeojuegos por año");
        btnListaVideojuego.setBounds(20, 170, 150, 25);
        btnListaVideojuego.setBackground(new Color(214,220,255));
        btnListaVideojuego.setForeground(new Color(143,151,203));
        panel.add(btnListaVideojuego);

        btnListaAlquileres = new JButton("Alquiler actual");
        btnListaAlquileres.setBounds(20, 200, 150, 25);
        btnListaAlquileres.setBackground(new Color(214,220,255));
        btnListaAlquileres.setForeground(new Color(143,151,203));
        panel.add(btnListaAlquileres);


        btnListaRecargos = new JButton("Socios con recargo");
        btnListaRecargos.setBounds(20, 230, 150, 25);
        btnListaRecargos.setBackground(new Color(214,220,255));
        btnListaRecargos.setForeground(new Color(143,151,203));
        panel.add(btnListaRecargos);

        btnBuscarNif = new JButton("Buscar Socio");
        btnBuscarNif.setBounds(300, 20, 125, 25);
        btnBuscarNif.setBackground(new Color(214,220,255));
        btnBuscarNif.setForeground(new Color(143,151,203));
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
        txtNif.setBackground(new Color(214,220,255));
        txtNif.setForeground(new Color(143,151,203));
    }

    public static void ocultarBtnTxtAlquilerSocio() {
        txtNif.setVisible(false);
        btnBuscarNif.setVisible(false);
    }
}
