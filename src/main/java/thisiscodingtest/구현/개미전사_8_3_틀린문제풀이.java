package thisiscodingtest.구현;

import java.util.Scanner;

public class 개미전사_8_3_틀린문제풀이 {

    public static void main(String[] args) {

        // 식량 창고의 개수 N 이 주어진다. (3 <= n <= 100)
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        // 각 식량창고에 저장된 식량의 개수 K가 주어진다.(0 <= K <= 1,000)
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        // 홀수번째씩 털때와 짝수번째씩 털때를 나누어서 연산 후 두 값을 비교하여 더 큰 값을 반환한다.
        int odd = 0;
        int even = 0;

        for (int i = 0; i < arr.length; i = i + 2) {
            odd += arr[i];
        }

        for (int i = 1; i < arr.length; i = i + 2) {
            even += arr[i];
        }

        System.out.println(Math.max(odd, even));

    }
}
