package leetcode.divide.q0023;

public class Test {
    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(5);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);

        ListNode node3 = new ListNode(2);
        node3.next = new ListNode(6);

        lists[0] = node1;
        lists[1] = node2;
        lists[2] = node3;

        ListNode result = new Solution2().mergeKLists(lists);
    }
}
