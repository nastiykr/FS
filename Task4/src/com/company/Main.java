package com.company;
import java.util.*;


public class Main {
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);

        String s = "";

        System.out.println("Vvedite chislo k");
        int k = in.nextInt();

        for (int i=11; i<=99; i++){
            s = s + Integer.toString(i);
        }

        var m = s.charAt(k-1);

        System.out.println(s);
        System.out.println("K-taya cifra = " + m);
    }
}