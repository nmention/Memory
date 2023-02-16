package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Score {
    ArrayList<Double> tabScores;
    Double firstScore;
    Double secondScore;
    Double thirdScore;
    FileWriter fileWriter;
    BufferedWriter bufferedWriter;

    public Score() {
        try {
            fileWriter = new FileWriter(new File("/home/nmention/S2/IHM/Projet/Memory/src/model/scores/scores.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        bufferedWriter = new BufferedWriter(fileWriter);

    }
    public void storeScores(double score){
        this.tabScores.add(score);
    }
    public void writeScore() {
        for (int i = 0; i < tabScores.size(); i++) {
            try {
                this.bufferedWriter.write(tabScores.get(i).toString());
                this.bufferedWriter.newLine();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            this.bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
