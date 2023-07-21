package algorithm.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj3190 {

    static int MAP_OBJECT = 0;
    static int SNAKE = 1;

    static int APPLE = 2;

    static int[][] MAP;

    static Deque<Snake> deque;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        MAP = new int[N + 1][N + 1];
        int appleCount = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < appleCount; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            MAP[x][y] = APPLE;
        }
        Map<Integer, Character> changeDirections = new HashMap<>();
        int dirCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < dirCount; i++) {
            st = new StringTokenizer(br.readLine());
            changeDirections.put(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0));
        }
        MAP[1][1] = SNAKE;

        deque = new LinkedList<>();
        deque.addFirst(new Snake(1, 1, 'R'));
        for (int i = 0; i < 10_000; i++) {
            Snake current = deque.getFirst();
            int x = current.x;
            int y = current.y;
            char dir = current.dir;
            if (checkFail(dir, x, y) || i == 9_999) {
                System.out.println(i + 1);
                break;
            } else {
                moveForward(dir, x, y);
            }
            if (changeDirections.containsKey(i + 1)) {
                dir = changeDirections(dir, changeDirections.get(i + 1));
                deque.getFirst().dir = dir;
            }
        }

    }

    char changeDirections(char currentDirections, char headingTo) {
        char newDirections = 0;
        switch (headingTo) {
            case 'L':
                if (currentDirections == 'L') newDirections = 'D';
                else if (currentDirections == 'R') newDirections = 'U';
                else if (currentDirections == 'U') newDirections = 'L';
                else newDirections = 'R';
                break;
            case 'D':
                if (currentDirections == 'L') newDirections = 'U';
                else if (currentDirections == 'R') newDirections = 'D';
                else if (currentDirections == 'U') newDirections = 'R';
                else newDirections = 'L';
                break;
        }
        return newDirections;
    }

    boolean checkFail(char currentDirection, int X, int Y) {
        switch (currentDirection) {
            case 'U':
                if (X - 1 <= 0) return true;
                if (MAP[X-1][Y] == SNAKE) return true;
                break;
            case 'D':
                if (X + 1 >= MAP.length) return true;
                if (MAP[X+1][Y] == SNAKE) return true;
                break;
            case 'L':
                if (Y - 1 <= 0) return true;
                if (MAP[X][Y - 1] == SNAKE) return true;
                break;
            case 'R':
                if (Y + 1 >= MAP.length) return true;
                if (MAP[X][Y+1] == SNAKE) return true;
                break;
        }
        return false;
    }
    void moveForward(char currentDirection, int X, int Y) {
        int toX = X;
        int toY = Y;
        if (currentDirection == 'U') {
            toX -= 1;
            if (MAP[toX][Y] != APPLE) {
                Snake tail = deque.removeLast();
                MAP[tail.x][tail.y] = MAP_OBJECT;
            }
            MAP[toX][Y] = SNAKE;
        } else if (currentDirection == 'D') {
            toX += 1;
            if (MAP[toX][Y] != APPLE) {
                Snake tail = deque.removeLast();
                MAP[tail.x][tail.y] = MAP_OBJECT;
            }
            MAP[toX][Y] = SNAKE;
        } else if (currentDirection == 'L') {
            toY -= 1;
            if (MAP[X][toY] != APPLE) {
                Snake tail = deque.removeLast();
                MAP[tail.x][tail.y] = MAP_OBJECT;
            }
            MAP[X][toY] = SNAKE;
        } else if (currentDirection == 'R') {
            toY += 1;
            if (MAP[X][toY] != APPLE) {
                Snake tail = deque.removeLast();
                MAP[tail.x][tail.y] = MAP_OBJECT;
            }
            MAP[X][toY] = SNAKE;
        }
        deque.addFirst(new Snake(toX, toY, currentDirection));
    }

    static class Snake {
        int x;

        int y;

        char dir;

        Snake(int x, int y, char dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
    public static void main(String[] args) throws IOException {
        new boj3190().solution();
    }

}