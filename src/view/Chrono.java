package view;

import javax.swing.*;
import java.text.DecimalFormat;

public class Chrono extends Thread {
    JLabel temps;
    boolean demarre;

    Chrono(JLabel temps ){
        this.temps=temps;
    }

    public JLabel getTemps() {
        return temps;
    }

    public void setTemps(JLabel temps) {
        this.temps = temps;
    }

    public boolean isDemarre() {
        return demarre;
    }

    public void setDemarre(boolean demarre) {
        this.demarre = demarre;
    }

    public void run(){
        demarre=true;
        float t=0;

        while (demarre) {
            try{
                this.sleep(100);
                t+=0.1;
                //System.out.println(t);
                DecimalFormat df = new DecimalFormat("#######0.0");
                String str = df.format(t);
                temps.setText(str);
            }
            catch(InterruptedException e){

            }
        }
    }

    public void terminate(){
        demarre=false;
    }
}
