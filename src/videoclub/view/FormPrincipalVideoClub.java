package view;

import javax.swing.*;
import java.awt.*;

public class FormPrincipalVideoClub extends JFrame {
    JPanel panelPrincipal;
    JButton botonAltas;
    JButton alquileres;
    JButton botonBajas;
    JButton devoluciones;
    JButton listados;


    public FormPrincipalVideoClub() {
        panelPrincipal = new JPanel();
        super.setContentPane(panelPrincipal);
        super.setLayout(null);
        super.setResizable(false);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setBounds(100, 100, 250, 500);

        botonAltas = new JButton("Altas");
        botonBajas = new JButton("Bajas");
        botonBajas.setFont(new Font("Titulo", Font.BOLD, 30));


    }


}
