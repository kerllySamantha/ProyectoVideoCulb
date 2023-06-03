package view;

import javax.swing.*;
import java.awt.*;

public class FormPrincipalAltas extends JFrame {
    JPanel panelPrincipalAltas;
    JButton altaSocio;
    JButton altaVideojuego;
    JButton altaPelicula;
    JButton altaDisco;



    public FormPrincipalAltas() {
        Color fondo = new Color(143,151,203);
        Color fondoBotones = new Color(214,220,255);

        super.setLayout(null);
        super.setResizable(false);
        super.setBounds((MenuBar.ANCHO_PANTALLA/2)-250, (MenuBar.ALTO_PANTALLA/2)-225, 400,400);
        super.setLocationRelativeTo(null);

        panelPrincipalAltas = new JPanel();

        panelPrincipalAltas.setBackground(fondo);
        super.setContentPane(panelPrincipalAltas);
        panelPrincipalAltas.setLayout(null);

        altaSocio = new JButton("Socio");
        altaSocio.setBounds((super.getWidth()/2)-125, 20, 250,50);
        altaSocio.setFont(new Font("Arial", Font.BOLD, 20));
        altaSocio.setBackground(fondoBotones);
        altaSocio.setForeground(fondo);
        altaSocio.setFont(new Font("Arial",Font.BOLD,16));
        panelPrincipalAltas.add(altaSocio);

        altaVideojuego = new JButton("Videojuego");
        altaVideojuego.setFont(new Font("Arial", Font.BOLD, 20));
        altaVideojuego.setBounds((super.getWidth()/2)-125, 90, 250,50);
        altaVideojuego.setBackground(fondoBotones);
        altaVideojuego.setForeground(fondo);
        altaVideojuego.setFont(new Font("Arial",Font.BOLD,16));
        panelPrincipalAltas.add(altaVideojuego);

        altaPelicula = new JButton("Peliculas");
        altaPelicula.setFont(new Font("Arial", Font.BOLD, 20));
        altaPelicula.setBounds((super.getWidth()/2)-125, 160, 250,50);
        altaPelicula.setBackground(fondoBotones);
        altaPelicula.setForeground(fondo);
        altaPelicula.setFont(new Font("Arial",Font.BOLD,16));
        panelPrincipalAltas.add(altaPelicula);

        altaDisco = new JButton("Disco");
        altaDisco.setFont(new Font("Arial", Font.BOLD, 20));
        altaDisco.setBounds((super.getWidth()/2)-125, 230, 250,50);
        altaDisco.setBackground(fondoBotones);
        altaDisco.setForeground(fondo);
        altaDisco.setFont(new Font("Arial",Font.BOLD,16));
        panelPrincipalAltas.add(altaDisco);

        altaSocio.addActionListener(e -> {
            MenuBar.formAltaSocio.setDefaultCloseOperation(MenuBar.formAltaSocio.HIDE_ON_CLOSE);
            MenuBar.formAltaSocio.setBounds((MenuBar.ANCHO_PANTALLA/2)-250, (MenuBar.ALTO_PANTALLA/2)-275, 500,500);
            if (!MenuBar.formAltaSocio.isVisible()) {
                MenuBar.formAltaSocio.setVisible(true);
            }
        });

        altaDisco.addActionListener(e -> {
            MenuBar.formAltaDisco.setDefaultCloseOperation(MenuBar.formAltaDisco.HIDE_ON_CLOSE);
            MenuBar.formAltaDisco.setBounds((MenuBar.ANCHO_PANTALLA/2)-250, (MenuBar.ALTO_PANTALLA/2)-275, 500,500);
            if (! MenuBar.formAltaDisco.isVisible()) {
                MenuBar.formAltaDisco.setVisible(true);
            }
        });
        altaPelicula.addActionListener(e -> {
            MenuBar.formAltaPelicula.setDefaultCloseOperation( MenuBar.formAltaPelicula.HIDE_ON_CLOSE);
            MenuBar.formAltaPelicula.setBounds((MenuBar.ANCHO_PANTALLA/2)-250, (MenuBar.ALTO_PANTALLA/2)-275, 500,500);
            if (! MenuBar.formAltaPelicula.isVisible()) {
                MenuBar.formAltaPelicula.setVisible(true);
            }
        });
        altaVideojuego.addActionListener(e -> {
            MenuBar.formAVideoJuego.setDefaultCloseOperation( MenuBar.formAVideoJuego.HIDE_ON_CLOSE);
            MenuBar.formAVideoJuego.setBounds((MenuBar.ANCHO_PANTALLA/2)-250, (MenuBar.ALTO_PANTALLA/2)-275, 500,500);
            if (! MenuBar.formAVideoJuego.isVisible()) {
                MenuBar.formAVideoJuego.setVisible(true);
            }
        });
    }
}
