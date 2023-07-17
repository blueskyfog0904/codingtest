package thisiscodingtest.구현;

import java.util.Scanner;

public class 게임개발 {

    public static int n, m, x, y, direction;

    // 왼쪽으로 회전
    public static void turn_left() {
        direction -= 1;
        if(direction<0) direction = 3;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        x = sc.nextInt();
        y = sc.nextInt();

        // 북,서,남,동 방향
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        // 육지와 바다 맵
        int[][] arr = new int[n][m];
        // 이동한곳과 이동하지 않은 곳 맵
        int[][] d = new int[n][m];

        // 전체 맵 정보를 입력받기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int cnt = 1;
        int turn_time = 0;

        int nx=0;
        int ny=0;

        // 시뮬레이션 시작
        while(true) {

            // 왼쪽으로 회전
            turn_left();

            nx = x + dx[direction];
            ny = y + dy[direction];

            // 회전한 이후 정면에 가보지 않은 칸이 존재하는 경우 이동
            if(d[nx][ny] ==0 && arr[nx][ny] == 0) {
                d[nx][ny] = 1;
                x = nx;
                y = ny;
                cnt += 1;
                turn_time = 0;
                continue;
            }
            // 회전한 이후 정면에 가보지 않은 칸이 없거나 바다인 경우
            else turn_time +=1;

            // 네 방향 모두 갈 수 없는 경우
            if(turn_time == 4) {
                nx = x - dx[direction];
                nx = y - dy[direction];

                // 뒤로 갈 수 있다면 이동하기
                if(arr[nx][ny]==0) {
                    x = nx;
                    y = ny;
                    turn_time = 0;

                }
                // 뒤가 바다로 막혀있는 경우
                else {
                    break;
                }

            }
        }

    }
}
