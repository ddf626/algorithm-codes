package ddf.p09_linked_list;

import utils.DUtils;
import utils.ListNode;

/**
 * <a href="https://leetcode.cn/problems/reverse-linked-list/description/">leetcode 206.反转链表</a>
 *
 * <p>
 * 递归和非递归两种方法都要掌握
 */
public class C30_ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        // return reverseListRecur(head);
        return reverseListIter(head);
    }

    /**
     * 非递归方法
     */
    public ListNode reverseListIter(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = head;
        ListNode pre = null;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    /**
     * 递归方法
     */
    public ListNode reverseListRecur(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseListRecur(head.next);
        ListNode newTail = head.next;
        newTail.next = head;
        head.next = null;

        return newHead;
    }

    public static void main(String[] args) {
        C30_ReverseLinkedList s = new C30_ReverseLinkedList();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        DUtils.printLinkedList(head);

        System.out.println("----after reverse---");

        DUtils.printLinkedList(s.reverseList(head));
    }

}
