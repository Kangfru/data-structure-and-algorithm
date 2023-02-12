package structure.chap02;

public class IntArray {

    static void rcopy(int[] a, int[] b) {
        // b의 모든 요소를 a에 역순으로
        if (a.length != b.length) {
            System.out.println("두 배열의 길이가 다릅니다.");
            return;
        }
        int temp;
        for (int i = 0; i < a.length; i++) {
            a[i] = b[a.length - i - 1];
        }
    }
    public static void main(String[] args) {
        int[] b = new int[5];
        b[1] = 37;
        b[2] = 51;
        b[4] = b[1] * 2;
        int[] a = new int[5];
        rcopy(a, b);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
        System.out.println();
        for (int i = 0; i < a.length; i++) {
            System.out.print(b[i]);
        }
    }

}
