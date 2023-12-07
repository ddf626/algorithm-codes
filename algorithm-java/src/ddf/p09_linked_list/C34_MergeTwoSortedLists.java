package ddf.p09_linked_list;

import utils.DUtils;
import utils.ListNode;

/**
 * <a href="https://leetcode.cn/problems/merge-two-sorted-lists/">leetcode 21.合并两个有序链表</a>
 */
public class C34_MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode resHead = new ListNode(0);

        ListNode curRes = resHead;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curRes.next = list1;
                curRes = curRes.next;

                list1 = list1.next;
                curRes.next = null;
            } else {
                curRes.next = list2;
                curRes = curRes.next;

                list2 = list2.next;
                curRes.next = null;
            }
        }

        if (list1 != null) {
            curRes.next = list1;
        }

        if (list2 != null) {
            curRes.next = list2;
        }

        return resHead.next;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        C34_MergeTwoSortedLists s = new C34_MergeTwoSortedLists();

        DUtils.printLinkedList(s.mergeTwoLists(list1, list2));


    }

}
