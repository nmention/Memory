package model;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import static model.Carte.creerImagesDispo;



public class Model {
    final int LIGNE_TAB = 4;
    final int COLONNE_TAB = 4;
    ImageIcon iconJFrame;
    ArrayList<Carte> tabCartes;
    ArrayList<String> pics;
    int nbrEssais;
    double tempsFinal;
    boolean etatPartie;
    double[] meilleursScores;

    public ImageIcon getIconJFrame() {
        return iconJFrame;
    }






    public ArrayList<Carte> getTabCartes() {
        return tabCartes;
    }

    public void setTabCartes(ArrayList<Carte> tabCartes) {
        this.tabCartes = tabCartes;
    }

    public int getNbrEssais() {
        return nbrEssais;
    }

    public void setNbrEssais(int nbrEssais) {
        this.nbrEssais = nbrEssais;
    }

    public Model() {

        Carte.pics();
        creerImagesDispo();


        iconJFrame = new ImageIcon("src/view/images/dos.jpg");
        tabCartes = new ArrayList<>();
        for (int i = 0; i < 16; i ++){
            Carte carte = new Carte();
            tabCartes.add(carte);
        }
        this.randomImages();

        nbrEssais = 50;





    }
    public ImageIcon redimensionnerIcon(ImageIcon imageIcon, int width, int height){
        ImageIcon icon;
        Image image = imageIcon.getImage();
        Image imageRedimensionne = image.getScaledInstance(width,height,Image.SCALE_SMOOTH);
        icon = new ImageIcon(imageRedimensionne);
        return icon;


    }
    // Mélange les cartes au sein de l'ArrayList de Carte
    public void randomImages() {
        Collections.shuffle(tabCartes);
    }
    // Permet d'obtenir le nombre de cartes qui ont été crées
    public int getNbrCartes() {
        int nbrCarte = 0;
        for (Carte c : this.tabCartes) {
            nbrCarte ++;
        }
        return  nbrCarte;
    }

}
