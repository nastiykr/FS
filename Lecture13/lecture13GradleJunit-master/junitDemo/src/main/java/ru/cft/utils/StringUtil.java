package ru.cft.utils;

public class StringUtil {
    public static String format(double pi, int number){
        String format = "%."+ number +"f";
        return String.format(format, pi);
    }
}
