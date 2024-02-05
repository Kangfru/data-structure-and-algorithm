package algorithm.inflearn.section1string;

import java.util.Scanner;

public class ValidPalindrome {

    public boolean solution(String target) {
        String temp = target.toLowerCase().replaceAll("[^a-z]", "");
        System.out.println(temp);
        int len = temp.length();
        for (int i = 0; i < len / 2; i++) {
            if (temp.charAt(i) != temp.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String target = sc.nextLine();
        ValidPalindrome v = new ValidPalindrome();
        if (v.solution(target)) {
            System.out.print("YES");
        } else {
            System.out.print("NO");
        }
    }

}
