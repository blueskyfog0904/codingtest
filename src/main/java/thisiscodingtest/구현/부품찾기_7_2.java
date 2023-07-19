package thisiscodingtest.구현;

import java.util.Scanner;

public class 부품찾기_7_2 {

    static int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // 가게 부품의 개수 int n을 입력 받는다
        int n = sc.nextInt();
        int[] arrA = new int[n];

        // 가게 부품의 번호 n개를 배열로 입력 받는다
        for (int i = 0; i < n; i++) {
            arrA[i] = sc.nextInt();
        }

        // 손님이 요청한 부품의 개수 int m을 입력 받는다
        int m = sc.nextInt();
        int[] arrB = new int[m];
        // 손님이 요청한 부품의 번호 m개를 배열로 입력 받는다
        for (int i = 0; i < m; i++) {
            arrB[i] = sc.nextInt();
        }

        // 가게의 부품을 오름차순으로 정렬한다.
        for (int i = 1; i < arrA.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arrA[j] < arrA[j - 1]) {
                    int temp = arrA[j];
                    arrA[j] = arrA[j - 1];
                    arrA[j - 1] = temp;
                }
            }
        }

        // 손님의 부품 번호를 한 개씩 가게의 부품에서 찾는다(이진 탐색 사용)
        // 있을경우 yes 출력, 없으면 no 출력한다.
        for (int i = 0; i < arrB.length; i++) {
            int result = binarySearch(arrA, arrB[i], 0, n - 1);
            if (result == -1) {
                System.out.print("No ");
            } else {
                System.out.print("Yes ");
            }

        }




    }

}
