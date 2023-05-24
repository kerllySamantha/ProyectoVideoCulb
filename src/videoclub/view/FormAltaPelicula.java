package view;

import javax.swing.*;

import model.*;

import java.util.Objects;

public class FormAltaPelicula extends JFrame {
    private JPanel panelAltaPelicula;
    private JLabel tituloPelicula;
    private JLabel autorPelicula;
    private JLabel formatoPelicula;
    private JLabel anioPelicula;
    private JLabel duracionPelicula;
    private JButton btnAltaPelicula;
    private JTextField txtTituloPelicula;
    private JTextField txtAutorPelicula;

    private JTextField txtDuracionPelicula;
    private JTextField txtActriz;
    private JTextField txtActor;
    private JRadioButton rbtnBlueray;
    private JRadioButton rbtnArchivo;
    private JRadioButton rbtnDVD;
    private JRadioButton rbtnCd;
    private JLabel actrizPelicula;
    private JLabel actorPelicula;
    private JComboBox<Integer> cbAnioPelicula;
    private JTextField txtGenero;
    private JLabel btnGenero;
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
                String tituloPelicula = txtTituloPelicula.getText().toUpperCase();
                ;
                String autorPelicula = txtAutorPelicula.getText().toUpperCase();
                ;
                int anioPelicula = Integer.parseInt((Objects.requireNonNull(cbAnioPelicula.getSelectedItem()).toString()));
                String duracionPelicula = String.valueOf(0);
                String actrizPrincipal = txtActriz.getText().toUpperCase(),
                        actorPrincipal = txtActor.getText().toUpperCase(),
                        genero = txtGenero.getText().toUpperCase();
                Formato formato = null;
                boolean datosCorrectos = true;

//                if (txtTituloPelicula.getText().equals("") && txtAutorPelicula.getText().equals("")) {
//                    JOptionPane.showMessageDialog(null, "El titulo de la perlicula ");
//                }

//                if (!txtTituloPelicula.getText().equals("")) {
//                    tituloPelicula = txtTituloPelicula.getText().toUpperCase();
//                } else {
//                    datosCorrectos = false;
//                    JOptionPane.showMessageDialog(null, "El titulo de la pelicula no puede estar vacia.");
//                }
//                if (!txtAutorPelicula.getText().equals("")) {
//                    autorPelicula = txtAutorPelicula.getText().toUpperCase();
//                } else {
//                    datosCorrectos = false;
//                    JOptionPane.showMessageDialog(null, "El Autor de la pelicula no puede estar vacio.");
//                }
//                if (Integer.parseInt(Objects.requireNonNull(cbAnioPelicula.getSelectedItem()).toString()) >= 1895) {
//                    anioPelicula = Integer.parseInt(String.valueOf(cbAnioPelicula.getSelectedIndex()));
//                } else {
//                    datosCorrectos = false;
//                    JOptionPane.showMessageDialog(null, "El anio de la Pelicula no puede ser vacio ni menor de 1895");
//                }
//                if (Integer.parseInt(txtDuracionPelicula.getText()) != 0) {
//                    duracionPelicula = txtDuracionPelicula.getText();
//                } else {
//                    datosCorrectos = false;
//                    JOptionPane.showMessageDialog(null, "La duración de la pelicula no puede ser 0, ni estar el campo vacio");
//                }
//                if (!txtActriz.getText().equals("")) {
//                    actrizPrincipal = txtActriz.getText().toUpperCase();
//                } else {
//                    datosCorrectos = false;
//                    JOptionPane.showMessageDialog(null, "El campo de actriz principal no puede estar vacio");
//                }
//                if (!txtActor.getText().equals("")) {
//                    actorPrincipal = txtActor.getText().toUpperCase();
//                } else {
//                    datosCorrectos = false;
//                    JOptionPane.showMessageDialog(null, "El campo de actor principal no puede estar vacio");
//                }
//                if(!txtGenero.getText().equals("")){
//                    genero = txtGenero.getText().toUpperCase();
//                }else {
//                    datosCorrectos = false;
//                    JOptionPane.showMessageDialog(null, "El campo del genero de la pelicula no puede estar vacio");
//                }

//                if (txtTituloPelicula.getText().equals("") && txtAutorPelicula.getText().equals("")) {
//                  JOptionPane.showMessageDialog(null, "El titulo de la perlicula ");
//                }

//                if (!txtTituloPelicula.getText().equals("")) {
//                    tituloPelicula = txtTituloPelicula.getText().toUpperCase();
//                } else {
//                    datosCorrectos = false;
//                    JOptionPane.showMessageDialog(null, "El titulo de la pelicula no puede estar vacia.");
//                }
//                if (!txtAutorPelicula.getText().equals("")) {
//                    autorPelicula = txtAutorPelicula.getText().toUpperCase();
//                } else {
//                    datosCorrectos = false;
//                    JOptionPane.showMessageDialog(null, "El Autor de la pelicula no puede estar vacio.");
//                }
//                if (Integer.parseInt(Objects.requireNonNull(cbAnioPelicula.getSelectedItem()).toString()) >= 1895) {
//                    anioPelicula = Integer.parseInt(String.valueOf(cbAnioPelicula.getSelectedIndex()));
//                } else {
//                    datosCorrectos = false;
//                    JOptionPane.showMessageDialog(null, "El anio de la Pelicula no puede ser vacio ni menor de 1895");
//                }
//                if (Integer.parseInt(txtDuracionPelicula.getText()) != 0) {
//                    duracionPelicula = txtDuracionPelicula.getText();
//                } else {
//                    datosCorrectos = false;
//                    JOptionPane.showMessageDialog(null, "La duración de la pelicula no puede ser 0, ni estar el campo vacio");
//                }
//                if (!txtActriz.getText().equals("")) {
//                    actrizPrincipal = txtActriz.getText().toUpperCase();
//                } else {
//                    datosCorrectos = false;
//                    JOptionPane.showMessageDialog(null, "El campo de actriz principal no puede estar vacio");
//                }
//                if (!txtActor.getText().equals("")) {
//                    actorPrincipal = txtActor.getText().toUpperCase();
//                } else {
//                    datosCorrectos = false;
//                    JOptionPane.showMessageDialog(null, "El campo de actor principal no puede estar vacio");
//                }
//                if(!txtGenero.getText().equals("")){
//                    genero = txtGenero.getText().toUpperCase();
//                }else {
//                    datosCorrectos = false;
//                    JOptionPane.showMessageDialog(null, "El campo del genero de la pelicula no puede estar vacio");
//                }


