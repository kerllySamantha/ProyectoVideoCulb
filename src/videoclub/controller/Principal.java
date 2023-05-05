package controller;

import view.*;
import model.*;

import javax.swing.*;
import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {

        SwingUtilities.invokeLater((() -> {
            try {
                FormPrincipalVideoClub formPrincipalVideoClub = new FormPrincipalVideoClub();
                formPrincipalVideoClub.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                formPrincipalVideoClub.setSize(400, 400);
                formPrincipalVideoClub.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }));
    }
}







