package algorithm.inflearn.section2array;

import java.io.*;
import java.util.StringTokenizer;

public class ReversePrimeNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (st.hasMoreTokens()) {
            StringBuilder current = new StringBuilder(st.nextToken());
            current.reverse();
            int number = Integer.parseInt(current.toString());
            if (isPrime(number)) {
                bw.write(number + " ");
            }
        }
        bw.flush();
        bw.close();
    }

    // 참고 int 숫자 뒤집는 법
    public int reverseNumber(int number) {
        int temp = number;
        int reverseNum = 0;
        while (temp > 0) {
            int t = temp % 10;
            reverseNum = reverseNum * 10 + t;
            temp /= 10;
        }
        return reverseNum;
    }

    public static boolean isPrime(int number) {
        if (number < 2) return false;
        for(int i = 2; i <= number/2; i++) {
            if(number % i == 0) {
                return false;
            }
        }
        return true;
    }

}
