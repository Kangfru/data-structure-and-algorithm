package algorithm.inflearn.section1string;

import java.util.Scanner;

public class ExtractOnlyNumber {

    public int solution(String target) {
        StringBuilder sb = new StringBuilder();
        for (char c : target.toCharArray()) {
            if (c >= '0' && c <= '9') {
                sb.append(c);
            }
        }

        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String q = sc.nextLine();
        ExtractOnlyNumber e = new ExtractOnlyNumber();
        System.out.println(e.solution(q));
    }

}
