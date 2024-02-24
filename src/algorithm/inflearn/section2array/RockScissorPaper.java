package algorithm.inflearn.section2array;

    import java.io.*;
    import java.util.StringTokenizer;

public class RockScissorPaper {

    enum GameOption {
        SCISSORS, ROCK, PAPER;

        public static GameOption fromInt(int n) {
            return values()[n - 1];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int gameCount = Integer.parseInt(br.readLine());

        GameOption[] a = readGameInput(br, gameCount);
        GameOption[] b = readGameInput(br, gameCount);

        for (int i = 0; i < gameCount; i++) {
            bw.write(judgeGame(a[i], b[i]) + '\n');
        }

        bw.flush();
        bw.close();
    }

    private static GameOption[] readGameInput(BufferedReader br, int gameCount) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        GameOption[] options = new GameOption[gameCount];
        for (int i = 0; i < gameCount; i++) {
            options[i] = GameOption.fromInt(Integer.parseInt(st.nextToken()));
        }
        return options;
    }

    public static String judgeGame(GameOption a, GameOption b) {
        if (a == b) return "D";
        if (a == GameOption.PAPER && b == GameOption.SCISSORS) return "B";
        if (a == GameOption.SCISSORS && b == GameOption.PAPER) return "A";
        if (a.ordinal() > b.ordinal()) return "A";
        return "B";
    }

}
