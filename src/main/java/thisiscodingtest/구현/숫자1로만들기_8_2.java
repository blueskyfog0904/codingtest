package thisiscodingtest.구현;

import java.util.Scanner;

public class 숫자1로만들기_8_2 {

    static int[] d = new int[30001];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 정수 X 를 입력 받는다.
        int x = sc.nextInt();

        // 바텀업 방식으로 밑에서부터 최소값을 구해서 d[i] 배열에 저장시킨다.
        for (int i = 2; i <= x; i++) {
            d[i] = d[i - 1] + 1;
            if (i % 2 == 0) {
                d[i] = Math.min(d[i], d[i / 2] + 1);
            }
            if (i % 3 == 0) {
                d[i] = Math.min(d[i], d[i / 3] + 1);
            }
            if (i % 5 == 0) {
                d[i] = Math.min(d[i], d[i / 5] + 1);
            }

        }

        // 연산을 하는 횟수의 최소값을 출력한다.
        System.out.println("d[x] = " + d[x]);

    }
}
