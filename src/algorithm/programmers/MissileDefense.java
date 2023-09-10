package algorithm.programmers;

import java.util.Arrays;
import java.util.Comparator;

// 프로그래머스 요격 시스템
public class MissileDefense {

    public int solution(int[][] targets) {
        int answer = 0;
        // nlogn 으로 앞부분 기준 정렬
        Arrays.sort(targets, Comparator.comparingInt(o -> o[1]));

        // 앞 부분 cnt ++ 앞 부분이 뒷 부분의
        int missile = -1;
        for(int[] target : targets){
            if(missile == -1){
                answer++;
                missile = target[1];
            }

            if(target[0] < missile && target[1] >= missile) continue;

            answer++;
            missile = target[1];
        }


        return answer;
    }

    public static void main(String[] args) {

    }

}
