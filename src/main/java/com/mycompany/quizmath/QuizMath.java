/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.quizmath;

import java.util.Scanner;

/**
 *
 * @author Milu
 */
import java.util.Scanner;

public class QuizMath {

public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Menu menu = new Menu();
        FileIO fileIO = new FileIO(); 

        System.out.println(" === Math Quiz === \n");

        // Displaying the menu and handling the user choice
        menu.displayMenu();
        System.out.println("Please enter your username:");
        String username = scan.nextLine();

        Player player = new Player();
        player.setName(username);
        player.setScore(0);

        Question question = new Question("", 0, player); // Initialize with empty text and 0 answer

        for (int i = 0; i < 5; i++) {
            double correctAnswer = question.generateQuestion();
            question.displayQuestion(); // Display the generated question

            double userAnswer = scan.nextDouble(); // Get user's answer
            question.checkAnswer(userAnswer, correctAnswer); // Check user's answer
        }

        // Display final score
        System.out.println(username + "'s final score: " + player.getScore());

        // Save the high score
        fileIO.saveHighScore(username, player.getScore());

        // Display high scores
        fileIO.readHighScores();

    }

}
