/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mathquizv4;

/**
 *
 * @author Milu
 */
public abstract class Question {
    protected String questionText;
    protected double correctAnswer;
    protected Player player;

    // Constructor
    public Question(String questionText, double correctAnswer, Player player) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.player = player;
    }

    // Display the question text
    public void displayQuestion() {
        System.out.println(questionText);
    }

    // Abstract method for generating a question
    public abstract double generateQuestion();

    // Check if the user's answer is correct
    public void checkAnswer(double userAnswer) {
        double rounded = 0.001;
        if (Math.abs(userAnswer - correctAnswer) < rounded) {
            System.out.println("Correct! ");
            player.setScore(player.getScore() + 10);
        } else {
            System.out.println("Wrong! ");
        }
    }
}
