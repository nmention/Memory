package model;
import model.Model;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

// Création de la classe Carte qui contient les images de face et de dos
public class Carte {
    ImageIcon dos;
    ImageIcon face;
    int index_largeur;
    int index_hauteur;
    String pathname;
    int largeur;
    int hauteur;
    static ArrayList<ImageIcon> imagesDisponibles;
    static ArrayList<String> pics;


    public String getPathname() {
        return pathname;
    }

    public void setPathname(String pathname) {
        this.pathname = pathname;
    }



    public void setIndex_hauteur(int index_hauteur) {
        this.index_hauteur = index_hauteur;
    }

    public void setIndex_largeur(int index_largeur) {
        this.index_largeur = index_largeur;
    }

    public int getIndex_hauteur() {
        return index_hauteur;
    }

    public int getIndex_largeur() {
        return index_largeur;
    }







    public ImageIcon getFace() {
        return face;
    }

    public ImageIcon getDos() {
        return dos;
    }

    // Constructeur de Carte
    public Carte() {
        dos = new ImageIcon();
        face = new ImageIcon();

        largeur = 150;
        hauteur = 200;
        pathname = pics.get(0);
        pics.remove(0);
        face = imagesDisponibles.get(0);
        imagesDisponibles.remove(0);
        dos = importImage("src/view/images/dos.jpg");


    }

    public Carte(Carte carte) {

    }
    // Permet de construire une image
    public ImageIcon importImage(String pics) {
        BufferedImage mypicture = null;
        ImageIcon icon = null;
        try {
            mypicture = ImageIO.read(new File(pics));
        } catch (IOException e) {
            e.printStackTrace();
        }
        icon = new ImageIcon(mypicture);
        icon = redimensionnerIcon(icon,150,200);
        return icon;
    }
    // Ajoute toutes les icônes disponibles pour les faces des cartes dans une ArrayList
    public static void creerImagesDispo() {
        imagesDisponibles = new ArrayList<>();
        for (int i = 0; i < pics.size(); i ++){
            ImageIcon icon = new ImageIcon();
            icon = importImage2(pics.get(i));
            imagesDisponibles.add(icon);
        }
    }

    // Permet de redimensionner l'image qu'on passe en paramètre
    public ImageIcon redimensionnerIcon(ImageIcon imageIcon, int width, int height){
        ImageIcon icon;
        Image image = imageIcon.getImage();
        Image imageRedimensionne = image.getScaledInstance(width,height,Image.SCALE_SMOOTH);
        icon = new ImageIcon(imageRedimensionne);
        return icon;


    }
    // Permet d'ajouter tout les pathname correspondant au face des cartes à l'ArrayLlist
    public static void pics(){
        pics = new ArrayList<>();
        pics.add("src/view/images/hunt.jpeg");
        pics.add("src/view/images/cheryl.jpg");
        pics.add("src/view/images/claudette.png");
        pics.add("src/view/images/meg.png");
        pics.add("src/view/images/legion.jpg");
        pics.add("src/view/images/meg.png");
        pics.add("src/view/images/dwight.png");
        pics.add("src/view/images/ghost.jpg");
        pics.add("src/view/images/legion.jpg");
        pics.add("src/view/images/ghost.jpg");
        pics.add("src/view/images/dwight.png");
        pics.add("src/view/images/pyramide.jpg");
        pics.add("src/view/images/pyramide.jpg");
        pics.add("src/view/images/cheryl.jpg");
        pics.add("src/view/images/claudette.png");
        pics.add("src/view/images/hunt.jpeg");

    }
    //Même méthode mais statique
    public static ImageIcon importImage2(String pics) {
        BufferedImage mypicture = null;
        ImageIcon icon = null;
        try {
            mypicture = ImageIO.read(new File(pics));
        } catch (IOException e) {
            e.printStackTrace();
        }
        icon = new ImageIcon(mypicture);
        icon = redimensionnerIcon2(icon,150,200);
        return icon;
    }
    // Même méthode mais statique
    public static ImageIcon redimensionnerIcon2(ImageIcon imageIcon, int width, int height){
        ImageIcon icon;
        Image image = imageIcon.getImage();
        Image imageRedimensionne = image.getScaledInstance(width,height,Image.SCALE_SMOOTH);
        icon = new ImageIcon(imageRedimensionne);
        return icon;


    }


}
