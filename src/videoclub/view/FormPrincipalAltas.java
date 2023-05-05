package view;

import javax.swing.*;
import java.awt.*;

public class FormPrincipalAltas extends JFrame {
    JPanel panelPrincipalAltas;
    JButton altaSocio;
    JButton altaVideojuego;
    JButton altaPelicula;
    JButton altaDisco;

//    static FormAltaSocio formAltaSocio = new FormAltaSocio();
//    static FormAltaDisco formAltaDisco = new FormAltaDisco();
//    static FormAltaPelicula formAltaPelicula = new FormAltaPelicula();
//    static FormVideoJuego formAVideoJuego = new FormVideoJuego();

    public FormPrincipalAltas() {

        super.setLayout(null);
        super.setResizable(false);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setBounds(100, 100, 250, 500);

        panelPrincipalAltas = new JPanel();
        super.setContentPane(panelPrincipalAltas);

        altaSocio = new JButton("Socio");
        altaSocio.setMinimumSize(new Dimension(20, 20));
        altaSocio.setMaximumSize(new Dimension(150, 60));
        altaSocio.setPreferredSize(new Dimension(120, 30));
        panelPrincipalAltas.add(altaSocio);

        altaVideojuego = new JButton("Videojuego");
        altaVideojuego.setMinimumSize(new Dimension(20, 20));
        altaVideojuego.setMaximumSize(new Dimension(150, 60));
        altaVideojuego.setPreferredSize(new Dimension(120, 30));
        panelPrincipalAltas.add(altaVideojuego);

        altaPelicula = new JButton("Peliculas");
        altaPelicula.setMinimumSize(new Dimension(20, 20));
        altaPelicula.setMaximumSize(new Dimension(150, 60));
        altaPelicula.setPreferredSize(new Dimension(120, 30));
        panelPrincipalAltas.add(altaPelicula);

        altaDisco = new JButton("Disco");
        altaDisco.setMinimumSize(new Dimension(20, 20));
        altaDisco.setMaximumSize(new Dimension(150, 60));
        altaDisco.setPreferredSize(new Dimension(120, 30));
        panelPrincipalAltas.add(altaDisco);

        altaSocio.addActionListener(e -> {
            MenuBar.formAltaSocio.setDefaultCloseOperation(MenuBar.formAltaSocio.HIDE_ON_CLOSE);
            MenuBar.formAltaSocio.setBounds(100, 100, 600, 300);
            if (!MenuBar.formAltaSocio.isVisible()) {
                MenuBar.formAltaSocio.setVisible(true);
            }
        });

        altaDisco.addActionListener(e -> {
            MenuBar.formAltaDisco.setDefaultCloseOperation(MenuBar.formAltaDisco.HIDE_ON_CLOSE);
            MenuBar.formAltaDisco.setBounds(100, 100, 600, 300);
            if (! MenuBar.formAltaDisco.isVisible()) {
                MenuBar.formAltaDisco.setVisible(true);
            }
        });
        altaPelicula.addActionListener(e -> {
            MenuBar.formAltaPelicula.setDefaultCloseOperation( MenuBar.formAltaPelicula.HIDE_ON_CLOSE);
            MenuBar.formAltaPelicula.setBounds(100, 100, 600, 300);
            if (! MenuBar.formAltaPelicula.isVisible()) {
                MenuBar.formAltaPelicula.setVisible(true);
            }
        });
        altaVideojuego.addActionListener(e -> {
            MenuBar.formAVideoJuego.setDefaultCloseOperation( MenuBar.formAVideoJuego.HIDE_ON_CLOSE);
            MenuBar.formAVideoJuego.setBounds(100, 100, 600, 300);
            if (! MenuBar.formAVideoJuego.isVisible()) {
                MenuBar.formAVideoJuego.setVisible(true);
            }
        });
    }
}
