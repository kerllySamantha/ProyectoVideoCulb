package view;

import javax.swing.*;

import controller.GestionBasesDatos;
import controller.GestionLogs;
import controller.GestionMultimedia;
import model.*;

import java.util.Objects;

public class FormAltaPelicula extends JFrame {
    public static final int ANIO_PRIMERA_PELICULA = 1895;
    public static final int ANIO_ACTUAL = 2023;
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
    private JLabel lblgenero;
    private JTextField txtGenero;
    private JLabel btnGenero;
    private Pelicula pelicula;

    public FormAltaPelicula() {
        super.setContentPane(panelAltaPelicula);
        super.setLocationRelativeTo(null);
        super.setJMenuBar(MenuBar.crearMenuBar());
        MenuBar.gestionDeVentanas();
        altaPelicula();

        valoresCBAnio();

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

                if (txtTituloPelicula.getText().equals("")) {
                    datosCorrectos = false;
                    JOptionPane.showMessageDialog(null, "El titulo de la pelicula no puede estar vacia.");
                } else if (txtAutorPelicula.getText().equals("")) {
                    datosCorrectos = false;
                    JOptionPane.showMessageDialog(null, "El Autor de la pelicula no puede estar vacio.");
                } else if (Integer.parseInt(txtDuracionPelicula.getText()) == 0) {
                    datosCorrectos = false;
                    JOptionPane.showMessageDialog(null, "La duración de la pelicula no puede ser 0, ni estar el campo vacio");
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
                } else if (!rbtnCd.isSelected() || !rbtnDVD.isSelected() || !rbtnBlueray.isSelected() || !rbtnArchivo.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Debes seleccionar un formato");
                    datosCorrectos = false;
                }

                if (datosCorrectos) {
                    pelicula = new Pelicula(tituloPelicula, autorPelicula, formato, anioPelicula, duracionPelicula, actrizPrincipal, actorPrincipal, genero);
                    GestionMultimedia.multimedias.add(pelicula);
                    GestionBasesDatos.insertPelicula(pelicula.getTitulo(), pelicula.getAutor(), pelicula.getFormato(), pelicula.getGenero(), pelicula.getAnio(), pelicula.getDuracionPelicula(), pelicula.getActorPrincipal(), pelicula.getActrizPrincipal());
                    JOptionPane.showMessageDialog(null, "Se ha añadido una nueva pelicula");
                    GestionLogs.escribirRegistro(GestionLogs.registroAltaPelicula(pelicula.getTitulo()));
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void valoresCBAnio() {
        for (int i = ANIO_ACTUAL; i >= ANIO_PRIMERA_PELICULA; i-- ) {
            cbAnioPelicula.addItem(i);
        }
    }


}
