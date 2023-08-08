package algorithm.book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

// boj 1377
public class question016 {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Node[] arr = new Node[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Node(Integer.parseInt(br.readLine()), i);
        }
        Arrays.sort(arr, Comparator.comparingInt(o -> o.value));
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (max < arr[i].index - i) {
                max = arr[i].index - i;
            }
        }
        System.out.println(max + 1);
    }
    public static void main(String[] args) throws IOException {
        new question016().solution();
    }

}

class Node {
    int value;
    int index;

    public Node(int value, int index) {
        this.value = value;
        this.index = index;
    }

}