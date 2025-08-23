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
public class Menu {
    private final FileIO fileIO;
    private final Timer timer;
    private final Scanner scan;

    public Menu(Scanner scan, Timer timer, FileIO fileIO) {
        this.scan = scan;
        this.timer = timer;
        this.fileIO = fileIO;
    }

    public void displayMenu() {
        boolean quit = false;
        while (!quit) {
            System.out.println("\n=======================================");
            System.out.println("              Math Quiz V4");
            System.out.println("=======================================\n");
            System.out.println("1. Start Quiz");
            System.out.println("2. View Scores");
            System.out.println("3. Exit");

            int choice;
            while (true) {
                System.out.print("\nEnter your choice: ");
                if (scan.hasNextInt()) {
                    choice = scan.nextInt();
                    scan.nextLine(); // Consume the newline
                    if (choice >= 1 && choice <= 3) {
                        break; // Valid choice, exit the loop
                    } else {
                        System.out.println("Invalid choice. Please enter a valid option.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                    scan.nextLine();
                }
            }

            switch (choice) {
                case 1:
                    startQuiz();
                    break;
                case 2:
                    viewHighScores();
                    break;
                case 3:
                    System.out.println("Exiting the program...");
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
    }


    private void startQuiz() {
        QuizLogic.startQuiz(scan, timer, fileIO);
    }

    private void viewHighScores() {
        fileIO.readHighScores();

        System.out.println("\nPress any key to go back to the main menu or 'x' to exit.");
        String userInput = scan.nextLine().trim();
        if ("x".equalsIgnoreCase(userInput)) {
            System.exit(0);
        }
    }
}
