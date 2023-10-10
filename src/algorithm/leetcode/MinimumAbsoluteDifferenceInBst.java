package algorithm.leetcode;

public class MinimumAbsoluteDifferenceInBst {

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

    boolean init;
    int min;
    int prev;

    public int getMinimumDifference(TreeNode root) {
        init = false;
        min = Integer.MAX_VALUE;
        // Binary 이진트리를 inorder로 순회하면 오름차순이 됨.
        inorder(root);
        return min;
    }

    public void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        // self
        if (!init) {
            init = true;
        } else {
            min = Math.min(min, node.val - prev);
        }
        prev = node.val;
        inorder(node.right);
    }

}
