package chap01;

public class Question2 {

    static int min3(int a, int b, int c) {
        int min = c;
        if (b < min) min = b;
        if (a < min) min = a;
        return min;
    }

    public static void main(String[] args) {

    }
}
