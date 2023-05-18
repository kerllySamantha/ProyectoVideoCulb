package view;

import controller.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormListadosMultimedia extends JFrame {
    private JPanel panel;
    private JTextArea txtListaMultimedia;
    private JTextField txtNif;
    private JButton btnListaMult, btnListaPeliculas, btnListaVideojuego, btnListaDisco, btnListaAlquileres, btnListaRecargos, btnBuscarNif;



    public FormListadosMultimedia() {
        this.setTitle("");
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setSize(450, 500);
        this.setResizable(false);
        super.setJMenuBar(MenuBar.crearMenuBar());

        panel = new JPanel();
        panel.setBounds(0, 0, 450, 500);
        this.setContentPane(panel);
        panel.setLayout(null);

        txtListaMultimedia = new JTextArea();
        txtListaMultimedia.setBounds(10, 40, 430, 410);
        txtListaMultimedia.setEditable(false);
        txtListaMultimedia.setLineWrap(true);
        txtListaMultimedia.setWrapStyleWord(true);
        panel.add(txtListaMultimedia);

        crearBotones();

        txtNif = new JTextField();

    }

    public void crearBotones() {
        btnListaMult = new JButton("");
        panel.add(btnListaMult);

        btnListaPeliculas = new JButton("");
        panel.add(btnListaPeliculas);

        btnListaDisco = new JButton("");
        panel.add(btnListaDisco);

        btnListaVideojuego = new JButton("");
        panel.add(btnListaVideojuego);

        btnListaAlquileres = new JButton("");
        panel.add(btnListaAlquileres);

        btnListaRecargos = new JButton("");
        panel.add(btnListaRecargos);

        btnListaMult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtListaMultimedia.setText(GestionMultimedia.ordenarMultimedia());
            }
        });

        btnListaPeliculas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtListaMultimedia.setText(GestionMultimedia.ordenarPeliculas());
            }
        });

        btnListaVideojuego.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtListaMultimedia.setText(GestionMultimedia.listaVideojuegos());
            }
        });

        btnListaDisco.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtListaMultimedia.setText("");
            }
        });

        btnListaAlquileres.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtListaMultimedia.setText(GestionSocioVideoClub.listaAlquilerActual(txtNif.getText()));
            }
        });

        btnListaRecargos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtListaMultimedia.setText(GestionSocioVideoClub.listaSociosRecargos());
            }
        });
    }
    public static void main(String[] args) {
        FormListadosMultimedia f = new FormListadosMultimedia();
        f.setVisible(true);
    }
}
