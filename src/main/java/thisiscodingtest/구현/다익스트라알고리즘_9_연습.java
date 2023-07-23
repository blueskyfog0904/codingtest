package thisiscodingtest.구현;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 다익스트라알고리즘_9_연습 {

    // Node 클래스 생성
    static class Node {
        private int index;
        private int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        public int getIndex() {
            return this.index;
        }

        public int getDistance() {
            return this.distance;
        }

    }

    // n, m, start 선언
    static int n, m, start;

    // INF = 1e9 초기화
    static final int INF = (int) 1e9;

    // graph 선언(ArrayList<ArrayList<Node>>)
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();

    // 방문여부 배열 visited 선언
    static boolean[] visited = new boolean[10001];

    // 노드별 최소횟수 배열 d 선언
    static int[] d = new int[10001];

    // 방문하지 않았고, 최소횟수가 가장 작은 노드 반환 메소드
    static int getSmallestNode() {
        int min_value = INF;
        int index =0;
        for (int i = 1; i <= n; i++) {
            if (d[i] < min_value && !visited[i]) {
                min_value = d[i];
                index = i;
            }
        }
        return index;
    }

    // 다익스트라 알고리즘
    static void dijkstra(int start) {
        // start 초기화
        // 방문 처리
        visited[start] = true;
        // d[] = 0
        d[start] = 0;
        // start 에 연결된 노드들 거리 d에 입력
        for (int i = 0; i < graph.get(start).size(); i++) {
            d[graph.get(start).get(i).getIndex()] = graph.get(start).get(i).getDistance();
        }

        // 반복문으로 start을 제외한 n-1 만큼 반복
        for (int i = 0; i < n - 1; i++) {
            // 제일 작은 노드 꺼냄(getsmallestNode)
            int now = getSmallestNode();
            // 제일작은 노드 방문 처리
            visited[now] = true;
            // 반복문 cost(d[i] + 연결노드 거리)
            for (int j = 0; j < graph.get(now).size(); j++) {
                int cost = d[now] + graph.get(now).get(j).getDistance();
                // cost가 바로 연결된d[i] 값보다 작을 경우 d[i] 값 교체
                if (cost < d[graph.get(now).get(j).getIndex()]) {
                    d[graph.get(now).get(j).getIndex()] = cost;
                }
            }
        }
    }

    //메인
    public static void main(String[] args) {
        // n, m, start 값 입력 받음
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();

        // graph 배열 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Node>());
        }

        // 모든 간선 값 입력
        for (int i = 1; i <= m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Node(b, c));
        }

        // d 배열 초기화
        Arrays.fill(d, INF);

        // 다익스트라 알고리즘 실행
        dijkstra(start);

        // 모든 결과 값 출력
        for (int i = 1; i <= n; i++) {
            if (d[i] == INF) {
                System.out.println("INFINITY");
            } else {
                System.out.println(d[i]);
            }
        }



    }


}
