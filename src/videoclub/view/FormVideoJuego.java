package view;

import model.Formato;
import model.Multimedia;
import model.Plataforma;
import model.Videojuego;

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
    private String tituloVideoJuego,autorVideoJuego;
    private int anioVideoJuego;
    private boolean validar;
    Videojuego juego, plataformaVideoJuego;


    public FormVideoJuego() {
        super.setContentPane(panelPrincipalVideoJuego);
        super.setLocationRelativeTo(null);
        super.setJMenuBar(MenuBar.crearMenuBar());
        MenuBar.gestionDeVentanas();
        btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    tituloVideoJuego = textTitulo.getText().toUpperCase();
                    autorVideoJuego = textAutor.getText().toUpperCase();
                    anioVideoJuego = Integer.parseInt(Objects.requireNonNull(comboBox1.getSelectedItem()).toString());

                    if(validar){
                        visualizarDatos.setText(" ");
                        JOptionPane.showMessageDialog(null,"Prueba");
                    } else if ((tituloVideoJuego.equalsIgnoreCase("")) && (autorVideoJuego.equalsIgnoreCase(""))) {
                        JOptionPane.showMessageDialog(null,"El campo titulo y el campo autor están vacíos");
                        visualizarDatos.setText("");
                    } else if (tituloVideoJuego.equalsIgnoreCase("")){
                        JOptionPane.showMessageDialog(null,"El campo título está vacío");
                        visualizarDatos.setText("");
                    } else if (autorVideoJuego.equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(null,"El campo autor está vacío");
                        visualizarDatos.setText("");

                    } else {
                        juego = new Videojuego(tituloVideoJuego,autorVideoJuego,Formato.BLUERAY,anioVideoJuego,Plataforma.PC);
                        visualizarDatos.setText(juego.toString());
                    }

                    textTitulo.setText(" ");
                    textAutor.setText(" ");
                } catch (Exception e2){
                    e2.printStackTrace();
                }
            }
        });
    }
    public void altaVideoJuego(){
        try {
            String titulo = "";
            String autor = "";
            int anio = 0;
            Formato formato = null;
            Plataforma plataforma = null;
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
                plataforma = Plataforma.valueOf(textPlataforma.getText().toUpperCase());
            } else {
                datos = false;
            }


            if (CDRadioButton.isSelected()) {
                formato = Formato.CD;

            } else if (DVDRadioButton.isSelected()) {
                formato = Formato.DVD;
                datos = false;
            } else if (BLURAYRadioButton.isSelected()) {
                formato = Formato.BLUERAY;
                datos = false;
            } else if (ARCHIVORadioButton.isSelected()) {
                formato = Formato.ARCHIVO;
                datos = false;
            }

            if(playRadioButton.isSelected()){
                plataforma = Plataforma.PlayStation5;
            } else if (XBoxRadioButton.isSelected()) {
                plataforma = Plataforma.XBox;
            } else if (nintendoRadioButton.isSelected()) {
                plataforma = Plataforma.NintendoSwitch;
            } else if (PCRadioButton.isSelected()) {
                plataforma=Plataforma.PC;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
}
