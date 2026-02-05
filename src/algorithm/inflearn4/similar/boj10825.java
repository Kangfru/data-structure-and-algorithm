package algorithm.inflearn4.similar;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class boj10825 {
    public static void main(String[] args) throws Exception {
        // 이름 국여 엉어 수학
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            students.add(new Student(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        students.sort(
                Comparator.comparingInt((Student s) -> -s.korean)
                        .thenComparingInt(s -> s.english)
                        .thenComparingInt(s -> -s.math)
                        .thenComparing(s -> s.name)
        );
        for (Student s : students) {
            bw.write(s.name);
            bw.newLine();
        }
        bw.flush();
    }

    static class Student {
        String name;
        int korean;
        int english;
        int math;

        public Student(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }
    }
}

