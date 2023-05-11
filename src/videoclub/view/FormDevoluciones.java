package view;

import javax.swing.*;

public class FormDevoluciones extends JFrame{

    private JPanel panelDevoluciones;
    private JTextField txtFieldNifSocio;
    private JButton btnComprobarSocio;
    private JLabel lblNifSocio;
    private JList listaDevolver;
    private JButton btnDevolver;

    public FormDevoluciones() {
        super.setContentPane(panelDevoluciones);
        super.setLocationRelativeTo(null);
        super.setJMenuBar(MenuBar.crearMenuBar());
        MenuBar.gestionDeVentanas();
    }

}
