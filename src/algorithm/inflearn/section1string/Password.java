package algorithm.inflearn.section1string;

import java.util.Scanner;

public class Password {

    public String solution(int wordCount , String cipher) {
        if (cipher.length() / 7 != wordCount) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < wordCount; i++) {
            String current = cipher.substring(i * 7, i * 7 + 7);
            int decimal = 0;
            for (int j = 0; j < current.length(); j++) {
                if (current.charAt(j) == '#') {
                    if (j == current.length() - 1) {
                        decimal++;
                    } else {
                        decimal += (int) Math.pow(2, current.length() - 1 - j);
                    }
                }
            }
            sb.append((char) decimal);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int wordCount = Integer.parseInt(sc.nextLine());
        String cipher = sc.nextLine();
        Password p = new Password();
        System.out.println(p.solution(wordCount, cipher));
    }

}
