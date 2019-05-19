package com.company;
import java.util.*;

public class Main {

    public static void main(String a[]) {

        List<Human> listhuman = new ArrayList<>();

        Human h1 = new Human("Рома", 30);
        Human h2 = new Human("Дима", 60);
        Human h3 = new Human("Ксюша",20);
        Human h4 = new Human("Толя", 24);
        Human h5 = new Human("Катя", 24);

        listhuman.add(h1);
        listhuman.add(h2);
        listhuman.add(h3);
        listhuman.add(h4);
        listhuman.add(h5);

        //первый способ вывода
        //for (Human o : listhuman) {
        //    System.out.println(o);
        //}
        //второй способ вывода
        System.out.println("До сортировки: " + listhuman);
        Collections.sort(listhuman);
        System.out.println("После сортировки: " + listhuman);

    }
}
