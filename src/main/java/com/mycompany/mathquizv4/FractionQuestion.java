/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mathquizv4;

/**
 *
 * @author Milu
 */
public class FractionQuestion extends Question {

    public FractionQuestion(String questionText, double correctAnswer, Player player) {
        super(questionText, correctAnswer, player);
    }

    @Override
    public double generateQuestion() {
        int numo1 = generateNumber(5);
        int numo2 = generateNumber(5);
        int denom1 = generateNumber(5) + 1;
        int denom2 = generateNumber(5) + 1;
        double result = 0d;
        String operation = "";


        while (denom1 == 0) {
            denom1 = generateNumber(20) + 1; 
        }
        while (denom2 == 0) {
            denom2 = generateNumber(20) + 1;
        }

        switch (generateNumber(4)) {
            case 0:
                operation = " + ";
                result = (numo1 * denom2 + numo2 * denom1) / (double) (denom1 * denom2);
                break;
            case 1:
                operation = " - ";
                result = (numo1 * denom2 - numo2 * denom1) / (double) (denom1 * denom2);
                break;
            case 2:
                operation = " * ";
                result = (numo1 * numo2) / (double) (denom1 * denom2);
                break;
            case 3:
                operation = " / ";
                // Avoid division by zero by ensuring numo2/denom2 is not zero
                result = (numo1 * denom2) / (double) (denom1 * numo2);
                break;
            default:
                break; 
        }

        this.questionText = numo1 + "/" + denom1 + operation + numo2 + "/" + denom2; // Set the question text
        this.correctAnswer = result; // Set the correct answer
        return result;
    }

    private int generateNumber(int range) {
        return (int) (Math.random() * range);
    }
}