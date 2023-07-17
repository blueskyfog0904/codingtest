package thisiscodingtest.구현;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 상하좌우 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String planCha = "";
        List<String> plan = new ArrayList<>();

        while(true) {
            System.out.println("계획을 입력해주세요. 끝내시려면 end를 입력하세요.");
            planCha = sc.next();
            if(planCha.equals("end")) {
                break;
            }
            plan.add(planCha);
        }
        int x = 1;
        int y = 1;

        String[] move_types = {"L", "R", "U", "D"};

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        int nx = 0;
        int ny = 0;

        for(int i =0; i < plan.size(); i++) {
            for(int j=0; j < move_types.length; j++) {
                if (plan.get(i).equals(move_types[j])) {
                    nx = x + dx[j];
                    ny = y + dy[j];
                }
            }
            if (nx <1 || ny < 1 || nx > n || ny > n) {
                continue;
            }
            x = nx;
            y = ny;
        }
        System.out.println("x = " + nx);
        System.out.println("y = " + ny);




    }
}
