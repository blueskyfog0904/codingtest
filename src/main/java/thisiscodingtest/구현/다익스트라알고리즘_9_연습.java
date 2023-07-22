package thisiscodingtest.구현;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 다익스트라알고리즘_9_연습 {

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
    // N, M, Start 선언
    public static int n, m, start;
    // 가장 높은 수 10억 INF로 초기화
    static final int INF = (int) 1e9;

    // graph(ArrayList<ArrayList<Node>>) 선언
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();

    // 방문(visited, boolean) 배열 선언
    public static boolean[] visited = new boolean[10001];

    // 방문횟수(d) 배열 선언
    public static int[] d = new int[10001];

    // 방문하지 않은 가장 작은 노드 인덱스 반환 메서드 작성
    public static int getSmallestNode() {
        int min_value = INF;
        int index = 0;
        for (int i = 1; i <= n; i++) {
            if (d[i] < min_value && !visited[i]) {
                min_value = d[i];
                index = i;
            }
        }
        return index;
    }

    // 다익스트라 알고리즘 작성
    public static void dijkstra(int start) {
        // 시작 노드 초기화(최소 횟수, 방문여부, 연결 노드 거리 입력)
        d[start] = 0;
        visited[start] = true;
        for (int j= 0; j < graph.get(start).size(); j++) {
            d[graph.get(start).get(j).getIndex()] = graph.get(start).get(j).getDistance();
        }
        // 시작 노드를 제외한 나머지 노드 전부에 대해 반복문으로 최소 횟수 입력
        for (int i = 0; i < n - 1; i++) {
            int now = getSmallestNode();
            visited[now] = true;
            for (int j = 0; j < graph.get(now).size(); j++) {
                // 거리 cost를 구하고, 직접 가는 거리보다 값이 작을 경우 d[] 에 입력
                int cost = d[now] + graph.get(now).get(j).getDistance();
                if (cost < d[graph.get(now).get(j).getIndex()]) {
                    d[graph.get(now).get(j).getIndex()] = cost;
                }
            }
        }
    }

    // 메인 작성
    public static void main(String[] args) {
        // n, m, start 입력
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();

        // graph 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Node>());
        }

        // 모든 간선 정보 입력
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Node(b, c));
        }

        // d[] 배열도 전체 INF로 초기화
        Arrays.fill(d, INF);

        // 다익스트라 알고리즘 실행
        dijkstra(start);

        // 전체 결과 값 출력(값이 없을 경우 INFINITY, 있을 경우 d[i])
        for (int i = 1; i <= n; i++) {
            if (d[i] == INF) {
                System.out.println("INFINITY");
            } else{
                System.out.println(d[i]);
            }
        }

    }


}
