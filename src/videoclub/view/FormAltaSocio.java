package view;

import controller.*;
import model.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Objects;


public class FormAltaSocio extends JFrame {


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
    private JComboBox<String> cmbProvincias;

    private String nifSocio, nombreSocio, poblacionSocio;
    private boolean existeNif;
    Socio socio;

    public FormAltaSocio() {
        super.setContentPane(altasSocioMenu);
        super.setJMenuBar(MenuBar.crearMenuBar());
        MenuBar.gestionDeVentanas();
        txtDatosSocio.setEditable(false);

        btnCrearSocio.addActionListener(actionEvent -> {
            try {
                //do {
                nifSocio = txtNIFSocioAlta.getText().toUpperCase();
                existeNif = GestionSocioVideoClub.comprobarNif(GestionSocioVideoClub.socios, nifSocio);
                nombreSocio = txtNombreSocioAlta.getText().toUpperCase();
                poblacionSocio = Objects.requireNonNull(cmbProvincias.getSelectedItem()).toString();
                if (existeNif) {
                    txtDatosSocio.setText("");
                    JOptionPane.showMessageDialog(null, "El NIf ya existe");

                // } while (existeNif);
                //poblacionSocio = txtPoblacionSocioAlta.getText().toUpperCase();
            }
                else if ((nombreSocio.equalsIgnoreCase("") && nifSocio.equalsIgnoreCase(""))) {
                    JOptionPane.showMessageDialog(null, "No puedes dejar los campos vacios ");
                    //socios.remove(this.socio);
                    txtDatosSocio.setText("");

                } else if (nifSocio.equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(null, "No puedes dejar el Nif vacio");
                    // socios.remove(this.socio);
                    txtDatosSocio.setText("");

                } else if (nombreSocio.equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(null, "No puedes dejar el nombre vacio");
                    //socios.remove(this.socio);
                    txtDatosSocio.setText("");

                }
                else {
                    socio = new Socio(nifSocio, nombreSocio, "", poblacionSocio);
                    GestionSocioVideoClub.socios.add(socio);
                    JOptionPane.showMessageDialog(null, "Se ha añadido un nuevo Socio");
                    txtDatosSocio.setText(socio.toString());
                }
                txtNIFSocioAlta.setText("");
                txtNombreSocioAlta.setText("");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        btnRestValues.addActionListener(e -> {
            txtNombreSocioAlta.setText("");
            txtNIFSocioAlta.setText("");
            txtNombreSocioAlta.setText("");
            //txtPoblacionSocioAlta.setText("");
            cmbProvincias.setSelectedIndex(0);
            txtDatosSocio.setText("");
        });
    }


}
