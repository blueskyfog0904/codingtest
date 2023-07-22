package thisiscodingtest.구현;

import java.util.Scanner;

public class 바닥공사_8_4_문제풀이 {

    public static void main(String[] args) {

        // N을 입력 받는다.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 바닥을 채우는 경우의 수를 메모할 배열을 만든다.
        int[] d = new int[1001];

        // 경우의 수를 d[]에 입력한다.
        d[1] = 1;
        d[2] = 3;

        // 가로 길이 3부터 경우의 수를 반복문을 통해 d[]에 입력한다.
        // 점화식을 만든다.
        for (int i = 3; i <= n; i++) {
            d[i] = (d[i - 1] + d[i - 2] * 2) % 796796;
        }

        // 계산된 결과 출력
        System.out.println("d = " + d[n]);

    }

}
