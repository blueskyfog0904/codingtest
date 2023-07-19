package thisiscodingtest.구현;

import java.util.Scanner;

public class 떡볶이떡만들기_7_3 {


    public static void main(String[] args) {

        // 떡의 개수 N과 고객이 요청한 떡의 길이 M을 입력 받는다
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];

        // 떡의 개별 높이 입력 받는다(떡의 개수 N만큼)
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 적어도 M만큼의 떡을 가져가기 위해 절단기에 설정할 수 있는 높이의 최대값을 출력한다.
        int start = 0;
        int end = (int) 1e9;
        int result = 0;
        // 이진 탐색 시작
        while (start <= end) {
            int mid = (start + end) / 2;
            long total = 0;
            for (int i = 0; i < n; i++) {
                // 떡 길이에서 중간값을 뺀 값이 0보다 클 경우만 total 길이에 더해준다
                if ((arr[i] - mid) > 0) {
                    total += (arr[i]-mid);
                }
            }
            if (total < m) {   // total 길이가 m보다 작을 경우 더 많이 자르기 (왼쪽부분 탐색)
                end = mid - 1;
            } else {  // 떡의 양이 충분하면 덜 자르기(오른쪽 부분 탐색)
                result = mid;  // 최대한 덜 잘랐을 때가 정답이므로, 여기에 result를 기록
                start = mid + 1;
            }
        }
        System.out.println("result = " + result);

    }
}
