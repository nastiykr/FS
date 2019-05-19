package com.company;

import java.util.*;

public class Main
{
    public static void main(String args[]) {

        int bottle = 99;
        int bottle2;

        while (bottle !=1) {
            System.out.println(bottle +  " bottles of beer on the wall,\n" + bottle + " bottles of beer.");
            bottle=bottle-1;
            if (bottle == 1) {
                System.out.println("Take one down and pass it around,\n" + bottle + " bottle of beer on the wall.");
            }
            else {
                System.out.println("Take one down and pass it around,\n" + bottle + " bottles of beer on the wall.");
            }
            System.out.println(" ");
        }


        bottle2=bottle-1;
        System.out.println(bottle + " bottle of beer on the wall,\n" + bottle2 + " bottles of beer.\nTake one down and pass it around, \nNo more bottles of beer on the wall.");
        System.out.println(" ");
        System.out.println("No more bottles of beer on the wall, \nNo more bottles of beer. \nGo to the store and buy some more, \n99 bottles of beer on the wall.");

    }
}