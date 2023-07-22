package thisiscodingtest.구현;

import java.util.Scanner;

public class 개미전사_8_3_정답 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // 식량창고 개수 N 입력 받기
        int n = sc.nextInt();
        int[] arr = new int[n];

        // 각 식량 창고의 식량의 개수 K 입력 받기
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 해당 식량칸의 식량의 최대값 배열
        int[] d = new int[100];

        // 1번째의 최대 식량값 구하기
        d[0] = arr[0];
        // 2번째의 최대 식량값 구하기
        d[1] = Math.max(arr[0], arr[1]);
        // 그 이후부터 n번까지 최대 식량값을 하나하나 구해서 최대식량값 배열 d[]에 넣어주기
        // 최대 식량값은 이전 식량창고까지의 최대값 또는, 이전 이전 식량창고까지의 최대값 + 이번 식량창고의 값 / 둘 중 큰 값이 된다.
        for (int i = 2; i < n; i++) {
            d[i] = Math.max(d[i - 1], d[i - 2] + arr[i]);
        }

        System.out.println("d[n-1] = " + d[n-1]);


    }

}
