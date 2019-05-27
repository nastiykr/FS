package com.company;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        Dict dictRuEng = new Dict();
        dictRuEng.put("привет", "hello");
        dictRuEng.put("книга", "book");
        dictRuEng.put("яблоко", "apple");
        dictRuEng.put("время", "time");
        dictRuEng.put("день", "day");

        Dict dictEngRu = new Dict();
        dictEngRu.put("hello", "привет");
        dictEngRu.put("book", "книга");
        dictEngRu.put("apple", "яблоко");
        dictEngRu.put("time", "время");
        dictEngRu.put("day", "день");

        Scanner scanner = new Scanner(System.in);

        boolean runnig = true;

        Context context = new Context();

        System.out.println("********************************************");
        System.out.println("Программа переводчик.");
        System.out.println("Поддерживаемые языки: русский, английский\n");
        System.out.println("Введите режим перевода: rus-eng, eng-rus\n");
        System.out.println("0 - Выход");
        System.out.println("********************************************\n");
        System.out.println("Введите режим для перевода\n");
        String inputStr = scanner.nextLine();
        String inputStr2 = "";

        while(runnig) {


            if (inputStr.equals("rus-eng")) {
                context.setTranslate(new RuEng());
                System.out.println("Введите слово для перевода\n");
                inputStr2 = scanner.nextLine();
                while (inputStr2.equals("rus-eng")) {
                    System.out.println("Введите слово для перевода\n");
                    inputStr2 = scanner.nextLine();
                }
                if (inputStr2.equals("eng-rus")){
                    inputStr="eng-rus";
                }
                 else{
                    context.performTranslate(inputStr2, dictRuEng, dictEngRu);
                }

            }
            if (inputStr.equals("eng-rus")) {
                context.setTranslate(new EngRu());
                System.out.println("Введите слово для перевода\n");
                inputStr2 = scanner.nextLine();
                while (inputStr2.equals("eng-rus")){
                    System.out.println("Введите слово для перевода\n");
                    inputStr2 = scanner.nextLine();
                }
                if (inputStr2.equals("rus-eng")){
                    inputStr="rus-eng";
                }
                 else {
                    context.performTranslate(inputStr2, dictRuEng, dictEngRu);
                }
            }
            if (inputStr.equals("0") || inputStr2.equals("0")) {
                runnig = false;
            }
            else{
                    System.out.println("Выход из программы\n");
                    runnig = false;
            }
        }
    }
}



