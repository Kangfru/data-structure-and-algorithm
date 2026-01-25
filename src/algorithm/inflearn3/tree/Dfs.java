package algorithm.inflearn3.tree;

public class Dfs {

    public void dfs(Node current) {
        if (current == null) return;
        System.out.println(current.value); // Preorder
        dfs(current.left);
//        System.out.println(current.value); // inorder (중위순회)
        dfs(current.right);
//        System.out.println(current.value); // postorder
    }

    public static class Node {
        int value;
        Node left;
        Node right;
    }

}
