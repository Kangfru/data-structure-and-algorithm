package structure.chap05;

// 재귀 함수 이해
public class Recur {

    static void recur(int n) {
        if (n > 0) {
            recur(n - 1);
            System.out.println(n);
            recur(n - 2);
        }
    }

}
