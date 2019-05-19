package com.company;
import java.util.Comparator;

class HumanComparator implements Comparator<Human> {
    public int compare(Human a, Human b){
        if (a.getAge() == b.getAge()) {
            return 0;
        } else if (a.getAge() < b.getAge()) {
            return -1;
        } else {
            return 1;
        }
    }
}
class Human {

    private String name;
    private int age;

    public Human(String n, int a) {
        this.name = n;
        this.age = a;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {

        return this.name + "-" + this.age;
    }

}