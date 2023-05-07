package view;

import model.Formato;

import javax.swing.*;
import java.util.Objects;

public class FormVideoJuego extends JFrame {

    private JPanel panelPrincipalVideo;
    private JLabel lblTitulo;
    private JLabel lblAutor;
    private JLabel lblFormato;
    private JLabel lblAnio;
    private JLabel lblPlataforma;
    private JRadioButton CDRadioButton;
    private JRadioButton DVDRadioButton;
    private JRadioButton BLURAYRadioButton;
    private JRadioButton ARCHIVORadioButton;
    private JPanel panelPrincipalVideoJuego;
    private JTextField textTitulo;
    private JTextField textAutor;
    private JTextField textAnio;
    private JTextField textPlataforma;
    private JButton btnCrear;
    private JComboBox<Integer> comboBox1;

    public FormVideoJuego() {
        super.setContentPane(panelPrincipalVideoJuego);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLocationRelativeTo(null);
        super.setJMenuBar(MenuBar.crearMenuBar());
        MenuBar.gestionDeVentanas();
    }
    public void altaVideoJuego(){
        try {
            String titulo = "";
            String autor = "";
            int anio = 0;
            Formato formato = null;
            String plataforma = "";
            boolean datos = true;

            if (!textTitulo.getText().equals("")) {
                titulo = textTitulo.getText().toUpperCase();
            } else {
                datos = false;
            }
            if (!textAutor.getText().equals("")) {
                autor = textAutor.getText().toUpperCase();
            } else {
                datos = false;
            }
            if (!Objects.equals(comboBox1.getSelectedItem(), 0)) {
                datos = false;
            } else {
                anio = Integer.parseInt(String.valueOf(comboBox1.getSelectedIndex()));
            }
            if (!textPlataforma.getText().equals("")) {
                plataforma = textPlataforma.getText().toUpperCase();
            } else {
                datos = false;
            }


            if (CDRadioButton.isSelected()) {
                formato = Formato.CD;
            } else if (DVDRadioButton.isSelected()) {
                formato = Formato.DVD;
            } else if (BLURAYRadioButton.isSelected()) {
                formato = Formato.BLURAY;
            } else if (ARCHIVORadioButton.isSelected()) {
                formato = Formato.ARCHIVO;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
}
