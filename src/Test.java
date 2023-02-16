import model.Model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import java.util.Collections;

public class Test {
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("/home/nmention/S2/IHM/Projet/Memory/src/model/scores/scores.txt")));
        try {
            bufferedWriter.write("heyyy");
            bufferedWriter.newLine();
            bufferedWriter.write("hooo");
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
