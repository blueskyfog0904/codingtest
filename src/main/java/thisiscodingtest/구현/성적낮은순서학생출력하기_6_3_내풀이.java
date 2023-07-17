package thisiscodingtest.구현;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 성적낮은순서학생출력하기_6_3_내풀이 {


    public static void main(String[] args) {
        // 학생의 수 N을 입력 받음
        // 학생들을 넣을 arr List 생성, 이중 배열
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        String[] arrName = new String[n];
        int[] arrScore = new int[n];

        List<String> arr = new ArrayList<>();



        // N+1번째 줄부터 학생이름 공백 성적 입력 (학생 성적 100 이하의 자연수)
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            String[] strChange = str.split(" ");
            arrName[i] = strChange[0];
            arrScore[i] = Integer.parseInt(strChange[1]);
        }

        // 모든 학생의 이름이 성적 낮은 순서대로 출력, 성적 동일은 상관 없음
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (arrScore[j] < arrScore[j - 1]) {
                    int temp = arrScore[j];
                    arrScore[j] = arrScore[j - 1];
                    arrScore[j-1] = temp;

                    String tempS = arrName[j];
                    arrName[j] = arrName[j-1];
                    arrName[j-1] = tempS;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arrName[i]+" ");
        }

    }
}
