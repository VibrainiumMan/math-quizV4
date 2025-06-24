/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quizmath;

import java.util.Random;

/**
 *
 * @author Milu
 */
public class Question {
    
    private String questionText;
    private double correctAnswer;
    private Player player;
    private Random random;
    
    Question(String questionText, double correctAnswer, Player player) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.player = player;
        this.random = new Random();
    }
    
    
    public void displayQuestion() {
        System.out.println(questionText);
    }
    
    public int generateNumber(int range) {
        return random.nextInt(range);
    }
    
    public double generateQuestion() {
        //Generate two numbers between 0 to 100 randomly.
        int num1 = this.generateNumber(100);
        int num2 = this.generateNumber(100);
        
        String operation = "";
        double result = 0d;
        
        switch(this.generateNumber(4)) {
            case 0:
                operation = "+";
                result = num1 + num2;
                break;
            case 1:
                operation = "-";
                result = num1 - num2;
                break;
            case 2:
                operation = "*";
                result = num1 * num2;
                break;
            case 3:
                operation = "/";
                //Keep assigning a new random number to num2 if num2 is 0.
                while (num2 == 0) {
                    num2 = this.generateNumber(100);
                }
                // In java, the result of an integer divided by an integer is still an integer.
                result = 1d * num1 / num2;
                // Hence, we first let num1 times 1.0 to make num1 become a double type number.
                break;
            default:
                break;
        } 
        System.out.println("Question: " + num1 + operation + num2);
        return result;
    }
    
    
    public void checkAnswer(double userAnswer, double correctAnswer) {
        int score = 0;
        //Check the answer based on the absolute value of the difference between uAnswer and cAnswer. 
        if (Math.abs(correctAnswer - userAnswer) < 0.000001) {
            score = 10;
            System.out.println("Correct!");
        } else {
            score = -10;
            System.out.println("Wrong!");
        }
        player.setScore(player.getScore() + score);
    }
    
}
