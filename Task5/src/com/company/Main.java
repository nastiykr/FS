package com.company;
import java.util.*;

public class Main {
    public static void main(String args[]) {
        {
            Scanner in = new Scanner(System.in);

            int count = 0;

            System.out.println("Vvedite chislo a");
            int a = in.nextInt();

            System.out.println("Vvedite chislo b");
            int b = in.nextInt();

            for (int i = a; i <= b; i++) {
                if (i % 12 == 0) count++;
            }

            System.out.println("Kolichestvo celix chisel ot a do b, kotorie delitsya na 12 = " + count);
        }
    }
}

