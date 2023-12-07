package ddf.p09_linked_list;

import utils.DUtils;
import utils.ListNode;

/**
 * <a href="https://leetcode.cn/problems/add-two-numbers>leetcode 2.两数相加</a>
 */
public class C35_AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int c = 0;

        ListNode head = new ListNode(0);
        ListNode cur = head;

        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val + c;
            c = val >= 10 ? val / 10 : 0;
            val = val >= 10 ? val % 10 : val;

            cur.next = new ListNode(val);
            cur = cur.next;

            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int val = l1.val + c;
            c = val >= 10 ? val / 10 : 0;
            val = val >= 10 ? val % 10 : val;

            cur.next = new ListNode(val);
            cur = cur.next;

            l1 = l1.next;
        }

        while (l2 != null) {
            int val = l2.val + c;
            c = val >= 10 ? val / 10 : 0;
            val = val >= 10 ? val % 10 : val;

            cur.next = new ListNode(val);
            cur = cur.next;

            l2 = l2.next;
        }

        if (c > 0) {
            cur.next = new ListNode(c);
        }

        return head.next;
    }

    public static void main(String[] args) {
        C35_AddTwoNumbers s = new C35_AddTwoNumbers();

        DUtils.printLinkedList(s.addTwoNumbers(DUtils.buildLinkedList(new int[] {2, 4, 3}), DUtils.buildLinkedList(new int[] {5, 6, 4})));
        DUtils.printLinkedList(s.addTwoNumbers(DUtils.buildLinkedList(new int[] {0}), DUtils.buildLinkedList(new int[] {0})));
        DUtils.printLinkedList(s.addTwoNumbers(DUtils.buildLinkedList(new int[] {9,9,9,9,9,9,9}), DUtils.buildLinkedList(new int[] {9,9,9,9})));
    }

}
