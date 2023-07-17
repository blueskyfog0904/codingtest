package thisiscodingtest.구현;

public class 퀵정렬 {

    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end) return;
        int pivot = start;
        int left = start + 1;
        int right = end;

        // 반복 left ++; right--; left가 피벗보다 값이 크면 스탑, right가 피벗보다 값이 작으면 스탑, arr[left]와 arr[right]값 교체
        // 만약 left와 right 가 교체되면 arr[right]와 arr[pivot] 값 교체

        while (left <= right) {
            while (left <= end && arr[left] <= arr[pivot]) left++;
            while (right > start && arr[right] >= arr[pivot]) right--;
            // left와 right 가 교체되었을 경우
            if(left > right) {
                int temp = arr[right];
                arr[right] = arr[pivot];
                arr[pivot] = temp;
            }
            // 교차되지 않은 경우
            else {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }

        }
        quickSort(arr, start, right-1);
        quickSort(arr, right+1, end);

    }

    public static void main(String[] args) {
        int n = 10;
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        quickSort(arr, 0, n - 1);

        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

    }

}
