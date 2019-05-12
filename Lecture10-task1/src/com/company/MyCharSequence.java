package com.company;

public class MyCharSequence implements CharSequence {
    private String content;

    public MyCharSequence(String  value) {  //Конструктор класса
        this.content = value;
    }
    @Override
    public String toString() {
        return content;
    }

    @Override
    public int length() { //Переопределение length()
        return content.length();
    }

    @Override
    public char charAt(int index) {   //Переопределение charAt()
        return  content.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) { //Переопределение subSequence()
        return content.subSequence(start, end);
    }
}
