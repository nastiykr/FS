package com.company;

class Human implements Comparable<Human>{

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
@Override
    public int compareTo(Human o1) {
        if (this.age == o1.age) {
            return 0;
        } else if (this.age < o1.age) {
            return -1;
        } else {
            return 1;
        }
    }

}