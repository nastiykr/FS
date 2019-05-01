package com.company;

public class Main {

    public static void main(String[] args) {


        int n = (int) (Math.random() * 10);

        int[][] arr = new int[n][n];
        for(int i=0; i< arr.length; i++){
            for(int j=0;j < arr[i].length; j++){
                arr[i][j]=(int) (Math.random() * 10);;
                System.out.print(arr[i][j]+" ");
            }
            System.out.println("");
        }

        System.out.println("");

        for(int i=0; i< arr.length; i++){
            for(int j=0;j < arr[i].length; j++) {
                System.out.print(arr[j][i] + " ");
            }
            System.out.println("");
        }
    }
}
