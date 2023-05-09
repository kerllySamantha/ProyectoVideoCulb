package view;
import model.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FormAniadirCanciones extends JFrame{

    private JPanel panelCancion;
    private JLabel lblTituloCancion;
    private JLabel lblDuracionCancion;
    private JButton btnAniadirCancion;
    private JTextField txtTituloCancion;
    private JTextField txtDuracionCancion;
    private JTextArea txtListaCanciones;
    private JButton btnTerminar;
    private ArrayList<Cancion>canciones = new ArrayList<>();

    public FormAniadirCanciones() {
        super.setContentPane(panelCancion);
        super.setDefaultCloseOperation(HIDE_ON_CLOSE);
        super.setLocationRelativeTo(null);
        txtListaCanciones.setEditable(false);

        aniadirCancion();
        terminar();
    }

    public void aniadirCancion() {
        btnAniadirCancion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean datosCorrectos = true;
                String tituloCancion = "";
                String duracion = "";

                try {
                    if (!txtTituloCancion.getText().equals("")) {
                        tituloCancion = txtTituloCancion.getText().toUpperCase();
                    } else {
                        datosCorrectos = false;
                    }
                    if (!txtDuracionCancion.getText().equals("")) {
                        duracion = txtDuracionCancion.getText();
                    } else {
                        datosCorrectos = false;
                    }
                } catch (Exception exception) {
                    System.out.println(exception);
                }

                if (datosCorrectos) {
                    canciones.add(new Cancion(tituloCancion, duracion));
                    txtListaCanciones.setText(mostrarCanciones());
                    limpiarCampos();
                }
            }
        });
    }

    public void terminar() {
        btnTerminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                view.FormAltaDisco.recibirCanciones(canciones);

            }
        });
    }

    public void limpiarCampos() {
        txtTituloCancion.setText("");
        txtDuracionCancion.setText("");
    }

    public String mostrarCanciones() {
        String listaCaciones = "";
        for (Cancion cancion : canciones) {
            listaCaciones += cancion.getTituloCancion() + " - " + cancion.getDuracionMinSeg() + "\n";
        }
        return listaCaciones;
    }
}
