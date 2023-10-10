package algorithm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal2 {

    public class TreeNode {
        TreeNode left;
        TreeNode right;

        int val;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> answerList = new ArrayList<>();
        if (root == null) return answerList;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            answerList.add(0, level);
        }
        return answerList;
    }

}
