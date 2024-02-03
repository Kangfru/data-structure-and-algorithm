package algorithm.inflearn.section1string;

import java.util.Scanner;

public class FindString {

    public int solution(String str, char t) {
        int answer = 0;
        str = str.toUpperCase();
        t = Character.toUpperCase(t);
        for (char s : str.toCharArray()) {
            if (s == t) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        FindString T = new FindString();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char c = sc.next().charAt(0);
        System.out.print(T.solution(str, c));
    }
}

