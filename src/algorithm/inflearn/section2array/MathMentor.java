package algorithm.inflearn.section2array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MathMentor {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int students = Integer.parseInt(st.nextToken());
        int exams = Integer.parseInt(st.nextToken());
        int[][] examResults = new int[exams][students];
        for (int i = 0; i < exams; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < students; j++) {
                examResults[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 0;
        for(int i = 1; i <= students; i++){ // i학생
            for(int j = 1; j <= students; j++){ // j학생
                int cnt = 0;
                for(int k = 0; k < exams; k++){ // 시험 횟수
                    int pi = 0, pj = 0;
                    for(int s=0; s < students; s++){ // 학생의 수
                        if(examResults[k][s] == i) pi = s;
                        if(examResults[k][s] == j) pj = s;
                    }
                    if(pi < pj) cnt++;
                }

                if(cnt == exams){
                    answer++;
                }
            }
        }

        System.out.println(answer);


    }

}
