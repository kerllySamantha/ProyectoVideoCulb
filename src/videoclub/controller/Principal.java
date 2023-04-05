package controller;

import view.*;
import model.*;

import javax.swing.*;
import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {

        SwingUtilities.invokeLater((() -> {
            try {
                FormAltaSocio formVideoClub = new FormAltaSocio();
                formVideoClub.setSize(400, 400);
                formVideoClub.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }));
    }
}







