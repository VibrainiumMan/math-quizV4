/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mathquizv4;

import java.util.Scanner;

/**
 *
 * @author Milu
 */
public class QuizLogic {

    public static void startQuiz(Scanner scan, Timer timer, FileIO fileIO) {
        System.out.println("Please enter your username:");
        String username = scan.nextLine();

        Player player = new Player();
        player.setName(username);
        player.setScore(0);

        timer.start();

        for (int i = 1; i <= 5; i++) {
            System.out.println("\nQuestion " + i + ": ");
            Question question;
            double correctAnswer;

            if (Math.random() < 0.5) {
                question = new OperationQuestion("", 0, player);
                correctAnswer = ((OperationQuestion) question).generateQuestion();
            } else {
                question = new FractionQuestion("", 0, player);
                correctAnswer = ((FractionQuestion) question).generateQuestion();
            }

            question.displayQuestion();

            double userAnswer = -1;
            while (true) {
                System.out.print("Your answer: ");
                try {
                    userAnswer = scan.nextDouble();
                    scan.nextLine(); // Consume newline
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid input, please try again.");
                    scan.nextLine(); // Consume invalid input
                }
            }

            question.checkAnswer(userAnswer);
        }

        timer.stop();
        displayResults(scan, player, timer, fileIO, username);
    }

    private static void displayResults(Scanner scan, Player player, Timer timer, FileIO fileIO, String username) {
        System.out.println("\n======================");
        System.out.println("   Math Quiz Results");
        System.out.println("=======================\n");
        System.out.println("Final Score: " + player.getScore() + " out of 50");
        System.out.println("Final Time: " + timer.timeFormat());

        FeedbackClass feedbackClass = new FeedbackClass(new FeedbackClass.Feedback());
        String feedbackMessage = feedbackClass.generateFeedback(player.getScore());
        System.out.println(feedbackMessage);

        fileIO.saveHighScore(username, player.getScore(), timer.timeFormat());
        System.out.println("Your high score has been saved!");

        System.out.println("\nPress any key to go back to the main menu or 'x' to exit.");
        String userInput = scan.nextLine().trim();
        if ("x".equalsIgnoreCase(userInput)) {
            System.exit(0);
        }
    }
}