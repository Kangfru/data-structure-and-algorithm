package algorithm.inflearn.section1string;

import java.util.Scanner;

public class ShortestCharacterDistance {

    public void solution(String target, char t) {
        int[] distances = new int[target.length()];
        char[] chars = target.toCharArray();
        for (int i = 0; i < target.length(); i++) {
            int min = Integer.MAX_VALUE;
            int min2 = Integer.MAX_VALUE;
            for (int j = i; j >= 0; j--) {
                if (chars[j] == t) {
                    min = i - j;
                    break;
                }
            }
            for (int j = i; j < target.length(); j++) {
                if (chars[j] == t) {
                    min2 = j - i;
                    break;
                }
            }
            distances[i] = Integer.min(min, min2);
        }
        for (int i : distances) {
            System.out.print(i + " ");
        }
    }

    public void solution2(String target, char t) {
        int[] distances = new int[target.length()];
        int p = 1000;
        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i) == t) {
                p = 0;
                distances[i] = p;
            } else {
                distances[i] = ++p;
            }
        }
        p = 1000;
        for (int i = target.length() - 1; i >= 0; i--) {
            if (target.charAt(i) == t) {
                p = 0;
            } else {
                p++;
                distances[i] = Math.min(p, distances[i]);
            }
        }
        for (int i : distances) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String target = input.split(" ")[0];
        char t = input.split(" ")[1].charAt(0);
        ShortestCharacterDistance s = new ShortestCharacterDistance();
        s.solution2(target, t);
    }

}
