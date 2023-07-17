package thisiscodingtest.구현;

import java.util.Scanner;

public class 두배열의원소교체_6_4_내풀이 {


    public static void main(String[] args) {

        // N과 K를 입력 받는다
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();

        // 배열 A의 원소를 입력 받는다
        int[] arrA = new int[n];
        String strA = sc.nextLine();
        for (int i = 0; i < n; i++) {
            arrA[i] = strA.charAt(i) - '0';
        }

        // 배열 B의 원소를 입력받는다
        int[] arrB = new int[n];
        String strB = sc.nextLine();
        for (int i = 0; i < n; i++) {
            arrB[i] = strB.charAt(i) - '0';
        }

        // 배열 A는 오름차순 정렬
        for (int i = 0; i < n; i++) {
            int min_index = i; // 가장 작은 원소의 인덱스
            for (int j = i+1; j < n; j++) {
                if (arrA[min_index] > arrA[j]) {
                    min_index = j;
                }
            }
            // 스와프
            int temp = arrA[i];
            arrA[i] = arrA[min_index];
            arrA[min_index] = temp;
        }

        // 배열 B는 내림차순 정렬
        for (int i = 0; i < n; i++) {
            int min_index = i; // 가장 작은 원소의 인덱스
            for (int j = i + 1; j < n; j++) {
                if (arrB[min_index] > arrB[j]) {
                    min_index = j;
                }
            }
            // 스와프
            int temp = arrB[i];
            arrB[i] = arrB[min_index];
            arrB[min_index] = temp;
        }
        int[] reverseArrB = new int[n];
        for (int i = 0; i < n; i++) {
            reverseArrB[i] = arrB[n - 1 - i];
        }
        // K번의 A와B의 원소교체가 이루어지는데 A[i]번의 원소가 B 전체의 원소와 비교해서 B[j]의 원소가 클 경우 교체 => continue
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < reverseArrB.length; j++) {
                if (arrA[i] < reverseArrB[j]) {
                    int temp = arrA[i];
                    arrA[i] = reverseArrB[j];
                    reverseArrB[i] = temp;
                    continue;
                }

            }
        }
        int result = 0;
        for (int i = 0; i < arrA.length; i++) {
            result += arrA[i];
        }
        System.out.println("result = " + result);

    }
}
