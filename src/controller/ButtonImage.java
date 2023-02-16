package controller;

import javax.swing.*;
// classe qui permet d'identifier la carte selectionné grâce à l'index
public class ButtonImage extends JButton {
    int index;


    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public ButtonImage(Icon icon, int index) {
        super(icon);
        this.index = index;

    }
}
