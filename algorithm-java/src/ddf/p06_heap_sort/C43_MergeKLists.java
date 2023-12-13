package ddf.p06_heap_sort;

import utils.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.cn/problems/merge-k-sorted-lists/description">leetcode 23.合并K个升序链表</a>
 */
public class C43_MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n.val));

        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(node);
            }
        }

        ListNode head = new ListNode(0);
        ListNode cur = head;

        while (!queue.isEmpty()) {
            ListNode poll = queue.poll();
            cur.next = poll;
            cur = poll;
            if (poll.next != null) {
                queue.offer(poll.next);
            }
        }

        return head.next;
    }

}
