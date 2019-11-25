package leetcode.divide.q0023;

/**
 * Solution1因为递归所以栈溢出了,所以这里不在使用替换,而是直接基于数据进行合并
 */
public class Solution2 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            return null;
        }
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }

        int interval = 2;
        int length = lists.length;
        // 这个边界也出现过问题
        while (length > interval / 2) {
            for (int i = 0; i < length; i += interval) {
                int rightNodeIndex = i + interval / 2;
                if (rightNodeIndex < length) {
                    ListNode leftNode = lists[i];
                    ListNode rightNode = lists[rightNodeIndex];
                    // 处理空数组的情况, 提交的时候出现过
                    if (leftNode == null) {
                        lists[i] = rightNode;
                    } else if (rightNode == null) {
                        lists[i] = leftNode;
                    } else {
                        lists[i] = merge(leftNode.val > rightNode.val ? rightNode : leftNode, leftNode.val > rightNode.val ? leftNode : rightNode);
                    }
                }
            }
            interval *= 2;
        }

        return lists[0];
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
