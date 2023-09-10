package algorithm.programmers;

    import java.util.*;

// 프로그래머스 과제 진행하기
public class Homework {

    public List<String> solution(String[][] plans) {
        List<String> answer = new ArrayList<>();

        PriorityQueue<Work> pq = new PriorityQueue<>();
        for(String[] p:plans){
            pq.add(new Work(p[0], Integer.parseInt(p[1].split(":")[0]), Integer.parseInt(p[1].split(":")[1]), Integer.parseInt(p[2])));
        }

        Stack<Work> stack = new Stack<>(); // 멈춘 과제들이 들어갈 곳
        while (!pq.isEmpty()) {
            Work current = pq.poll();
            String curName = current.name;
            int curStart = current.start;
            int curPlaytime = current.playTime;

            // 현재 시각
            int currentTime = curStart;
            if (!pq.isEmpty()) {
                // 과제가 남아 있는 경우 스타트 타임 비교
                Work next = pq.peek();
                if(currentTime + curPlaytime < next.start) {
                    answer.add(curName);
                    currentTime += curPlaytime;

                    while(!stack.isEmpty()) {
                        Work remain = stack.pop();
                        if(currentTime + remain.playTime <= next.start) {
                            currentTime += remain.playTime;
                            answer.add(remain.name);
                            continue;
                        } else {
                            int t = remain.playTime - (next.start - currentTime);
                            // 추가로 한 시간만 빼서 멈춘 과제 목록에 다시 추가
                            stack.push(new Work(remain.name, t));
                            break;
                        }
                    }
                } else if(curStart + curPlaytime == next.start) {
                    answer.add(curName);
                    continue;
                } else {
                    int t = (next.start - currentTime);
                    stack.push(new Work(curName, curPlaytime - t));
                }
            } // 더 이상 남아있는 새로운 과제가 없는 경우
            else {
                // 남아있는 과제(잠시 멈춘 과제)도 없는 경우
                if(stack.isEmpty()) {
                    currentTime += curPlaytime;
                    answer.add(curName);
                }
                // 남아있는 과제는 있는 경우
                else {
                    answer.add(curName); // 새로운 과제부터 먼저 해결

                    // 남아있는 과제들을 정해진 순서대로 끝내면 됨
                    while(!stack.isEmpty()) {
                        Work rem = stack.pop();
                        answer.add(rem.name);
                    }
                }
            }
        }

        return answer;
    }

    public static class Work implements Comparable<Work> {
        String name;

        int start;

        int playTime;

        public Work(String name, int hour, int minute, int playTime) {
            this.name = name;
            this.start = hour * 60 + minute;
            this.playTime = playTime;
        }

        public Work(String name, int playTime) {
            this.name = name;
            this.playTime = playTime;
        }

        @Override
        public int compareTo(Work o) {
            return this.start - o.start;
        }
    }

}
