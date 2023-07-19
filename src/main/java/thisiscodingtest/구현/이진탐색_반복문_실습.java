package thisiscodingtest.구현;

import java.util.Scanner;

public class 이진탐색_반복문_실습 {

    static int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                end = mid-1;
            } else {
                start = mid + 1;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        int target = sc.nextInt();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = binarySearch(arr, target, 0, n - 1);
        if (result == -1) {
            System.out.println("찾고자 하는 원소가 없습니다.");
        } else {
            System.out.println(result + 1);
        }


    }
}
