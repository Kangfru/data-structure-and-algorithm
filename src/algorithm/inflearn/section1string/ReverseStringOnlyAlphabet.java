package algorithm.inflearn.section1string;

import java.util.Scanner;

public class ReverseStringOnlyAlphabet {

    public String reverseStringOnlyAlphabet(String target) {
        int start = 0;
        int end = target.length() - 1;
        char[] chars = target.toCharArray();
        while (start < end) {
            if (!Character.isAlphabetic(chars[start])) {
                start++;
            } else if (!Character.isAlphabetic(chars[end])) {
                end--;
            } else {
                char temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;
                start++;
                end--;
            }
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        ReverseStringOnlyAlphabet r = new ReverseStringOnlyAlphabet();
        System.out.println(r.reverseStringOnlyAlphabet(str));
    }
}
