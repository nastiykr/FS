package com.company;
import java.util.*;

public class Main
{
    public static void main(String args[]) {
        {
            Scanner in = new Scanner(System.in);

            int n = 0;
            int sum = 0;

            System.out.println("Vvedite chislo k");
            int k = in.nextInt();

            while (sum < k) {
                n++;
                sum = sum + n;
            }
            if (sum == k) {
                System.out.println("Chislo n ravno " + n);
            } else {
                System.out.println("Takogo chisla n net");
            }

        }
    }
}

