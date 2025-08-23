/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mathquizv4;

/**
 *
 * @author Milu
 */
public class OperationQuestion extends Question {

    OperationQuestion(String questionText, double correctAnswer, Player player) {
        super(questionText, correctAnswer, player);
    }


    @Override
    public double generateQuestion() {
        // Generate two numbers between 0 to 100 randomly.
        int num1 = this.generateNumber(100);
        int num2 = this.generateNumber(100);

        String operation = "";
        double result = 0d;

        switch (this.generateNumber(4)) {
            case 0:
                operation = " + ";
                result = num1 + num2;
                break;
            case 1:
                operation = " - ";
                result = num1 - num2;
                break;
            case 2:
                operation = " * ";
                result = num1 * num2;
                break;
            case 3:
                operation = " / ";
                // Keep assigning a new random number to num2 if num2 is 0.
                while (num2 == 0) {
                    num2 = this.generateNumber(100);
                }
                result = 1d * num1 / num2;
                break;
            default:
                break;
        }
        this.questionText = num1 + operation + num2; // Set the question text
        this.correctAnswer = result; // Set the correct answer
        return result;
    }

    private int generateNumber(int range) {
        return (int) (Math.random() * range);
    }
}
