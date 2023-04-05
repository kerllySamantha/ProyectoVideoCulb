<<<<<<< HEAD
package view;

=======
>>>>>>> origin/main
import javax.swing.*;

public class FormVideoJuego extends JFrame {
    private JPanel panelPrincipalVideo;
    private JLabel lblTitulo;
    private JLabel lblAutor;
    private JLabel lblFormato;
    private JLabel lblAño;
    private JLabel lblPlataforma;
    private JRadioButton CDRadioButton;
    private JRadioButton DVDRadioButton;
    private JRadioButton BLURAYRadioButton;
    private JRadioButton ARCHIVORadioButton;
    private JPanel panelPrincipalVideoJuego;
    private JTextField textTitulo;
    private JTextField textAutor;
    private JTextField textAño;
    private JTextField textPlataforma;
    private JButton btnCrear;

    public FormVideoJuego() {
        setContentPane(panelPrincipalVideoJuego);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

<<<<<<< HEAD
//    public static void main(String[] args) {
//        JFrame frame = new FormVideoJuego();
//        frame.setVisible(true);
//        frame.setTitle("Altas VideoJuego");
//        frame.setBounds(200, 200, 500, 200);
//    }
=======
    public static void main(String[] args) {
        JFrame frame = new FormVideoJuego();
        frame.setVisible(true);
        frame.setTitle("Altas VideoJuego");
        frame.setBounds(200, 200, 500, 200);
    }
>>>>>>> origin/main
}
