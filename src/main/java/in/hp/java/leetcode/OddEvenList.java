package in.hp.java.leetcode;

//  Definition for singly-linked list.
class ListNode {
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

public class OddEvenList {

    ListNode evenNode = new ListNode();

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode oddEnd = buildOddEvenList(head, evenNode);
        oddEnd.next = evenNode.next;
        return head;
    }

    private ListNode buildOddEvenList(ListNode node, ListNode evenNode) {
        if (node.next == null)
            return node;

        ListNode even = node.next;
        node.next = even.next;
        even.next = null;
        evenNode.next = even;

        if (node.next == null)
            return node;
        return buildOddEvenList(node.next, evenNode.next);
    }
}



