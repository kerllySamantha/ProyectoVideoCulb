package view;

import view.MenuBar;

import model.*;
import javax.swing.*;

public class FormAltaPelicula extends JFrame{
    private JPanel panelAltaPelicula;
    private JLabel tituloPelicula;
    private JLabel autorPelicula;
    private JLabel formatoPelicula;
    private JLabel anioPelicula;
    private JLabel duracionPelicula;
    private JButton btnAltaPelicula;
    private JTextField txtTituloPelicula;
    private JTextField txtAutorPelicula;
    private JTextField txtAnioPelicula;
    private JTextField txtDuracionPelicula;
    private JTextField txtActriz;
    private JTextField txtActor;
    private JRadioButton rbtnBlueray;
    private JRadioButton rbtnArchivo;
    private JRadioButton rbtnDVD;
    private JRadioButton rbtnCd;
    private JLabel actrizPelicula;
    private JLabel actorPelicula;


    public FormAltaPelicula() {
        super.setContentPane(panelAltaPelicula);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        super.setJMenuBar(MenuBar.crearMenuBar());

        btnAltaPelicula.addActionListener(actionEvent -> {
            String tituloPelicula = txtTituloPelicula.getText().toUpperCase();
            String autorPelicula = txtAutorPelicula.getText().toUpperCase();
            int anioPelicula = Integer.parseInt(txtAnioPelicula.getText());
            int duracionPelicula = Integer.parseInt(txtDuracionPelicula.getText());
            String actrizPrincipal = txtActriz.getText().toUpperCase();
            String actorPrincipal = txtActor.getText().toUpperCase();
            Formato formato = Formato.CD;
            if (rbtnArchivo.isSelected()) {
                formato = Formato.ARCHIVO;
            } else if (rbtnBlueray.isSelected()) {
                formato = Formato.BLURAY;
            } else if (rbtnCd.isSelected()) {
                formato = Formato.CD;
            } else if (rbtnDVD.isSelected()) {
                formato = Formato.DVD;
            }
            new Pelicula(tituloPelicula, autorPelicula,formato, anioPelicula, duracionPelicula, actrizPrincipal, actorPrincipal);

        });


    }
}
