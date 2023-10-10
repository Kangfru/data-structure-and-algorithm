package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> answerList = new ArrayList<>();
        Stack<TreeNode> inorderStack = new Stack<>();
        TreeNode node = root;
        // inorder : left -> self -> right

        while (node != null || !inorderStack.isEmpty()) {
            while (node != null) {
                inorderStack.add(node);
                node = node.left;
            }
            node = inorderStack.pop();
            answerList.add(node.val);
            node = node.right;
        }
        return answerList;
    }

}
