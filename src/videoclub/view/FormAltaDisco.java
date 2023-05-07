package view;

import model.Formato;
import model.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FormAltaDisco extends JFrame{


    private JPanel panelAltaDisco;
    private JLabel lblTitulo;
    private JLabel lblAutor;
    private JLabel lblFormato;
    private JButton btnAniadirCanciones;
    private JTextField txtTituloDisco;
    private JTextField txtAutorDisco;
    private JTextField txtAnioDisco;
    private JRadioButton rbCD;
    private JRadioButton rbBlueRay;
    private JRadioButton rbArchivo;
    private JRadioButton rbDvd;
    private JButton btnAltaDisco;
    private JTextArea txtResumenAlta;
    private ButtonGroup grupoFormato;
    static Disco disco;


    public FormAltaDisco() {
        super.setContentPane(panelAltaDisco);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setLocationRelativeTo(null);
        super.setVisible(true);
        super.setJMenuBar(MenuBar.crearMenuBar());
        altaDisco();
        mostrarDatos();
    }
    public void altaDisco() {
        btnAniadirCanciones.addActionListener(actionEvent -> {
            try {
                String tituloDisco = "";
                String autorDisco = "";
                int anioDisco = 0;
                Formato formato = null;
                boolean datosCorrectos = true;

                if (!txtTituloDisco.getText().equals("")) {
                    tituloDisco = txtTituloDisco.getText().toUpperCase();
                } else {
                    datosCorrectos = false;
                }
                if (!txtAutorDisco.getText().equals("")) {
                    autorDisco = txtAutorDisco.getText().toUpperCase();
                } else {
                    datosCorrectos = false;
                }
                if (Integer.parseInt(txtAnioDisco.getText()) >= 1895) {
                    anioDisco = Integer.parseInt(txtAnioDisco.getText());
                } else {
                    datosCorrectos = false;
                }


                if (rbArchivo.isSelected()) {
                    formato = Formato.ARCHIVO;
                } else if (rbBlueRay.isSelected()) {
                    formato = Formato.BLURAY;
                } else if (rbCD.isSelected()) {
                    formato = Formato.CD;
                } else if (rbDvd.isSelected()) {
                    formato = Formato.DVD;
                }


                if (datosCorrectos) {
                    disco = new Disco(tituloDisco, autorDisco, formato, anioDisco);
                    FormAniadirCanciones canciones = new FormAniadirCanciones();
                    canciones.setVisible(true);
                    canciones.setSize(400,400);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        });
    }
    public static void recibirCanciones(ArrayList<Cancion>canciones) {
        disco.setCanciones(canciones);
    }

    public void mostrarDatos() {
        btnAltaDisco.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtResumenAlta.setText(disco.toString());
                limpiarCampos();
            }
        });
    }

    public void limpiarCampos() {
        txtAnioDisco.setText("");
        txtAutorDisco.setText("");
        txtTituloDisco.setText("");
        grupoFormato.clearSelection();
    }

    public static void main(String[] args) {
        FormAltaDisco d = new FormAltaDisco();
        d.setSize(500,500);
    }
}
