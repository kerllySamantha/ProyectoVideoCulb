package view;

import controller.*;
import model.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormListadosMultimedia extends JFrame {
    private JPanel panel;
    public static JTextArea txtListaMultimedia;
    private JTextField txtNif;
    private JButton btnListaMult, btnListaPeliculas, btnListaVideojuego, btnListaDisco, btnListaAlquileres, btnListaRecargos, btnBuscarNif;


    public FormListadosMultimedia() {
        this.setTitle("");
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setSize(450, 500);
        this.setResizable(false);
        super.setJMenuBar(MenuBar.crearMenuBar());
        MenuBar.gestionDeVentanas();

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

        MenuBar.listMultimedia.addActionListener(e ->
                {    txtListaMultimedia.setText(GestionMultimedia.ordenarDiscos());
                    //txtListaMultimedia.setText(GestionMultimedia.ordenarDiscos());
                    //txtListaMultimedia.setText(String.valueOf((GestionBasesDatos.aniadirCancionArrayDisco())));
                }
        );


        btnListaPeliculas.addActionListener(e ->
                {
                   // txtListaMultimedia.setText(GestionMultimedia.ordenarPeliculas());
                    //txtListaMultimedia.setText((GestionMultimedia.multimedias).toString());
                    //txtListaMultimedia.setText(String.valueOf((GestionBasesDatos.aniadirCancionArrayDisco()).toString()));
                }
        );

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

        btnListaRecargos.addActionListener(e -> {
            txtListaMultimedia.setText(GestionSocioVideoClub.listaSociosRecargos());
        });
    }

//    public static void main(String[] args) {
//        FormListadosMultimedia formListadosMultimedia = new FormListadosMultimedia();
//        formListadosMultimedia .setVisible(true);
//
//    }
}
