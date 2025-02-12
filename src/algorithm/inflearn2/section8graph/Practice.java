package algorithm.inflearn2.section8graph;

import java.util.*;

public class Practice {

    public static void main(String[] args) {
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");

        a.link(b);
        a.link(d);
        b.link(a);
        b.link(c);
        c.link(b);
        c.link(d);
        d.link(a);
        d.link(c);
        d.link(e);
        e.link(b);
        e.link(d);

        Node target = e;

        // BFS
        Queue<Node> queue = new LinkedList<>();
        queue.offer(a);

        while (!queue.isEmpty()) {
            Node n = queue.poll();
            n.visit();
            System.out.println(n);

            if (n.equals(target)) {
                System.out.println("found!" + n);
                break;
            }
            n.links.stream()
                    .filter(l -> !queue.contains(l) && !l.isVisited())
                    .forEach(queue::offer);
        }

        // DFS
        a = new Node("A");
        b = new Node("B");
        c = new Node("C");
        d = new Node("D");
        e = new Node("E");

        a.link(b);
        a.link(d);
        b.link(a);
        b.link(c);
        c.link(b);
        c.link(d);
        d.link(a);
        d.link(c);
        d.link(e);
        e.link(b);
        e.link(d);

        target = e;
        Stack<Node> stack = new Stack<>();
        stack.push(a);

        while (!stack.isEmpty()) {
            Node n = stack.pop();
            n.visit();
            System.out.println(n);

            if (n.equals(target)) {
                System.out.println("found!" + n);
                break;
            }
            n.links.stream()
                    .filter(l -> !stack.contains(l) && !l.isVisited())
                    .forEach(stack::push);
        }

    }

    static class Node {
        String name;
        List<Node> links;
        boolean visited;

        public Node(String name) {
            this.name = name;
            this.links = new LinkedList<>();
        }

        void link(Node node) {
            links.add(node);
        }

        void visit() {
            this.visited = true;
        }

        boolean isVisited() {
            return this.visited;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return Objects.equals(name, node.name);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(name);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }



}
