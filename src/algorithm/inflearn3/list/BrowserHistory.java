package algorithm.inflearn3.list;

public class BrowserHistory {

    static class Node {
        String url;
        Node previous;
        Node next;
        Node(String url, Node previous, Node next) {
            this.url = url;
            this.previous = previous;
            this.next = next;
        }
    }

    Node current;

    public BrowserHistory(String homepage) {
        current = new Node(homepage, null, null);
    }

    public void visit(String url) {
        // remove all forward history
        current.next = new Node(url, current, null);
        current = current.next;
    }

    public String back(int steps) {
        while (steps > 0 && current.previous != null) {
            steps--;
            current = current.previous;
        }
        return current.url;
    }

    public String forward(int steps) {
        while (steps > 0 && current.next != null) {
            steps--;
            current = current.next;
        }
        return current.url;
    }



}
