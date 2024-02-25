package algorithm.inflearn.section5stackqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class EmergencyRoom {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int patientCount = Integer.parseInt(st.nextToken());
        int targetPatient = Integer.parseInt(st.nextToken());
//        Queue<PatientInformation> queue = new LinkedList<>();
//        st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < patientCount; i++) {
//            int risk = Integer.parseInt(st.nextToken());
//            queue.offer(new PatientInformation(i, risk));
//        }
//
//        // 진료 시작
//        // 환자가 접수 한 순서대로 꺼내고
//        // 나머지 대기 목록에 위험도가 높은 환자가 존재하면 제일 뒤로
//        int count = 0;
//        while (!queue.isEmpty()) {
//            PatientInformation current = queue.peek();
//            if (queue.stream().anyMatch(remain -> remain.getRisk() > current.getRisk())) {
//                queue.poll();
//                queue.offer(current);
//            } else {
//                queue.poll();
//                count++;
//                if (current.index == targetPatient) {
//                    break;
//                }
//            }
//        }
        // priority queue를 이용
        PriorityQueue<PatientInformation> pq = new PriorityQueue<>((a, b) -> b.getRisk() - a.getRisk());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < patientCount; i++) {
            pq.offer(new PatientInformation(i, Integer.parseInt(st.nextToken())));
        }
        int count = 0;
        while (true) {
            PatientInformation current = pq.poll();
            count++;
            if (current.index == targetPatient) {
                break;
            }
        }
        System.out.println(count);
    }

    public static class PatientInformation {

        public PatientInformation(int index, int risk) {
            this.index = index;
            this.risk = risk;
        }

        private final int index;

        private final int risk;

        public int getIndex() {
            return index;
        }

        public int getRisk() {
            return risk;
        }
    }

}
