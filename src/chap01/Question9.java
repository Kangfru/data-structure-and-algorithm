package chap01;

public class Question9 {
    static int sumof(int a, int b) {
        int min; // a, b의 작은 쪽의 값
        int max; // a, b의 큰 쪽의 값

        if (a < b) {
            min = a;
            max = b;
        } else {
            min = b;
            max = a;
        }

        int sum = 0; // 합
        for (int i = min; i <= max; i++)
            sum += i;
        return (sum);
    }


    public static void main(String[] args) {
        System.out.println(sumof(2, 5));
    }

}
