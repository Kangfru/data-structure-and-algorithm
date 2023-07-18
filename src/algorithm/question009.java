package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// boj 12891
public class question009 {

//    int[] pattern;
//    int[] checked;
//    int check;
//    private void solution() throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int dnaLength = Integer.parseInt(st.nextToken());
//        int passwordLength = Integer.parseInt(st.nextToken());
//        char[] randomDna = br.readLine().toCharArray();
//        st = new StringTokenizer(br.readLine());
//
//        // 전역 변수 초기화
//        pattern = new int[4];
//        checked = new int[4];
//        check = 0;
//
//        for (int i = 0; i < 4; i++) {
//            pattern[i] = Integer.parseInt(st.nextToken());
//            if (pattern[i] == 0) {
//                check++;
//            }
//        }
//        int result = 0;
////        if (check == 4) result++;
//        for (int i = 0; i < passwordLength; i++) {
//            // add
//            add(randomDna[i]);
//        }
//        if (check == 4) result++;
//        for (int i = passwordLength; i < dnaLength; i++) {
//            int j = i - passwordLength;
//            add(randomDna[i]);
//            remove(randomDna[j]);
//            if (check == 4) result++;
//        }
//
//        System.out.println(result);
//        br.close();
//    }
//
//    private void add(char target) {
//        if (target == 'A') {
//            checked[0]++;
//            if (pattern[0] == checked[0]) {
//                check++;
//            }
//        } else if (target == 'C') {
//            checked[1]++;
//            if (pattern[1] == checked[1]) {
//                check++;
//            }
//        } else if (target == 'G') {
//            checked[2]++;
//            if (pattern[2] == checked[2]) {
//                check++;
//            }
//        } else if (target == 'T') {
//            checked[3]++;
//            if (pattern[3] == checked[3]) {
//                check++;
//            }
//        }
//    }
//
//    private void remove(char target) {
//        if (target == 'A') {
//            if (pattern[0] == checked[0]) {
//                check--;
//            }
//            checked[0]--;
//        } else if (target == 'C') {
//            if (pattern[1] == checked[1]) {
//                check--;
//            }
//            checked[1]--;
//        } else if (target == 'G') {
//            if (pattern[2] == checked[2]) {
//                check--;
//            }
//            checked[2]--;
//        } else if (target == 'T') {
//            if (pattern[3] == checked[3]) {
//                check--;
//            }
//            checked[3]--;
//        }
//    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int dnaLength = Integer.parseInt(st.nextToken());
        int passwordLength = Integer.parseInt(st.nextToken());
        String randomDna = br.readLine();
        st = new StringTokenizer(br.readLine());
        int[] checkArray = new int[128];
        int A = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int result = 0;
        for (int i = 0; i < passwordLength; i++) {
            if (randomDna.charAt(i) == 'A') checkArray['A']++;
            if (randomDna.charAt(i) == 'C') checkArray['C']++;
            if (randomDna.charAt(i) == 'G') checkArray['G']++;
            if (randomDna.charAt(i) == 'T') checkArray['T']++;
        }
        if (checkArray['A'] >= A && checkArray['C'] >= C && checkArray['G'] >= G && checkArray['T'] >= T) {
            result++;
        }

        for (int i = passwordLength; i < dnaLength; i++) {
            checkArray[randomDna.charAt(i)]++;
            checkArray[randomDna.charAt(i - passwordLength)]--;
            if (checkArray['A'] >= A && checkArray['C'] >= C && checkArray['G'] >= G && checkArray['T'] >= T) {
                result++;
            }
        }

        System.out.println(result);
        br.close();
    }

    public static void main(String[] args) throws IOException {
        new question009().solution();
    }

}
