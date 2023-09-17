package org.example.app.view;

import java.util.Scanner;

public class UserIdView {
    public static Scanner scanner = new Scanner(System.in);
    public int getData(){
        System.out.print("Input User id: ");
        return scanner.nextInt();
    }
}
