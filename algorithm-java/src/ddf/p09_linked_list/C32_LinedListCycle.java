package ddf.p09_linked_list;

import utils.ListNode;

/**
 * <a href="https://leetcode.cn/problems/linked-list-cycle/description/">leetcode141.环形链表</a>
 */
public class C32_LinedListCycle {

    /**
     * 快慢指针
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return false;
        }

        ListNode slow = head.next;
        ListNode fast = head.next.next;

        while (slow != fast) {
            if (fast.next == null || fast.next.next == null) {
                return false;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }

}
