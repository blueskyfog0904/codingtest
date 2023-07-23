package thisiscodingtest.구현;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 개선된다익스트라알고리즘_9_연습 {
    // Node 클래스 만들기 (Comparable<Node)
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

    // INF 무한 10억 초기화
    static int INF = (int) 1e9;

    // graph ArrayList<ArrayList<Node>> 선언
    static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();

    // 최단거리 d 배열 선언
    static int[] d = new int[10001];

    // 개선된 다익스트라 알고리즘(Priority Queue)
    //// start 부터 시작(d[start] = 0, pq에 offer하기)
    //// while 반복문 pq에서 node를 빼서 now, dist, 최단거리 구하기
    //// 만약 d[now]가 < dist 보다 작으면 이미 node를 했던 것으로 continue 로 다시
    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        d[start] = 0;
        pq.offer(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int now = node.getIndex();
            int dist = node.getDistance();
            if (d[now] < dist) continue;
            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = d[now] + graph.get(now).get(i).getDistance();
                if (cost < d[graph.get(now).get(i).getIndex()]) {
                    d[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
                }
            }
        }
    }

    // 메인 작성
    public static void main(String[] args) {
        // n, m, start 입력받기
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();

        // graph 초기화 (.add(ArrayList<Node>))
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Node>());
        }

        // 모든 간선 정보 입력하기
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Node(b, c));
        }

        // 최단거리 d 초기화 (INF)
        Arrays.fill(d, INF);

        // 다익스트라 알고리즘 실행
        dijkstra(start);

        // 결과값 출력
        for (int i = 1; i <= n; i++) {
            if (d[i] == INF) {
                System.out.println("INFINITY");
            } else {
                System.out.println(d[i]);
            }
        }


    }

}
