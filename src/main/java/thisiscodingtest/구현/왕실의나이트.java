package thisiscodingtest.구현;

import java.util.Scanner;

public class 왕실의나이트 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 현재 나이트의 위치값을 입력받는다
        String place = sc.next();

        int x=0;
        int y;

        System.out.println(place.substring(0,1));
        System.out.println(place.substring(1));
        y = Integer.parseInt(place.substring(1));

        // substring을 이용하여 앞에 알파벳을 숫자로 바꾼다
        switch (place.substring(0,1)) {
            case "a":
                x=1;
                break;
            case "b":
                x=2;
                break;
            case "c":
                x=3;
                break;
            case "d":
                x=4;
                break;
            case "e":
                x=5;
                break;
            case "f":
                x=6;
                break;
            case "g":
                x=7;
                break;
            case "h":
                x=8;
                break;
        }
        System.out.println("x = " + x);
        System.out.println("y = " + y);

        // 모든 방향 갈수 있는 경우의 수는 8
        int met = 8;

        // 못 가는 방향일 경우 경우의 수를 차감한다
        if ((x+2) > 8) met -= 2;
        if ((x-2) < 1 ) met -=2;
        if ((x>0) && (x<8) && (y+1 >8)) met -=1;
        if ((x>0) && (x<8) && (y-1 <1)) met -=1;
        if ((y+2) > 8) met -= 2;
        if ((y-2) < 1 ) met -=2;
        if ((y>0) && (y<8) && (x+1 >8)) met -=1;
        if ((y>0) && (y<8) && (x-1 <1)) met -=1;

        // 결과값 출력
        System.out.println("결과값은 : " +met );


    }
}
