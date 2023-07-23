package thisiscodingtest.구현;

import java.util.Arrays;
import java.util.Scanner;

public class 플로이드워셜알고리즘_9_연습 {

    // n, m 선언
    static int n, m;

    // 최단거리 이차원 그래프 선언(500번까지)
    static int[][] graph = new int[501][501];

    // 무한 초기화
    static int INF = (int) 1e9;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        // 그래프를 INF 로 초기화
        for (int i = 0; i < 501; i++) {
            Arrays.fill(graph[i], INF);
        }

        // 모든 간선 값 입력
        for (int i = 1; i <= m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph[a][b] = c;
        }

        // a,b가 같은 값일 때 그래프[a][b] = 0 초기화
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                if (a == b) {
                    graph[a][b] = 0;
                }
            }
        }

        // 플로이드워셜 알고리즘
        for (int k = 1; k <= n; k++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        // 결과 값 출력
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                if (graph[a][b] == INF) {
                    System.out.println("INFINITY");
                } else {
                    System.out.print(graph[a][b] + " ");
                }
            }
            System.out.println();
        }



    }

}
