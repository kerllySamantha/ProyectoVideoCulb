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
                String tituloCancion = "", autor = null;
                String duracion = "";
                String patron = "^(3[0]|[12]?\\d):([0-5]\\d)$";


                try {
                    if (txtTituloCancion.getText().equals("") && txtDuracionCancion.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "No puedes dejar los campos vacio");
                    } else if (txtTituloCancion.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "No puedes dejar el título vacio");
                    } else if (txtDuracionCancion.getText().equals("") || !txtDuracionCancion.getText().matches(patron)) {
                        JOptionPane.showMessageDialog(null, "Campo vacio o introducido incorrectemente\n Introduce un tiempo en formato mm:ss de máximo 30 minutos");
                    } else {
                        tituloCancion = txtTituloCancion.getText().toUpperCase();
                        duracion = txtDuracionCancion.getText();
                        canciones.add(new Cancion(tituloCancion, duracion,autor));
                        txtListaCanciones.setText(mostrarCanciones());
                        limpiarCampos();

                    }
                } catch (Exception exception) {
                    System.out.println(exception);
                }
            }
        });
    }

    public void terminar() {
        btnTerminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                FormAltaDisco.recibirCanciones(canciones);
                FormAltaDisco.disco.setDuracion(FormAltaDisco.disco.duracionDisco());

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
