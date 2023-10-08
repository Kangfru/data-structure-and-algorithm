package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {

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

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) return new ArrayList<>();
        return dfs(root, 0, targetSum, new ArrayList<>(), new ArrayList<>());
    }

    public List<List<Integer>> dfs(TreeNode node, int currentSum, int targetSum, List<List<Integer>> answer, List<Integer> currentList) {
        if (node == null) return answer;
        currentList.add(node.val);
        currentSum += node.val;
        if (node.left == null && node.right == null && currentSum == targetSum) {
            answer.add(currentList);
            return answer;
        }
        if (node.left != null) {
            dfs(node.left, currentSum, targetSum, answer, new ArrayList<>(currentList));
        }
        if (node.right != null) {
            dfs(node.right, currentSum, targetSum, answer, new ArrayList<>(currentList));
        }
        return answer;
    }

}
