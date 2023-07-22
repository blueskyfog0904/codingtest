package thisiscodingtest.구현;

import java.util.Arrays;
import java.util.Scanner;

public class 효율적인화폐구성_8_5_문제풀이 {
    public static void main(String[] args) {
        // 정수 N, M을 입력 받는다
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        // 화폐의 가치 입력 받는다
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 화폐의 최소개수 배열 d를 생성해서 높은 숫자를 입력해준다.
        int[] d = new int[m+1];
        Arrays.fill(d, 10001);

        // 화폐의 가치 하나씩 최소 개수를 입력한다.
        // 민약에 d[i - arr[j]] 값이 없을 경우는 값이 없다.
        d[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = arr[i]; j <= m; j++) {
                if (d[j - arr[i]] != 10001) {
                    // 최소 개수는 d[j] 와 d[j-arr[i]+1 값 중 작은 값으로 한다.
                    // 만약 d[6]을 구할 경우 앞서 화폐가치 2로 돌았을 경우 d[6] = 3이다.
                    // 그런데 이번에 화폐가치 3으로 돌게되면 기존에 화폐가치 2로 돌았던 값(3)과 d[6-3](1) Math.min(3, d[6-3](1) + 1) 의 값 중 작은 값을 선택한다.
                    d[j] = Math.min(d[j], d[j - arr[i]] + 1);
                }
            }
        }
        if (d[m] == 10001) {
            System.out.println(-1);
        } else {
            System.out.println(d[m]);
        }


    }

}
