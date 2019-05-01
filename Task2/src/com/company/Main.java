package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);


        int number = (int) (Math.random() * 10);
        int first;
        int second = 0;


        System.out.println("Vvedite kolichestvo igrokov");
        int n = in.nextInt();



        System.out.println("Igrok-1 vvodit chislo do 9: ");
        first = in.nextInt();

        while (first > 10) {
            System.out.println("Chislo dolzhno bit ot 0 do 9!!! ");
            System.out.println("Igrok-1 vvodit chislo do 9: ");
            first = in.nextInt();
        }

        if (n == 2) {

            System.out.println("Igrok-2 vvodit chislo do 9: ");
            second = in.nextInt();

            while (second > 10) {
                System.out.println("Chislo dolzhno bit ot 0 do 9!!! ");
                System.out.println("Igrok-2 vvodit chislo do 9: ");
                second = in.nextInt();
            }


        }

        if (first == number) {
            System.out.println("Viigral Igrok-1, eto bilo chislo: " + number);
        }
        else {
            if (n == 2 && second == number) {
                    System.out.println("Viigral Igrok-2, eto bilo chislo: " + number);

                }
            else {
                    System.out.println("Ne ugadano, eto bilo chislo: " + number);
                }
            }
    }
}