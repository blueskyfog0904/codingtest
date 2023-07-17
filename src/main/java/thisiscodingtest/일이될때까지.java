package thisiscodingtest;

import java.util.Scanner;

public class 일이될때까지 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int cnt = 0;
        while(true) {
            cnt++;
            if(n%k==0) {
                n = n/k;
            } else {
                n = n-1;
            }
            if (n==1) {
                break;
            }

        }
        System.out.println("실행횟수 = " + cnt);

    }
}
