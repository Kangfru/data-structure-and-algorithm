package algorithm.inflearn2.section8graph;

import java.util.*;

public class ShortestMap {

    class Node {
        int y;
        int x;
        int depth;
        public Node(int y, int x, int depth) {
            this.y = y;
            this.x = x;
            this.depth = depth;
        }
    }

    public int solution(int[][] maps) {
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        PriorityQueue<Integer> possibleDepths = new PriorityQueue<>();

        Stack<Node> stack = new Stack<>();
        stack.push(new Node(0, 0, 1));

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            for (int i = 0; i < 4; i++) {
                int newY = current.y + dy[i];
                int newX = current.x + dx[i];
                if (newY >= 0 && newY <= maps.length - 1 && newX >= 0 && newX <= maps[0].length - 1 && maps[newY][newX] == 1) {
                    if (visited[newY][newX]) continue;
                    visited[newY][newX] = true;
                    stack.push(new Node(newY, newX, current.depth + 1));
                    if (newY == maps.length - 1 && newX == maps[0].length - 1) {
                        possibleDepths.offer(current.depth + 1);
                    }
                }
            }
        }

        if (possibleDepths.isEmpty()) return -1;
        return possibleDepths.poll();
    }

    public int solution2(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 1));  // 시작점 (0,0)에서 depth 1로 시작
        visited[0][0] = true;

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.y == n -1 && current.x == m - 1) return current.depth;
            for (int i = 0; i < 4; i++) {
                int newY = current.y + dy[i];
                int newX = current.x + dx[i];

                if (newY >= 0 && newY < n && newX >= 0 && newX < m && maps[newY][newX] == 1 && !visited[newY][newX]) {
                    visited[newY][newX] = true;
                    queue.add(new Node(newY, newX, current.depth + 1));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new ShortestMap().solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}}));
    }

}
