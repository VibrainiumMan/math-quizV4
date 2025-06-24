/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quizmath;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Milu
 */
public class FileIO {

    private ArrayList<String> highScores;

    public FileIO() {
        highScores = new ArrayList<>();
    }

    public void saveHighScore(String playerName, int score) {
        try (FileWriter writer = new FileWriter("highscores.txt")) {
            writer.write(playerName + "," + score + "\n");
            highScores.add(playerName + ", " + score);
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    public void readHighScores() {
        try (Scanner scanner = new Scanner(new File("highscores.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                highScores.add(line);
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    public ArrayList<String> getHighScores() {
        return highScores;
    }
}
    
