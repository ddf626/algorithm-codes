package ddf.p09_linked_list;

import utils.ListNode;

/**
 * <a href="https://leetcode.cn/problems/linked-list-cycle-ii/description">leetcode 142.环形链表2</a>
 */
public class C33_LinkedListCycle2 {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }

        ListNode slow = head.next;
        ListNode fast = head.next.next;

        while (slow != fast) {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        fast = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

}
