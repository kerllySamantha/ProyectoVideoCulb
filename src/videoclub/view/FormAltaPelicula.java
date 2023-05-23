package view;

import javax.swing.*;
import model.*;
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
    private JComboBox cbAnioPelicula;
    private Pelicula pelicula;

    public FormAltaPelicula() {
        super.setContentPane(panelAltaPelicula);
        super.setLocationRelativeTo(null);
        super.setJMenuBar(MenuBar.crearMenuBar());
        MenuBar.gestionDeVentanas();
        altaPelicula();

    }

    public void altaPelicula() {
        MenuBar.gestionDeVentanas();
        btnAltaPelicula.addActionListener(actionEvent -> {
            try {
                String tituloPelicula = "";
                String autorPelicula = "";
                int anioPelicula = 0;
                int duracionPelicula = 0;
                String actrizPrincipal = "";
                String actorPrincipal = "";
                Formato formato = null;
                boolean datosCorrectos = true;

                if (txtTituloPelicula.getText().equals("") && txtAutorPelicula.getText().equals("")) {

                }

                if (!txtTituloPelicula.getText().equals("")) {
                    tituloPelicula = txtTituloPelicula.getText().toUpperCase();
                } else {
                    datosCorrectos = false;
                }
                if (!txtAutorPelicula.getText().equals("")) {
                    autorPelicula = txtAutorPelicula.getText().toUpperCase();
                } else {
                    datosCorrectos = false;
                }
                if (Integer.parseInt(txtAnioPelicula.getText()) >= 1895) {
                    anioPelicula = Integer.parseInt(txtAnioPelicula.getText());
                } else {
                    datosCorrectos = false;
                }
                if (Integer.parseInt(txtDuracionPelicula.getText()) != 0) {
                    duracionPelicula = Integer.parseInt(txtDuracionPelicula.getText());
                } else {
                    datosCorrectos = false;
                }
                if (!txtActriz.getText().equals("")) {
                    actrizPrincipal = txtActriz.getText().toUpperCase();
                } else {
                    datosCorrectos = false;
                }
                if (!txtActor.getText().equals("")) {
                    actorPrincipal = txtActor.getText().toUpperCase();
                } else {
                    datosCorrectos = false;
                }

                if (rbtnArchivo.isSelected()) {
                    formato = Formato.ARCHIVO;
                } else if (rbtnBlueray.isSelected()) {
                    formato = Formato.BLUERAY;
                } else if (rbtnCd.isSelected()) {
                    formato = Formato.CD;
                } else if (rbtnDVD.isSelected()) {
                    formato = Formato.DVD;
                }


                if (datosCorrectos) {
                    //new Pelicula(tituloPelicula, autorPelicula, formato, anioPelicula, duracionPelicula, actrizPrincipal, actorPrincipal);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        });
    }


}
