package algorithm.leetcode;

public class MiddleOfLinkedList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode middleNode(ListNode head) {
        ListNode runner = head;
        ListNode walker = head;
        while (runner != null) {
            runner = runner.next;
            if (runner != null) {
                runner = runner.next;
                walker = walker.next;
            }
        }
        return walker;
    }

}
