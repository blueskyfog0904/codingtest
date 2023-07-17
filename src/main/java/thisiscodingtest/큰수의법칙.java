package thisiscodingtest;

public class 큰수의법칙 {
    public static void main(String[] args) {
        int N = 5;
        int M = 8;
        int K = 3;
        int[] numList = {2,4,5,4,6};


        int temp =0;

        for (int i=0; i< numList.length; i++) {
            for (int j=i+1; j < numList.length; j++) {
                if(numList[i] > numList[j]) {
                    temp = numList[i];
                    numList[i] = numList[j];
                    numList[j] = temp;
                }
            }
        }
        int first = numList[N-1];
        int second = numList[N-2];


        int result = 0;
        int restrict = K;

        while(M>0) {
            if(restrict>0) {
                result += first;
                M--;
                restrict--;
                System.out.println(result);
            }
            else if (restrict==0) {
                result += second;
                M--;
                restrict=K;
                System.out.println(result);
            }
        }

        System.out.println("큰수는?" + result);

    }
}
