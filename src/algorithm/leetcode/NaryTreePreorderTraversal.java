package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NaryTreePreorderTraversal {

    public static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    public List<Integer> preorder(Node root) {
        List<Integer> answerList = new ArrayList<>();
        // preorder 는 self -> left -> right 순
        preorder(answerList, root);
        return answerList;
    }

    public void preorder(List<Integer> answerList, Node node) {
        if (node == null) return;
        answerList.add(node.val);
        for (Node child : node.children) {
            preorder(answerList, child);
        }
    }

}
