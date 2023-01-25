package chap01;

public class Question10 {

    static int jari(int a) {
        int jarisu = 1;
        while (a >= 10) {
            a /= 10;
            jarisu++;
        }
        return jarisu;
    }

    public static void main(String[] args) {
        System.out.println(jari(10));
        System.out.println(jari(7));
        System.out.println(jari(1314));
        System.out.println(jari(201040293));
        System.out.println(jari(135));
    }

}
