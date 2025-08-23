/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mathquizv4;

/**
 *
 * @author Milu
 */
public class Player implements PlayerInfo {

    private String name;
    int score;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public int getScore() {
        return score;
    }
}
