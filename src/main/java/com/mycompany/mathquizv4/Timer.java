/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mathquizv4;
import java.time.Duration;
import java.time.Instant;

/**
 *
 * @author Milu
 */
public class Timer {
    public Instant startTime;
    public Instant stopTime;
    
    public void start(){
        startTime = Instant.now(); //Starts the time
    }
    
    public void stop(){
        stopTime = Instant.now(); //Stops time
    }
     public String timeFormat() {
        Duration duration;
        if (stopTime != null) {
            duration = Duration.between(startTime, stopTime);
        } else {
            duration = Duration.between(startTime, Instant.now());
        }
        long minutes = duration.toMinutes();
        long seconds = duration.minusMinutes(minutes).getSeconds();
        long milliseconds = duration.minusSeconds(seconds).toMillis();

        return String.format("Time: %02d:%02d.%02d", minutes, seconds, milliseconds / 10); //Formats the display of the time
    }     
}