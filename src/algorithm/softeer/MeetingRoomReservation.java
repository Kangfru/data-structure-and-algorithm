package algorithm.softeer;

import java.io.*;
import java.util.*;

public class MeetingRoomReservation {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int roomCount = Integer.parseInt(input[0]); // 방의 개수
        int meetingCount = Integer.parseInt(input[1]); // 회의의 개수
        List<String> rooms = new ArrayList<>();
        Map<String, boolean[]> meetingReservation = new HashMap<>();
        for (int i = 0; i < roomCount; i++) {
            String room = br.readLine();
            rooms.add(room);
            meetingReservation.put(room, new boolean[19]);
        }
        rooms.sort(String::compareTo);
        for (int i = 0; i < meetingCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            boolean[] availableTimes = meetingReservation.get(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            for (int j = start; j <= end; j++) {
                availableTimes[j] = true;
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < rooms.size(); i++) {
            String room = rooms.get(i);
            bw.write("Room " + room + ":\n");
            boolean[] availableTimes = meetingReservation.get(room);
            List<int[]> emptyTimes = new ArrayList<>();
            int start = 0, end = 0;
            for (int j = 9; j <= availableTimes.length - 1; j++) {
                if (!availableTimes[j] && (j == 9 || availableTimes[j - 1])) {
                    if (j == 9) start = 9;
                    else start = j - 1;
                }
                if (!availableTimes[j] && (j == availableTimes.length - 1 || availableTimes[j + 1])) {
                    if (j == availableTimes.length -1 ) end = 18;
                    else end = j + 1;
                    emptyTimes.add(new int[]{start, end});
                }
            }
            if (emptyTimes.isEmpty()) {
                bw.write("Not available\n");
            } else {
                bw.write(emptyTimes.size() + " available:\n");
                for (int[] time : emptyTimes) {
                    bw.write(String.format("%02d-%02d\n", time[0], time[1]));
                }
            }
            if (i != rooms.size()-1) {
                bw.write("-----\n");
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
