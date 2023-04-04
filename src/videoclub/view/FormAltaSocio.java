package view;

import controller.Principal;
import model.Socio;

import javax.swing.*;
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

    private String nifSocio, nombreSocio, poblacionSocio;
    private boolean existeNif;

    public FormAltaSocio() {
        super.setContentPane(altasSocioMenu);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);

        super.setJMenuBar(MenuBar.crearMenuBar());


        btnCrearSocio.addActionListener(actionEvent -> {
            nifSocio = txtNombreSocioAlta.getText().toUpperCase();
            existeNif = socios.contains(socios);
           // int encontrado = Principal.buscarSocio(nifSocio, ArrayList<Socio> socios);
           do{
               if (existeNif) {
                JOptionPane.showMessageDialog(null, "El NIf ya existe");
            }
        } while (existeNif);

            nombreSocio = txtNombreSocioAlta.getText().toUpperCase();
            poblacionSocio = txtPoblacionSocioAlta.getText().toUpperCase();


            new Socio(nifSocio, nombreSocio, "", poblacionSocio);


        });
    }

}
