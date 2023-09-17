package org.example.app.view;

import java.util.Scanner;

public class AppView {
    public static Scanner scanner = new Scanner(System.in);
    public int getMenu(){
        System.out.println("""
                 ________ MENU _________
                 
                 1 - Get all users posts
                 2 - Get post user by id
                 0 - Close the application
                """);
        return scanner.nextInt();

    }
    public void getOutput(String output){
        System.out.println(output);
    }
}
