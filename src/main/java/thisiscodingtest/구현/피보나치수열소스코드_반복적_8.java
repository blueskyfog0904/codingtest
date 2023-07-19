package thisiscodingtest.구현;

public class 피보나치수열소스코드_반복적_8 {

    public static long[] d = new long[100];

    public static void main(String[] args) {
        // 첫 번째 피보나치 수와 두번 째 피보나치 수는 1
        d[1] = 1;
        d[2] = 1;
        int n = 50; // 50번째 피보나치 수를 계산

        // 피보나치 함수(Fibonacci Function) 반복문으로 구현(보텀업 다이나믹 프로그램)
        for (int i = 3; i <= n; i++) {
            d[i] = d[i - 1] + d[i - 2];
        }
        System.out.println("d[n] = " + d[n]);

    }
}
