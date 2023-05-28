package view;

import controller.*;
import model.*;

import javax.swing.*;
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
    DefaultListModel<String> model = new DefaultListModel<>();


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
            for (String titulo : titulos) {
                model.addElement(titulo);
                listarAlquiler.setModel(model);
            }

            DVDRadioButton.setSelected(false);
            ARCHIVORadioButton.setSelected(false);
            BLUERAYRadioButton.setSelected(false);
            CDRadioButton.setSelected(false);
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
                case 0 ->{

                }
                case 1 -> {
                    if (multimedia instanceof Disco) {
                        filtroMultimedias.add(multimedia);

                    }
                }
                case 2 -> {
                    if (multimedia instanceof Pelicula) {
                        filtroMultimedias.add(multimedia);
                        System.out.println(filtroMultimedias);
                    }
                }
                case 3 -> {
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
        Set<String> titulosMultimediaSet = new HashSet<>();
        String tituloBuscar = textBuscar.getText();
        boolean encontrado = false;
        for (Multimedia multimedia : nuevo_filtro) {

            if (CDRadioButton.isSelected() && multimedia.getFormato() == Formato.CD) {
                if (tituloBuscar.isEmpty() || tituloBuscar.equalsIgnoreCase(multimedia.getTitulo())) {
                    titulosMultimediaSet.add(multimedia.getTitulo());
                    encontrado = true;

                }

            } else if (DVDRadioButton.isSelected() && multimedia.getFormato() == Formato.DVD) {
                if (tituloBuscar.equalsIgnoreCase(multimedia.getTitulo()) || tituloBuscar.isEmpty()) {
                    titulosMultimediaSet.add(multimedia.getTitulo());
                    encontrado = true;
                }
            } else if (ARCHIVORadioButton.isSelected() && multimedia.getFormato() == Formato.ARCHIVO) {
                if (tituloBuscar.equalsIgnoreCase(multimedia.getTitulo()) || tituloBuscar.isEmpty()) {
                    titulosMultimediaSet.add(multimedia.getTitulo());
                    encontrado = true;
                }
            } else if (BLUERAYRadioButton.isSelected() && multimedia.getFormato() == Formato.BLUERAY) {
                if (tituloBuscar.contains(multimedia.getTitulo()) || tituloBuscar.isEmpty()) {
                    titulosMultimediaSet.add(multimedia.getTitulo());
                    encontrado = true;
                }
            } else if (!CDRadioButton.isSelected() && !DVDRadioButton.isSelected() && !ARCHIVORadioButton.isSelected() && !BLUERAYRadioButton.isSelected()) {
                titulosMultimediaSet.add(multimedia.getTitulo());
                encontrado = true;
            }
        }
        model.clear();
        return titulosMultimediaSet;
    }
}

