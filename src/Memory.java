import controller.ControlGroup;
import model.Model;
import model.Score;

public class Memory {
    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater( new Runnable() {
            public void run() {
                Model model = new Model();
                ControlGroup controller = new ControlGroup(model);
                //Fenetre fen = new Fenetre(model);
            }
        });

    }
}
