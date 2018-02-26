package com.myShop.sprint3;

import java.util.ArrayList;
import java.util.Scanner;

public class AbstractView {

    static final String GREEN = "\033[32m";
    static final String RED = "\033[31m";
    static final String YELLOW = "\033[33m";
    static final String WHITE = "\033[0m";

    void printTitle(String txt) {
        System.out.println(GREEN + txt + WHITE);
    }

    void printMessage(String txt) {
        System.out.println(YELLOW + txt + WHITE);
    }

    void printError(String error) {
        System.out.println(RED + error + WHITE);
    }

    <T> void printList(ArrayList<T> list) {
        if (list.size() < 1) {
            this.printError("This list is empty!");
        } else {
            for (T el : list) {
                System.out.println(el);
            }
        }
    }

    public String getUserInput(String r) {
        Scanner sc = new Scanner(System.in);
        System.out.println(r);
        return sc.nextLine();
    }

    public Integer getUserNumber(String r) {
        Scanner sc = new Scanner(System.in);
        System.out.println(r);
        return sc.nextInt();
    }

}
