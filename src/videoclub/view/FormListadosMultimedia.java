package view;

import model.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Comparator;

public class FormListadosMultimedia extends JFrame {
    private JPanel panel;
    private JTextArea txtListaMultimedia;


    ArrayList<Multimedia>multimedias = new ArrayList<>();


    public FormListadosMultimedia() {
        multimedias.add(new Pelicula("Madagascar", "DW", Formato.DVD, 2012,120,"a0", "b"));
        this.setTitle("");
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setSize(450, 500);
        this.setResizable(false);
        super.setJMenuBar(MenuBar.crearMenuBar());
        //this.setLocation(100, 100);

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
        //ordenarMultimedia(multimedias);

//        listModel = new DefaultListModel<>();
//        ordenarMultimedia(multimedias);
//        listaMultimedia = new JList<>(listModel);
//        listaMultimedia.setBounds(10,40,450,450);
//        add(new JScrollPane(listaMultimedia));
//        panel.add(listaMultimedia);
    }



    public static void main(String[] args) {
        FormListadosMultimedia f = new FormListadosMultimedia();
        f.setVisible(true);
    }
}
