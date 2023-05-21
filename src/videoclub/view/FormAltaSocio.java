package view;

import controller.*;
import model.*;

import javax.swing.*;
import java.time.LocalDate;
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
    private JTextField txtFechaNac;

    private String nifSocio, nombreSocio, poblacionSocio;
    private boolean existeNif;
    Socio socio;

    public FormAltaSocio() {
        super.setContentPane(altasSocioMenu);
        super.setJMenuBar(MenuBar.crearMenuBar());
        MenuBar.gestionDeVentanas();
        txtDatosSocio.setEditable(false);

        aniadirSocio();

        btnRestValues.addActionListener(e -> {
            txtNombreSocioAlta.setText("");
            txtNIFSocioAlta.setText("");
            txtNombreSocioAlta.setText("");
            //txtPoblacionSocioAlta.setText("");
            cmbProvincias.setSelectedIndex(0);
            txtDatosSocio.setText("");
        });
    }

    public void aniadirSocio() {
        String patron = "^(0[1-9]|1[0-9]|2[0-9]|3[01])/(0[1-9]|1[0-2])/(19|20)\\d{2}$";

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

                } else if (!txtFechaNac.getText().matches(patron) || txtFechaNac.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Fecha introducida incorrectamente. Debe ser DD/MM/YYYY");

                } else if (!Socio.calcularEdad(txtFechaNac.getText())) {
                    JOptionPane.showMessageDialog(null, "Debe ser mayor de 18 años para darse de alta");
                }else {
                    socio = new Socio(nifSocio, nombreSocio, convertirADate(), poblacionSocio);
                    GestionSocioVideoClub.socios.add(socio);
                    JOptionPane.showMessageDialog(null, "Se ha añadido un nuevo Socio");
                    txtDatosSocio.setText(socio.toString());
                    txtNIFSocioAlta.setText("");
                    txtNombreSocioAlta.setText("");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public LocalDate convertirADate() {
        String [] partesFecha = txtFechaNac.getText().split("/");
        LocalDate fechaNac = LocalDate.of(Integer.parseInt(partesFecha[2]), Integer.parseInt(partesFecha[1]), Integer.parseInt(partesFecha[0]));
        return fechaNac;
    }


}
