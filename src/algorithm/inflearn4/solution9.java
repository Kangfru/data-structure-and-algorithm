package algorithm.inflearn4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * boj12891 - DNA 비밀번호
 * 슬라이딩 윈도우 O(N) 풀이
 */
public class solution9 {

    static int[] count = new int[4];  // A, C, G, T 카운트
    static int[] required = new int[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int fullLength = Integer.parseInt(st.nextToken());
        int passwordLength = Integer.parseInt(st.nextToken());

        String fullLine = br.readLine();
        st = new StringTokenizer(br.readLine());
        required[0] = Integer.parseInt(st.nextToken());  // A
        required[1] = Integer.parseInt(st.nextToken());  // C
        required[2] = Integer.parseInt(st.nextToken());  // G
        required[3] = Integer.parseInt(st.nextToken());  // T

        int answer = 0;

        for (int i = 0; i < fullLength; i++) {
            addChar(fullLine.charAt(i));

            if (i >= passwordLength) {
                removeChar(fullLine.charAt(i - passwordLength));
            }

            if (i >= passwordLength - 1 && isValid()) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    static void addChar(char c) {
        if (c == 'A') count[0]++;
        else if (c == 'C') count[1]++;
        else if (c == 'G') count[2]++;
        else if (c == 'T') count[3]++;
    }

    static void removeChar(char c) {
        if (c == 'A') count[0]--;
        else if (c == 'C') count[1]--;
        else if (c == 'G') count[2]--;
        else if (c == 'T') count[3]--;
    }

    static boolean isValid() {
        return count[0] >= required[0]
                && count[1] >= required[1]
                && count[2] >= required[2]
                && count[3] >= required[3];
    }
}