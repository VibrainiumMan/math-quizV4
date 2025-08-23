/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mathquizv4;

/**
 *
 * @author Milu
 */
public class FeedbackClass {

    private FeedbackMessage feedbackMessage;

    public FeedbackClass(FeedbackMessage feedbackMessage) {
        this.feedbackMessage = feedbackMessage;
    }

    public String generateFeedback(int score) {
        return feedbackMessage.generateFeedback(score);
    }

    // Interface for generating feedback
    public interface FeedbackMessage {
        String generateFeedback(int score);
    }

    // Positive feedback generator
    public static class Feedback implements FeedbackMessage {
        @Override
        public String generateFeedback(int score) {
            if (score == 0) {
                return "You scored 0. Keep practicing!";
            } else if (score >= 30) {
                return "Great job! You scored well.";
            } else {
                return "Not bad, but you can do better.";
            }
        }
    }
}