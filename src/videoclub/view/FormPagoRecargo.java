package view;

import controller.GestionSocioVideoClub;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormPagoRecargo extends JFrame{

    private JPanel panelPagos;
    private JLabel lblNif;
    private JTextField txtNif;
    private JTextArea txtDatosSocio;
    private JButton btnPagar;
    private JButton btnBuscar;

    public FormPagoRecargo() {
        super.setContentPane(panelPagos);
        super.setLocationRelativeTo(null);
        super.setJMenuBar(MenuBar.crearMenuBar());
        MenuBar.gestionDeVentanas();

        funcionalidadBotones();

    }

    public void funcionalidadBotones() {
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (GestionSocioVideoClub.comprobarNif(GestionSocioVideoClub.socios, txtNif.getText())) {
                    int index = GestionSocioVideoClub.buscarSocio(txtNif.getText(), GestionSocioVideoClub.socios);
                    txtDatosSocio.setText(GestionSocioVideoClub.socios.get(index).toString());
                } else {
                    JOptionPane.showMessageDialog(null, "NIF no encontrado");
                }
            }
        });

        btnPagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (GestionSocioVideoClub.comprobarNif(GestionSocioVideoClub.socios, txtNif.getText())) {
                    GestionSocioVideoClub.pagarRecargo(txtNif.getText());
                }
            }
        });
    }
}
