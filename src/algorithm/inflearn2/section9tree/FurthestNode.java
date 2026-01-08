package algorithm.inflearn2.section9tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FurthestNode {

    //n개의 노드가 있는 그래프가 있습니다. 각 노드는 1부터 n까지 번호가 적혀있습니다. 1번 노드에서 가장 멀리 떨어진 노드의 갯수를 구하려고 합니다. 가장 멀리 떨어진 노드란 최단경로로 이동했을 때 간선의 개수가 가장 많은 노드들을 의미합니다.
    //
    //노드의 개수 n, 간선에 대한 정보가 담긴 2차원 배열 vertex가 매개변수로 주어질 때, 1번 노드로부터 가장 멀리 떨어진 노드가 몇 개인지를 return 하도록 solution 함수를 작성해주세요.
    //
    //제한사항
    //노드의 개수 n은 2 이상 20,000 이하입니다.
    //간선은 양방향이며 총 1개 이상 50,000개 이하의 간선이 있습니다.
    //vertex 배열 각 행 [a, b]는 a번 노드와 b번 노드 사이에 간선이 있다는 의미입니다.

    static class Node {
        int n;
        List<Node> links = new LinkedList<>();
        int distance = 0; // 1번 노드로부터의 길이
        Node(int n) { this.n = n; }
    }

    public int solution(int n, int[][] edge) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Node(i + 1));
        }

        for (int[] e : edge) {
            Node node1 = list.get(e[0] - 1);
            Node node2 = list.get(e[1] - 1);
            node1.links.add(node2);
            node2.links.add(node1);
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0));
        int maxDistance = Integer.MIN_VALUE;

        boolean[] isVisited = new boolean[n];

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            for (Node node : current.links) {
                if (!visited[node.n - 1]) {
                    visited[node.n - 1] = true;
                    node.distance = current.distance + 1;
                    queue.offer(node);
                    maxDistance = Math.max(maxDistance, node.distance);
                }
            }
        }

        for (Node node : list) {
            if (node.distance == maxDistance) answer++;
        }

        return answer;
    }

}
