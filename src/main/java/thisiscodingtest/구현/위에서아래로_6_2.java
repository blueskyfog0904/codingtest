package thisiscodingtest.구현;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 위에서아래로_6_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // 삽입정렬
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j-1]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                } else {
                    break;
                }

            }
        }
        int[] reverseArr = new int[n];
        for (int i = arr.length - 1, j = 0; i >= 0; i--, j++) {
            reverseArr[j] = arr[i];
        }



        for (int i = 0; i < n; i++) {
            System.out.print(reverseArr[i] + " ");
        }


    }

}
