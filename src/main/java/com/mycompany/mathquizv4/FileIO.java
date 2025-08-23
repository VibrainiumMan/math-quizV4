/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mathquizv4;
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

    public void saveHighScore(String playerName, int score, String time) {
        if (!checkUserExists(playerName)) {
            try (FileWriter writer = new FileWriter("highscores.txt", true)) {
                writer.write(playerName + "," + score + "," + time + "\n");
                highScores.add(playerName + ", " + score + ", " + time);
            } catch (IOException e) {
                System.out.println("Error");
            }
        }
    }

    public void readHighScores() {
        System.out.println("\n======================");
        System.out.println("      High Scores");
        System.out.println("=======================\n");
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

    public boolean checkUserExists(String playerName) {
        try (Scanner scanner = new Scanner(new File("highscores.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.startsWith(playerName + ",")) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error");
        }
        return false;
    }

    public ArrayList<String> getHighScores() {
        return highScores;
    }
}