                if (txtTituloPelicula.getText().equals("")) {
                    datosCorrectos = false;
                    JOptionPane.showMessageDialog(null, "El titulo de la pelicula no puede estar vacia.");
                } else if (txtAutorPelicula.getText().equals("")) {
                    datosCorrectos = false;
                    JOptionPane.showMessageDialog(null, "El Autor de la pelicula no puede estar vacio.");
                } else if (Integer.parseInt(Objects.requireNonNull(cbAnioPelicula.getSelectedItem()).toString()) >= 1895) {
                    datosCorrectos = false;
                    JOptionPane.showMessageDialog(null, "El anio de la Pelicula no puede ser vacio ni menor de 1895");
                } else if (Integer.parseInt(txtDuracionPelicula.getText()) != 0) {
                    datosCorrectos = false;
                    JOptionPane.showMessageDialog(null, "La duración de la pelicula no puede ser 0, ni estar el campo vacio");
                } else if (txtActriz.getText().equals("")) {
                    datosCorrectos = false;
                    JOptionPane.showMessageDialog(null, "El campo de actriz principal no puede estar vacio");
                } else if (txtActor.getText().equals("")) {
                    datosCorrectos = false;
                    JOptionPane.showMessageDialog(null, "El campo de actor principal no puede estar vacio");
                } else if (txtGenero.getText().equals("")) {
                    datosCorrectos = false;
                    JOptionPane.showMessageDialog(null, "El campo del genero de la pelicula no puede estar vacio");
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
                    new Pelicula(tituloPelicula, autorPelicula, formato, anioPelicula, duracionPelicula, actrizPrincipal, actorPrincipal, genero);
                    JOptionPane.showMessageDialog(null, "Se ha dado  de alta correctamente la pelicula");
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }


}
