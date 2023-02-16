package controller;

import model.Model;
import view.Fenetre;

public class ControlGroup {
    Model model;
    Fenetre fen;
    ControllerButton controllerButton;
    ControlMenu controlMenu;

    public Fenetre getFen() {
        return fen;
    }

    public void setFen(Fenetre fen) {
        this.fen = fen;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public ControlMenu getControlMenu() {
        return controlMenu;
    }

    public void setControlMenu(ControlMenu controlMenu) {
        this.controlMenu = controlMenu;
    }

    public ControllerButton getControllerButton() {
        return controllerButton;
    }

    public void setControllerButton(ControllerButton controllerButton) {
        this.controllerButton = controllerButton;
    }
    // Créer la Fenêtre, le controllerButton et le controllerMenu
    public ControlGroup(Model model) {
        this.model = model;
        fen = new Fenetre(model);
        controllerButton = new ControllerButton(model,fen);
        controlMenu = new ControlMenu(model, fen);

    }
}
