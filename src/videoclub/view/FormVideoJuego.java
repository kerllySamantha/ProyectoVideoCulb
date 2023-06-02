package view;

import controller.GestionBasesDatos;
import controller.GestionLogs;
import controller.GestionMultimedia;
import model.*;

import javax.swing.*;
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

    public void altaVideoJuego() {
        btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String tituloVideoJuego = textTitulo.getText().toUpperCase();
                    String autorVideoJuego = textAutor.getText().toUpperCase();
                    int anioVideoJuego = Integer.parseInt(Objects.requireNonNull(comboBox1.getSelectedItem()).toString());
                    Formato formato = null;
                    Plataforma plataforma = null;
                    boolean datos = true;

                    if (textTitulo.getText().equals("") && textAutor.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Los campos Titulo y Autor están vacíos.");
                        datos = false;
                    } else if (textTitulo.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "El campo título está vacío.");
                        datos = false;
                    } else if (textAutor.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "El campo autor está vacío.");
                        datos = false;
                    }
                    if (CDRadioButton.isSelected()) {
                        formato = Formato.CD;
                    } else if (DVDRadioButton.isSelected()) {
                        formato = Formato.DVD;
                    } else if (BLURAYRadioButton.isSelected()) {
                        formato = Formato.BLUERAY;
                    } else if (ARCHIVORadioButton.isSelected()) {
                        formato = Formato.ARCHIVO;
                    } else if (!CDRadioButton.isSelected() || !DVDRadioButton.isSelected() || !BLURAYRadioButton.isSelected() || !ARCHIVORadioButton.isSelected()) {
                        JOptionPane.showMessageDialog(null, "Debes seleccionar un formato");
                        datos = false;
                    }
                    if (playRadioButton.isSelected()) {
                        plataforma = Plataforma.PLAYSTATION5;
                    } else if (XBoxRadioButton.isSelected()) {
                        plataforma = Plataforma.XBOX;
                    } else if (nintendoRadioButton.isSelected()) {
                        plataforma = Plataforma.NINTENDOSWITCH;
                    } else if (PCRadioButton.isSelected()) {
                        plataforma = Plataforma.PC;
                    } else if (!playRadioButton.isSelected() || !XBoxRadioButton.isSelected() || !nintendoRadioButton.isSelected() || !PCRadioButton.isSelected()) {
                        JOptionPane.showMessageDialog(null, "Debes seleccionar una plataforma");
                        datos = false;
                    }
                    if (datos) {

                        juego = new Videojuego(tituloVideoJuego, autorVideoJuego, formato, anioVideoJuego, plataforma);
                        visualizarDatos.setText(juego.toString());
                        GestionMultimedia.multimedias.add(juego);
                        GestionBasesDatos.insertViedeojuego(juego.getTitulo(), juego.getAutor(), juego.getFormato(), juego.getAnio(), juego.getPlataforma());
                        GestionLogs.escribirRegistro(GestionLogs.registroAltaVideojuego(juego.getTitulo()));
                        JOptionPane.showMessageDialog(null, "Se ha añadido un nuevo videojuego");
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
    }
}
