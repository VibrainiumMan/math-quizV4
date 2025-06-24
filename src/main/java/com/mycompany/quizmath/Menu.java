/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quizmath;

import java.util.Scanner;

/**
 *
 * @author Milu
 */
public class Menu {

    private Scanner scan;
    private FileIO fileIO;

    public Menu() {
        scan = new Scanner(System.in);
        fileIO = new FileIO();
    }
    
    public void viewHighScores(){
        fileIO.readHighScores();
    }

    public void displayMenu() {
        System.out.println("1. Start Quiz");
        System.out.println("2. View High Scores ");
        System.out.println("3. Exit");

        System.out.println("Enter your choice: ");
        int choice = scan.nextInt();
        handleUserChoice(choice);
    }

    public void handleUserChoice(int choice) {
        switch (choice) {
            case 1:
                break; 
            case 2:
                viewHighScores();
                System.exit(0);
                break;
            case 3:
                System.out.println("Exited the program");
                System.exit(0);
                break;                
            default:
                System.out.println("Invalid choice. Please enter a valid option");
                break;
        }
    }
}