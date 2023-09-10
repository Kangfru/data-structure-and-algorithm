package algorithm.programmers;

// 프로그래머스 광물 캐기
public class Mining {

    public int solution(int[] picks, String[] minerals) {
        int diamondPick = picks[0];
        int ironPick = picks[1];
        int stonePick = picks[2];
        int time = 0;
        int miningCounts = 0;
        for (String mineral : minerals) {
            if (diamondPick > 0) {
                time += 1;
                miningCounts += 1;
                if (miningCounts == 5) {
                    diamondPick--;
                    miningCounts = 0;
                }
            } else if (ironPick > 0) {
                if (mineral.equals("diamond")) {
                    time += 5;
                } else {
                    time += 1;
                }
                miningCounts++;
                if (miningCounts == 5) {
                    ironPick--;
                    miningCounts = 0;
                }
            } else if (stonePick > 0) {
                if (mineral.equals("diamond")) {
                    time += 25;
                } else if (mineral.equals("iron")) {
                    time += 5;
                } else {
                    time += 1;
                }
                miningCounts++;
                if (miningCounts == 5) {
                    stonePick--;
                    miningCounts = 0;
                }
            }
        }
        return time;
    }


    public static void main(String[] args) {
        System.out.println(new Mining().solution(new int[]{1, 1, 0}, new String[]{"stone", "stone", "iron", "stone", "diamond", "diamond", "diamond", "diamond", "diamond", "diamond"}));
    }

}
