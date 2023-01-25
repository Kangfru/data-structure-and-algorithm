package chap03;

import java.util.Arrays;
import java.util.Scanner;

// 이진 검색
// 이미 배열 내의 데이터가 정렬되어있을 때.
public class BinSearch {

    static int binSearch(int[] a, int n, int key) {
        // 시작 인덱스
        int pl = 0;
        // 끝 인덱스
        int pr = n - 1;

        do {
            // 중간 인덱스 계산
            int pc = (pl + pr) / 2;
            if (a[pc] == key) {
                // 검색 성공
                return pc;
            } else if (a[pc] < key) {
                // 검색 범위를 뒤 쪽 절반으로 좁힘
                pl = pc + 1;
            } else {
                // 검색 범위를 앞 쪽 절반으로 좁힘
                pr = pc - 1;
            }
        } while (pl <= pr); // 더 이상 검색할 범위가 없을 시 종료
        // 검색 종료
        return -1;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int num = stdIn.nextInt();
        int x[] = new int[num];

        System.out.print("x[0] : ");
        x[0] = stdIn.nextInt();
        for (int i = 1; i < num; i++) {
            do {
                System.out.print("x[" + i + "] : ");
                x[i] = stdIn.nextInt();
            } while (x[i] < x[i - 1]);
        }
        System.out.print("검색할 값 : ");
        int ky = stdIn.nextInt();

//        int idx = binSearch(x, num, ky);
        // Arrays.binarySearch 사용 가능
        int idx = Arrays.binarySearch(x, ky);

        if (idx == -1)
            System.out.println("검색 실패");
        else
            System.out.println(ky + "의 인덱스 : " + idx);
    }

}
