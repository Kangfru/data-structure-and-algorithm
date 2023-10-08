package algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {

    public static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public static Node cloneGraph(Node node) {
        Map<Integer, Node> map = new HashMap<>();
        return cloneDfs(node, map);
    }

    public static Node cloneDfs(Node node, Map<Integer, Node> map) {
        if (node == null) return null;
        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }

        Node cloneNode = new Node(node.val, new ArrayList<>());
        map.put(node.val, cloneNode);
        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneDfs(neighbor, map));
        }

        return cloneNode;
    }

    public static void main(String[] args) {
        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        Node node4 = new Node();
        node1.val = 1;
        ArrayList<Node> node1Neighbors = new ArrayList<>();
        node1Neighbors.add(node2);
        node1Neighbors.add(node4);
        node1.neighbors = node1Neighbors;

        node2.val = 2;
        ArrayList<Node> node2Neighbors = new ArrayList<>();
        node2Neighbors.add(node1);
        node2Neighbors.add(node3);
        node2.neighbors = node2Neighbors;

        node3.val = 3;
        ArrayList<Node> node3Neighbors = new ArrayList<>();
        node3Neighbors.add(node2);
        node3Neighbors.add(node4);
        node3.neighbors = node3Neighbors;

        node4.val = 4;
        ArrayList<Node> node4Neighbors = new ArrayList<>();
        node4Neighbors.add(node1);
        node4Neighbors.add(node3);
        node4.neighbors = node4Neighbors;
        cloneGraph(node1);
    }

}
