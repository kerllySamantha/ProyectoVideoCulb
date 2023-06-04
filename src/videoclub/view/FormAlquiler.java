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
    private JTextField txtNifSocio;
    private ButtonGroup grup = new ButtonGroup();

    private final ArrayList<Multimedia> filtroMultimedias = new ArrayList<>();
    DefaultListModel<String> model = new DefaultListModel<>();
    private boolean existeNif;


    public FormAlquiler() {
        super.setContentPane(panelAlquiler);
        super.setLocationRelativeTo(null);
        super.setJMenuBar(MenuBar.crearMenuBar());
        MenuBar.gestionDeVentanas();
        grup.add(DVDRadioButton);
        grup.add(CDRadioButton);
        grup.add(BLUERAYRadioButton);
        grup.add(ARCHIVORadioButton);


        btnAlquilar.addActionListener(e -> {
            ArrayList<Socio> alquilerSocio = GestionSocioVideoClub.socios;
            ArrayList<Multimedia> alquilerMultimedia = GestionMultimedia.multimedias;
            String nifSocio = txtNifSocio.getText().toUpperCase();
            GestionSocioVideoClub.buscarSocio(nifSocio, alquilerSocio);
            String tituloSeleccionado = listarAlquiler.getSelectedValue();
            Multimedia multimediaAlquilada;
            if (GestionSocioVideoClub.comprobarNif(GestionSocioVideoClub.socios, nifSocio)) {
                for (Multimedia multimedia : alquilerMultimedia) {
                    if (multimedia.getTitulo().equalsIgnoreCase(tituloSeleccionado)) {
                        multimediaAlquilada = multimedia;
                        if (GestionBasesDatos.comprobarDisponibilidad(multimediaAlquilada.getTitulo(), multimediaAlquilada.getClass().getName().substring(6).toLowerCase())) {
                            for (Socio socio : GestionSocioVideoClub.socios) {
                                if (socio.getNif().equalsIgnoreCase(nifSocio)) {
                                    GestionSocioVideoClub.alquilarMultimedia(multimediaAlquilada, socio);

                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "No quedan ejemplares disponibles");
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "No existe ningun Socio con ese nif");
            }
        });
        btnBuscar.addActionListener(e -> {

            Set<String> titulos = filtroMultimedia();
            for (String titulo : titulos) {
                model.addElement(titulo);
                listarAlquiler.setModel(model);
            }
        });
        grup.clearSelection();
    }

    public ArrayList<Multimedia> filtroAlquiler() {
        for (Multimedia multimedia : GestionMultimedia.multimedias) {
            switch (cmbTipoMultimedia.getSelectedIndex()) {
                case 0 -> {
                }
                case 1 -> {
                    if (multimedia instanceof Disco) {
                        filtroMultimedias.add(multimedia);
                    }
                }
                case 2 -> {
                    if (multimedia instanceof Pelicula) {
                        filtroMultimedias.add(multimedia);
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
        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "No se han encontrado multimedias con esas caracteristicas");
        }
        model.clear();
        return titulosMultimediaSet;
    }
}

