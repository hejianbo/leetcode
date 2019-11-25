package leetcode.divide.q0023;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution1 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        return divideAndMerge(lists, 0, lists.length - 1);
    }

    private ListNode divideAndMerge(ListNode[] lists, int left, int right) {
        if (right == left) {
            return lists[left];
        }
        int length = right - left + 1;
        int middle = left + length / 2;
        ListNode leftNode = divideAndMerge(lists, left, middle - 1);
        ListNode rightNode = divideAndMerge(lists, middle, right);
        return merge(leftNode.val > rightNode.val ? rightNode : leftNode, leftNode.val > rightNode.val ? leftNode : rightNode);
    }

    private ListNode merge(ListNode leftNode, ListNode rightNode) {
        ListNode head = leftNode;
        ListNode p = head;
        leftNode = leftNode.next;
        while(leftNode != null && rightNode != null) {
            if (leftNode.val < rightNode.val) {
                p.next = leftNode;
                leftNode = leftNode.next;
            } else {
                p.next = rightNode;
                rightNode = rightNode.next;
            }
            p = p.next;

        }
        if (leftNode != null) {
            p.next = leftNode;
        }
        if (rightNode != null) {
            p.next = rightNode;
        }
        return head;
    }
}
