package view;

import controller.*;
import model.Socio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class FormAltaSocio extends JFrame {
    ArrayList<Socio> socios = new ArrayList<>();

    private JPanel altasSocioMenu;
    private JTextField txtNIFSocioAlta;
    private JTextField txtNombreSocioAlta;
    private JTextField txtPoblacionSocioAlta;
    private JButton btnCrearSocio;
    private JLabel nifSocioALta;
    private JLabel nombreSocioAlta;
    private JLabel fechaNacSocioAlta;
    private JLabel poblacionSocioAlta;
    private JTextArea txtDatosSocio;
    private JButton btnRestValues;

    private String nifSocio, nombreSocio, poblacionSocio;
    private boolean existeNif;
    Socio socio;

    public FormAltaSocio() {
        super.setContentPane(altasSocioMenu);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setJMenuBar(MenuBar.crearMenuBar());
        btnCrearSocio.addActionListener(actionEvent -> {
            //do {
            nifSocio = txtNIFSocioAlta.getText().toUpperCase();
            existeNif = GestionSocioVideoClub.comprobarNif(socios, nifSocio);
            if (existeNif) {
                JOptionPane.showMessageDialog(null, "El NIf ya existe");
            }
            // } while (existeNif);
            nombreSocio = txtNombreSocioAlta.getText().toUpperCase();
            poblacionSocio = txtPoblacionSocioAlta.getText().toUpperCase();

            this.socio = new Socio(nifSocio, nombreSocio, "", poblacionSocio);

            txtDatosSocio.setText(socio.toString());
            txtNIFSocioAlta.setText("");
            txtNombreSocioAlta.setText("");

            socios.add(socio);


        });
        btnRestValues.addActionListener(e -> {
            txtNombreSocioAlta.setText("");
            txtNIFSocioAlta.setText("");
            txtNombreSocioAlta.setText("");
            txtPoblacionSocioAlta.setText("");
        });
    }

}
