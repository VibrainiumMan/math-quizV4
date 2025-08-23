/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mathquizv4;
import java.util.Scanner;


/**
 *
 * @author Milu
 */
public class MathQuizV4 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Timer timer = new Timer();
        FileIO fileIO = new FileIO();
        Menu menu = new Menu(scan, timer, fileIO);

        menu.displayMenu();
        scan.close();
    }
}
