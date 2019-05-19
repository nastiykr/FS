package com.company;
import java.util.*;

public class Main {

    public static void main(String a[]) {

        HumanComparator mycompar = new HumanComparator();

        Set<Human> listhuman = new TreeSet<>(mycompar);

        Human h1 = new Human("Рома", 30);
        Human h2 = new Human("Дима", 60);
        Human h3 = new Human("Ксюша",20);
        Human h4 = new Human("Толя", 24);
        Human h5 = new Human("Катя", 23);

        listhuman.add(h1);
        listhuman.add(h2);
        listhuman.add(h3);
        listhuman.add(h4);
        listhuman.add(h5);

        System.out.println("Вывод TreeSet: " + listhuman);
    }
}
