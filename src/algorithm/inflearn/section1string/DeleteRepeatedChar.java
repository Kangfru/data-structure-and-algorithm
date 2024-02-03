package algorithm.inflearn.section1string;

import java.util.Map;
import java.util.Scanner;

public class DeleteRepeatedChar {

    public String solution(String target) {
        int[] flag = new int[32];
        char[] chars = target.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (char c : chars) {
            if (flag[c - 'a'] == 0) {
                sb.append(c);
                flag[c - 'a']++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String target = sc.nextLine();
        DeleteRepeatedChar d = new DeleteRepeatedChar();
        System.out.println(d.solution(target));
    }
}
