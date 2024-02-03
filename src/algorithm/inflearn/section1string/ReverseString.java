package algorithm.inflearn.section1string;

import java.util.Scanner;

public class ReverseString {

    public String reverseString(String target) {
        int length = target.length();

        StringBuffer sb = new StringBuffer();
        for (int i = length - 1; i >= 0; i--) {
            if (i > 0) {
                sb.append(target.substring(i, i+1));
            } else {
                sb.append(target.substring(0, 1));
            }

        }
        return sb.toString();
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int size = Integer.parseInt(in.nextLine());
        ReverseString a = new ReverseString();
        for (int i = 0; i < size; i++) {
            System.out.println(a.reverseString(in.nextLine()));
        }
        return ;
    }
}
