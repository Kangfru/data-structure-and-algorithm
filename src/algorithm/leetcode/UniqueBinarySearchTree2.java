package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTree2 {
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
    public static List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    public static List<TreeNode> generateTrees(int left, int right) {
        List<TreeNode> treeNodeList = new ArrayList<>();
        if (left > right) {
            treeNodeList.add(null);
            return treeNodeList;
        }
        for (int i = left; i <= right; i++) {
            for (TreeNode leftTree : generateTrees(left, i - 1)) {
                for (TreeNode rightTree : generateTrees(i + 1, right)) {
                    TreeNode node = new TreeNode(i);
                    node.left = leftTree;
                    node.right = rightTree;
                    treeNodeList.add(node);
                }
            }
        }
        return treeNodeList;
    }

    public static void main(String[] args) {
        generateTrees(4);
    }

}
