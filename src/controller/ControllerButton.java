package controller;

import model.Model;
import model.Score;
import view.Fenetre;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ControllerButton {
    ActionListener buttonListener;
    Fenetre fen;
    Model model;
    static ButtonImage temp;
    static int nbcartesRetournes;
    static  ButtonImage temp2;
    int nbrEssais;
    int totalCarteRetourne;


    public ControllerButton(Model model, Fenetre fen) {
        this.model = model;
        this.fen = fen;
        temp = null;
        temp2 = null;
        fen.essais.setText("Essais restants: " + model.getNbrEssais());

        nbcartesRetournes = 0;
        totalCarteRetourne = 0;

        buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!fen.chrono.isDemarre()) {
                    fen.chrono.start();
                }
                ButtonImage button = (ButtonImage) e.getSource();
                if (model.getNbrEssais() > 0) {
                    if (nbcartesRetournes == 0 || nbcartesRetournes == 1) {
                        button.setIcon(model.getTabCartes().get(button.getIndex()).getFace());
                        button.setEnabled(false);
                        button.setDisabledIcon(model.getTabCartes().get(button.getIndex()).getFace());

                    }


                    if (nbcartesRetournes == 2) {
                        button.setIcon(model.getTabCartes().get(button.getIndex()).getDos());
                        nbcartesRetournes = 0;


                        if (model.getTabCartes().get(temp.getIndex()).getPathname() != model.getTabCartes().get(temp2.getIndex()).getPathname()) {
                            temp2.setIcon(model.getTabCartes().get(temp2.getIndex()).getDos());
                            temp.setIcon(model.getTabCartes().get(temp.getIndex()).getDos());
                            totalCarteRetourne += -2;
                            temp.setEnabled(true);
                            temp2.setEnabled(true);

                            model.setNbrEssais(model.getNbrEssais() - 1);
                            fen.essais.setText("Essais restants : " + model.getNbrEssais());



                        }
                        button.setIcon(model.getTabCartes().get(button.getIndex()).getFace());
                        button.setEnabled(false);
                        button.setDisabledIcon(model.getTabCartes().get(button.getIndex()).getFace());
                    }

                    //temp = button;

                    if (nbcartesRetournes == 0) {
                        temp = button;

                    }
                    if (nbcartesRetournes == 1) {
                        temp2 = button;

                    }
                    nbcartesRetournes++;
                    totalCarteRetourne ++;



                    //temp = button;

                }
                if (model.getNbrEssais() == 0 ) {
                    fen.gameOver();

                }
                if (model.getNbrCartes()   == totalCarteRetourne) {
                    fen.chrono.terminate();
                    fen.victoire();



                }
            }
        };
    }

    public ActionListener getButtonListener() {
        return buttonListener;
    }
}
