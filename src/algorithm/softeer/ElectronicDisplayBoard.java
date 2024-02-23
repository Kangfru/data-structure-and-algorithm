package algorithm.softeer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class ElectronicDisplayBoard {

    public static void main(String[] args) throws Exception {
        Map<Character, String> lights = getLightsMap();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCaseCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCaseCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String before = String.format("%5s", st.nextToken());
            String after = String.format("%5s", st.nextToken());
            int count = 0;
            for (int j = 0; j < 5; j++) {
                count += calculateDiff(lights.get(before.charAt(j)), lights.get(after.charAt(j)));
            }
            bw.write(count + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }

    private static Map<Character, String> getLightsMap() {
        Map<Character, String> lights = new HashMap<>();
        //전광판 중 하나의 전구를 기준으로 켜짐은 1로, 꺼짐은 0으로 표시한다
        lights.put('0', "1110111");
        lights.put('1', "0010010");
        lights.put('2', "1011101");
        lights.put('3', "1011011");
        lights.put('4', "0111010");
        lights.put('5', "1101011");
        lights.put('6', "1101111");
        lights.put('7', "1110010");
        lights.put('8', "1111111");
        lights.put('9', "1111011");
        lights.put(' ', "0000000"); //아무것도 켜져있지 않은 상태
        return lights;
    }

    private static int calculateDiff(String before, String after) {
        int diff = 0;
        for (int i = 0; i < before.length(); i++) {
            if (before.charAt(i) != after.charAt(i)) {
                diff++;
            }
        }
        return diff;
    }
}
