package view;

import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private JRadioButton playRadioButton;
    private JRadioButton XBoxRadioButton;
    private JRadioButton nintendoRadioButton;
    private JRadioButton PCRadioButton;
    private JTextArea visualizarDatos;
    Videojuego juego;

    public FormVideoJuego() {
        super.setContentPane(panelPrincipalVideoJuego);
        super.setLocationRelativeTo(null);
        super.setJMenuBar(MenuBar.crearMenuBar());
        MenuBar.gestionDeVentanas();
        altaVideoJuego();
    }
    public void altaVideoJuego(){
        btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String tituloVideoJuego = textTitulo.getText().toUpperCase();
                    String autorVideoJuego = textAutor.getText().toUpperCase();
                    int anioVideoJuego = 0;
                    Formato formato = null;
                    Plataforma plataforma = null;
                    boolean datos = true;

                    if (textTitulo.getText().equals("") && textAnio.getText().equals("")){
                        datos = false;
                        JOptionPane.showMessageDialog(null,"Los campos Titulo y Autor están vacíos.");
                    } else if (textTitulo.getText().equals("")) {
                        datos = false;
                        JOptionPane.showMessageDialog(null,"El campo título está vacío.");
                    } else if (textAutor.getText().equals("")) {
                        datos = false;
                        JOptionPane.showMessageDialog(null,"El campo autor está vacío.");
                    } else {
                        anioVideoJuego=Integer.parseInt(comboBox1.getSelectedItem().toString());
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

                    if (playRadioButton.isSelected()) {
                        plataforma = Plataforma.PlayStation5;
                    } else if (XBoxRadioButton.isSelected()) {
                        plataforma = Plataforma.XBox;
                    } else if (nintendoRadioButton.isSelected()) {
                        plataforma = Plataforma.NintendoSwitch;
                    } else if (PCRadioButton.isSelected()) {
                        plataforma = Plataforma.PC;
                    }

                    if (datos) {
                        juego = new Videojuego(tituloVideoJuego,autorVideoJuego,formato,anioVideoJuego,plataforma);
                        visualizarDatos.setText(juego.toString());
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
    }
}