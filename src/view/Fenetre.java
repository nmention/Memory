package view;

import controller.ButtonImage;
import controller.ControlMenu;
import controller.ControllerButton;
import model.Carte;
import model.Model;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Fenetre extends JFrame {
    ControllerButton controllerButton;
    ControlMenu controlMenu;
    Model model;
    public Chrono chrono;
    public JPanel global;
    public JMenu jMenu;
    public JPanel bas;
    public JLabel essais;
    public JPanel jPanel;
    public JPanel principal;
    public JPanel jPanel2;
    public JLabel temps;
    public JMenuBar menuBar;
    public JMenu options;
    public JMenu tailleGrille;
    public JMenuItem restart;
    public JMenuItem scores;
    public JMenuItem petiteGrille;
    public JMenuItem grandeGrille;
    public JOptionPane gameOver;

    ButtonImage button;



    public Fenetre(Model model) {
        this.model = model;

        initAttribut();
        creerVue();
        setTitle("Memory");
        setIconImage(model.getIconJFrame().getImage());
        setLocation(300,100);
        pack();
        //setMinimumSize(new Dimension(200,200));
        setSize(600, 800);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    // Initialise tout les éléments graphiques
    public void initAttribut() {

        global = new JPanel(new BorderLayout());
        bas = new JPanel(new GridBagLayout());
        principal = new JPanel( new GridLayout(4,4));
        jPanel = new JPanel(new GridBagLayout());
        temps = new JLabel("Temps :");
        chrono = new Chrono(temps);
        essais = new JLabel("Essais restants :");
        petiteGrille = new JMenuItem("3x3");
        grandeGrille = new JMenuItem("5x5");
        tailleGrille = new JMenu("Taille");
        restart = new JMenuItem("Nouvelle partie");
        scores = new JMenuItem("Meilleures scores");
        menuBar = new JMenuBar();
        options = new JMenu("Options");
        gameOver = new JOptionPane();


        controllerButton = new ControllerButton(model,this);
        for (int i = 0; i< model.getTabCartes().size(); i ++){
            //principal.add(new JButton(model.getTabImg()[i][j]));
            ButtonImage bt = new ButtonImage(model.getTabCartes().get(i).getDos(),i);
            setControlButton(controllerButton.getButtonListener(), bt);
            principal.add(bt);


        }

        controlMenu = new ControlMenu(model,this);


    }
    // Ajout des différents composants dans les JPanel + Attribution des ActionListener
    public void creerVue(){
        jPanel.add(temps);
        tailleGrille.add(petiteGrille);
        tailleGrille.add(grandeGrille);
        bas.add(essais);
        global.add(jPanel,BorderLayout.NORTH);
        global.add(principal,BorderLayout.CENTER);
        global.add(bas,BorderLayout.SOUTH);
        setJMenuItem(controlMenu.getMenuListener(),restart);
        setJMenuItem(controlMenu.getMenuListener(),scores);
        options.add(restart);
        options.add(scores);
        options.add(tailleGrille);
        menuBar.add(options);
        setJMenuBar(menuBar);
        //setContentPane(jPanel);
        setContentPane(global);
    }
    public void setControlButton(ActionListener buttonlistener, JButton button) {
        button.addActionListener(buttonlistener);
    }
    public void setJMenuItem(ActionListener menuListener, JMenuItem menuItem) {
        menuItem.addActionListener(menuListener);
    }
    // Affichage de la fenêtre de GameOver
    public void gameOver() {
        JLabel perdu = null;
        try {
            perdu = new JLabel(new ImageIcon(ImageIO.read(new File(System.getProperty("user.dir") +"/src/view/images/clown.jpg"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JPanel pano = new JPanel();
        pano.add(perdu);
        setContentPane(pano);
        setTitle("GameOver");
        setIconImage(model.getIconJFrame().getImage());
        setLocation(300,100);
        pack();
        //setMinimumSize(new Dimension(200,200));
        setSize(600,650);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    // Affichage de la fenêtre de victoire
    public void victoire() {
        JLabel victoire = null;
        try {
            victoire = new JLabel(new ImageIcon(ImageIO.read(new File(System.getProperty("user.dir") +"/src/view/images/win.jpg"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JPanel pano = new JPanel();
        JPanel panoPrime = new JPanel();
        JPanel pano2 = new JPanel(new GridBagLayout());
        JLabel message = new JLabel("Félicitations, vous venez de remporter la partie en " + this.chrono.getTemps().getText() + " secondes!!");
        pano2.add(message);
        pano.add(victoire);
        panoPrime.add(pano);
        panoPrime.add(pano2);
        setContentPane(panoPrime);
        setTitle("Victoire");
        setIconImage(model.getIconJFrame().getImage());
        setLocation(300,100);
        pack();
        //setMinimumSize(new Dimension(200,200));
        setSize(600,600);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    // Affichage de la fenêtre des meilleures scores
    public void highScore() {
        JLabel imageScore = null;
        try {
            imageScore = new JLabel(new ImageIcon(ImageIO.read(new File(System.getProperty("user.dir") +"/src/view/images/score.png"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JPanel pano = new JPanel();
        JPanel panoPrime = new JPanel();
        JPanel pano2 = new JPanel(new GridBagLayout());
        JLabel score1 = new JLabel("<html>Meilleur score 1 : <br> Meilleur score 2 : <br> Meilleure score 3 :<html>");

        pano2.add(score1);

        pano.add(imageScore);
        panoPrime.add(pano);
        panoPrime.add(pano2);
        setContentPane(panoPrime);
        setTitle("Scores");
        setIconImage(model.getIconJFrame().getImage());
        setLocation(300,100);
        pack();
        //setMinimumSize(new Dimension(200,200));
        setSize(325,450);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
