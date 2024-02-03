package algorithm.inflearn.section1string;

import java.util.Scanner;

public class FindWord {

    public String solution(String input) {
        String answer = "";
        int max = Integer.MIN_VALUE;
        String[] words = input.split(" ");
        for (String word : words) {
            if (word.length() > max) {
                max = word.length();
                answer = word;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        FindWord a = new FindWord();
        Scanner sc = new Scanner(System.in);
        System.out.print(a.solution(sc.nextLine()));
    }
}
