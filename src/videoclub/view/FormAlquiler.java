package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormAlquiler extends JFrame{
    private JPanel panelAlquiler;
    private JTextField textNIF;
    private JComboBox comboBox1;
    private JRadioButton DVDRadioButton;
    private JRadioButton CDRadioButton;
    private JRadioButton ARCHIVORadioButton;
    private JRadioButton BLUERAYRadioButton;
    private JTextField textBuscar;
    private JButton btnBuscar;
    private JButton btnAlquilar;
    private JList listarAlquiler;
    private JLabel lblNIF;
    private JLabel lblBuscar;

    public FormAlquiler() {
        super.setContentPane(panelAlquiler);
        super.setLocationRelativeTo(null);
        super.setJMenuBar(MenuBar.crearMenuBar());
        MenuBar.gestionDeVentanas();



        btnAlquilar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Quiere alquilar-lo?", "Alerta!", JOptionPane.YES_NO_OPTION);
            }
        });
    }
}
