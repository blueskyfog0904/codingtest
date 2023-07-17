package thisiscodingtest;

import java.util.Scanner;

public class 숫자카드게임 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] cardArray;
        cardArray = new int[n][m];

        for (int i = 0; i < cardArray.length; i++) {
            for (int j = 0; j < cardArray[i].length; j++) {
                cardArray[i][j] = sc.nextInt();
            }
        }
        int[] value = new int[n];
        int low = 101;
        for (int i =0; i < cardArray.length; i++) {
            for (int j =0; j < cardArray[i].length; j++) {
                if (cardArray[i][j] < low) {
                    low = cardArray[i][j];
                }
            }
            value[i] = low;
            System.out.println("각 value값 " +value[i]);
            low = 101;
        }
        int result=0;
        for(int i = 0; i < value.length; i++) {
            if (value[i] > result) {
                result = value[i];
            }
        }
        System.out.println("최종값은 " + result);


    }
}
