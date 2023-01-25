package chap01;

public class Question8 {

    static int gaus(int a) {
        return ((1 + a) * (a / 2)) + ((a % 2 == 1) ? (a + 1) / 2 : 0);
    }

    public static void main(String[] args) {
        System.out.println(gaus(9));
    }

}
