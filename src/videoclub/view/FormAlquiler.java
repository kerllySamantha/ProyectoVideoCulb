package view;

import controller.GestionMultimedia;
import controller.GestionSocioVideoClub;
import model.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class FormAlquiler extends JFrame {
    private JPanel panelAlquiler;
    private JComboBox<String> cmbTipoMultimedia;
    private JRadioButton DVDRadioButton;
    private JRadioButton CDRadioButton;
    private JRadioButton ARCHIVORadioButton;
    private JRadioButton BLUERAYRadioButton;
    private JTextField textBuscar;
    private JButton btnBuscar;
    private JButton btnAlquilar;
    private JList<String> listarAlquiler;
    private JLabel lblNIF;
    private JLabel lblBuscar;
    private JComboBox<String> cmbNif;
    private final ArrayList<Multimedia> filtroMultimedias = new ArrayList<>();


    public FormAlquiler() {
        ButtonGroup grup = new ButtonGroup();
        super.setContentPane(panelAlquiler);
        super.setLocationRelativeTo(null);
        super.setJMenuBar(MenuBar.crearMenuBar());
        MenuBar.gestionDeVentanas();
        grup.add(DVDRadioButton);
        grup.add(CDRadioButton);
        grup.add(BLUERAYRadioButton);
        grup.add(ARCHIVORadioButton);

        btnAlquilar.addActionListener(e -> JOptionPane.showMessageDialog(null, "Quiere alquilar-lo?", "Alerta!", JOptionPane.YES_NO_OPTION));
        btnBuscar.addActionListener(e -> {
            Set<String> titulos = filtroMultimedia();
            DefaultListModel<String> model = new DefaultListModel<>();
            for (String titulo : titulos) {
                model.addElement(titulo);
            }

            listarAlquiler.setModel(model);


        });
    }

    public void rellenarNif() {
        for (Socio socio : GestionSocioVideoClub.socios) {
            cmbNif.addItem(socio.getNif());
        }
    }

    public ArrayList<Multimedia> filtroAlquiler() {
        for (Multimedia multimedia : GestionMultimedia.multimedias) {
            switch (cmbTipoMultimedia.getSelectedIndex()) {
                case 0 -> {
                    if (multimedia instanceof Disco) {
                        filtroMultimedias.add(multimedia);
                    }
                }
                case 1 -> {
                    if (multimedia instanceof Pelicula) {
                        filtroMultimedias.add(multimedia);
                    }
                }
                case 2 -> {
                    if (multimedia instanceof Videojuego) {
                        filtroMultimedias.add(multimedia);
                    }
                }
            }

        }
        return filtroMultimedias;
    }

    public Set<String> filtroMultimedia() {
        ArrayList<Multimedia> nuevo_filtro = filtroAlquiler();
        Set<String> titulosMultimedia = new HashSet<>();

        for (Multimedia multimedia : nuevo_filtro) {
            System.out.println(multimedia.getTitulo());

            if (CDRadioButton.isSelected() && multimedia.getFormato() == Formato.CD) {
                if (textBuscar.getText().equalsIgnoreCase(multimedia.getTitulo()) || textBuscar.getText().isEmpty()) {
                    titulosMultimedia.add(multimedia.getTitulo());
                }
            } else if (DVDRadioButton.isSelected() && multimedia.getFormato() == Formato.DVD) {
                if (textBuscar.getText().equalsIgnoreCase(multimedia.getTitulo())) {
                    titulosMultimedia.add(multimedia.getTitulo());
                }
            } else if (ARCHIVORadioButton.isSelected() && multimedia.getFormato() == Formato.ARCHIVO) {
                if (textBuscar.getText().equalsIgnoreCase(multimedia.getTitulo()) || textBuscar.getText().isEmpty()) {
                    titulosMultimedia.add(multimedia.getTitulo());
                }
            } else if (BLUERAYRadioButton.isSelected() && multimedia.getFormato() == Formato.BLUERAY) {
                if (textBuscar.getText().contains(multimedia.getTitulo()) || textBuscar.getText().isEmpty()) {
                    titulosMultimedia.add(multimedia.getTitulo());
                }
            } else {
                titulosMultimedia.add(multimedia.getTitulo());
                System.out.println(titulosMultimedia);
            }
        }

        return titulosMultimedia;
    }


}

