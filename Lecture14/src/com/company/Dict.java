package com.company;

import java.util.HashMap;

public class Dict {
    HashMap<String, String> dict = new HashMap<>();


    public void put(String first, String second) {
        dict.put(first, second);
    }

    public void printDictEngRu(String first) {
        if (dict.get(first) == null) {
            System.out.println("Слово не найдено, переключите режим перевода");
            //context.setTranslate(new RuEng());
        }
        else{System.out.println(dict.get(first));}
    }

    public void printDictRuEng(String first) {
        if (dict.get(first) == null) {
            System.out.println("Слово не найдено, переключите режим перевода");
            //context.setTranslate(new EngRu());
        }
        else {
            System.out.println(dict.get(first));
        }
    }

}