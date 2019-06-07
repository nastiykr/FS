package ru.cft.utils;

public class PiUtil {
    public static double calculatePi(int count){
        int m = 1;
        int n = 0;
        double pi = 0.0;
        final double SQRT_12 = Math.sqrt(12);
        while (count > n)
        {
            pi += SQRT_12 * (Math.pow(-1, n)/(m * Math.pow(3, n)));
            m += 2;
            n++;
        }

        return pi;
    }

    public static void main(String[] args) {
        System.out.println(calculatePi(4));
    }

}
