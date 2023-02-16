package controller;

import model.Model;
import view.Fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlMenu {
    Model model;
    Fenetre fen;
    ActionListener menuListener;
    public ControlMenu(Model model, Fenetre fen){
        this.model = model;
        this.fen = fen;
        menuListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == fen.restart) {
                    fen.dispose();
                    //Model model = new Model();
                    Model model = new Model();
                    ControlGroup controller = new ControlGroup(model);
                }
                if(e.getSource() == fen.scores) {
                    fen.highScore();
                }
            }
        };
    }

    public ActionListener getMenuListener() {
        return menuListener;
    }
}
