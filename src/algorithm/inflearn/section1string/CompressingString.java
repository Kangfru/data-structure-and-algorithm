package algorithm.inflearn.section1string;

import java.util.Scanner;

public class CompressingString {

    public String solution(String target) {
        StringBuilder sb = new StringBuilder();
        String temp =  target + " ";
        int count = 1;
        for (int i = 0; i < temp.length() - 1; i++) {
            if (temp.charAt(i) == temp.charAt(i + 1)) {
                count++;
            } else {
                sb.append(temp.charAt(i));
                if (count > 1) {
                    sb.append(count);
                }
                count = 1;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String target = sc.nextLine();
        CompressingString c = new CompressingString();
        System.out.println(c.solution(target));
    }

}
