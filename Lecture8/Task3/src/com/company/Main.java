package com.company;

public class Main {

    public static void main(String[] args) {

        //int n = 5;
        int n = (int) (Math.random() * 10);

        int[][] balances = new int[n][n];
        for(int i=0; i< balances.length; i++){
            for(int j=0;j < balances[i].length; j++){
                balances[i][j]=(int) (Math.random() * 10);;
                System.out.print(balances[i][j]+" ");
            }
            System.out.println("");
        }

        System.out.println("");

        for(int i=0; i< balances.length; i++){
            for(int j = i + 1;j < n; j++) {

                balances[i][j] = balances[i][j] + balances[j][i];
                balances[j][i] = balances[i][j] - balances[j][i];
                balances[i][j] = balances[i][j]- balances[j][i];
                //System.out.print(arr[i][j] + " ");
            }
            //System.out.println("");
        }

        for (int i = 0; i < balances.length; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(balances[i][j] + " ");
            }
            System.out.println();
        }
    }
}
