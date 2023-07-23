package thisiscodingtest.구현;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 개선된다익스트라알고리즘_9_연습 {

    // Node 클래스를 만든다 (implements Comparable<Node>)
    static class Node implements Comparable<Node>{
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


        @Override
        public int compareTo(Node other) {
            if (this.distance < other.distance) {
                return -1;
            }
            return 1;
        }
    }
    // n, m, start 선언
    static int n, m, start;
    // INF 10억
    static final int INF = (int) 1e9;
    // graph 배열 선언(ArrayList<ArrayList<Node>>)
    static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    // 최단거리 d 배열 선언
    static int[] d = new int[10001];
    // 개선된 다익스트라 알고리즘
    static void dijkstraIP(int start) {
        // 시작점을 pq에 넣는다. 다익스트라 알고리즘 시작점 초기화
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        d[start] = 0;
        pq.offer(new Node(start, 0));
        // 반복문(while)을 돌린다. pq 가 빌때까지
        while (!pq.isEmpty()) {
            // pq에서 노드를 뽑는다.
            Node node = pq.poll();
            // 뽑은 노드의 정보(현재 노드, 최단거리)
            int now = node.index;
            int dist = node.distance;
            if (d[now] < dist) continue;
            for (int i = 0; i < graph.get(now).size(); i++) {
                // 현재 노드에 연결된 최단 거리를 cost (d[now]+연결노드거리) d[]에 입력해준다.
                // 그리고 입력이 되었으면 pq에 넣어준다.
                int cost = d[now] + graph.get(now).get(i).getDistance();
                if (cost < d[graph.get(now).get(i).getIndex()]) {
                    d[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
                }
            }


        }

    }

    public static void main(String[] args) {
        // n,m,start 입력 받기
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();

        // graph 초기화 (.add(ArrayList<Node>))
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

        // d[] 배열 INF로 초기화
        Arrays.fill(d, INF);

        // 다익스트라 알고리즘 실행
        dijkstraIP(start);

        // 출력
        for (int i = 1; i <= n; i++) {
            if (d[i] == INF) {
                System.out.println("INFINITY");
            } else {
                System.out.println(d[i]);
            }
        }

    }


}
