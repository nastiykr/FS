package com.company;
import java.util.Scanner;

public class ClassString {

    private String  result = "";
    private int start, stop;

    String ANSI_RED = "\033[31m";
    String ANSI_RESET = "\033[0m";



    Scanner scanner = new Scanner(System.in);

    public void convertPrint (String result){
        System.out.println(ANSI_RED + result +ANSI_RESET);
    }

    public void reverseStringChars() {
        System.out.println("Введите строку");
        String str = scanner.nextLine();

        int length = str.length() ;

        for (int i = 0; i < length; i++) {
            result = str.charAt(i) + result;
        }
        convertPrint(result);
    }


    public void reverseStringBuilder(){
        System.out.println("Введите строку");
        String str = scanner.nextLine();
        result = new StringBuilder(str).reverse().toString();
        convertPrint(result);
    }

    public void formatStringSpace(){
        System.out.println("Введите строку");
        String str = scanner.nextLine();
        result = str.trim();
        convertPrint(result);
    }

    public void formatStringUpperCase(){
        System.out.println("Введите строку");
        String str = scanner.nextLine();
        result = str.toUpperCase();
        convertPrint(result);
    }
    public void takeSubstring(){
        System.out.println("Введите строку");
        String str = scanner.nextLine();

        System.out.println("Введите начальный индекс");
        start = scanner.nextInt();

        System.out.println("Введите конечный индекс");
        stop = scanner.nextInt();



        while (stop <= start) {
            System.out.println("Введите конечный индекс больше начального индекса");
            stop = scanner.nextInt();
        }

        while (stop> str.length()) {
            System.out.println("Введите конечный интервал не больше длины строки, т.е. до " + str.length() );
            stop = scanner.nextInt();
        }
        result = str.substring(start,  stop);
        convertPrint(result);
        scanner.nextLine();
    }
}