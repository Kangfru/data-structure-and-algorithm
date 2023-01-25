package chap03;

import java.util.Scanner;

// 선형검색 (보초법)
public class SeqSearchSen {

    static int seqSearchSen(int[] a, int n, int key) {
        int i = 0;

        a[n] = key;

        while(true) {
            if (a[i] == key) {
                break;
            }
            i++;
        }
        return i == n ? -1 : i;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

//        System.out.print();
    }

}
