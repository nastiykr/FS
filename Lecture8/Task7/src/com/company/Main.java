package com.company;
import java.util.*;

public class Main {
    public static void main(String args[]) {
        {
            Scanner in = new Scanner(System.in);


            System.out.println("Vvedite nomer mesyaca");
            int k = in.nextInt();

            switch (k) {
                case 12:
                case 1:
                case 2:
                    System.out.println("Zima");
                    break;
                case 3:
                case 4:
                case 5:
                    System.out.println("Vesna");
                    break;
                case 6:
                case 7:
                case 8:
                    System.out.println("Leto");
                    break;
                case 9:
                case 10:
                case 11:
                    System.out.println("Osen");
                    break;
            }

        }
    }
}

