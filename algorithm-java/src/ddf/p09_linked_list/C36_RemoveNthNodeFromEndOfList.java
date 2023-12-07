package ddf.p09_linked_list;

import utils.DUtils;
import utils.ListNode;

/**
 * <a href="https://leetcode.cn/problems/remove-nth-node-from-end-of-list">leetcode 19.删除链表的倒数第N 个结点</a>
 */
public class C36_RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        int length = getLength(head);

        // 倒数第n个是正数第几个
        int k = length - n + 1;
        if (k == 1) {
            return head.next;
        }

        ListNode cur = head;
        ListNode pre = null;

        while (--k > 0) {
            pre = cur;
            cur = cur.next;
        }

        // 现在cur指向要删除第节点，把pre的next指针指向cur的next指针
        pre.next = cur.next;

        return head;
    }

    private int getLength(ListNode head) {
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            n++;
        }

        return n;
    }

    public static void main(String[] args) {
        C36_RemoveNthNodeFromEndOfList s = new C36_RemoveNthNodeFromEndOfList();

        DUtils.printLinkedList(s.removeNthFromEnd(DUtils.buildLinkedList(new int[] {1,2,3,4,5}), 2));
        DUtils.printLinkedList(s.removeNthFromEnd(DUtils.buildLinkedList(new int[] {1}), 1));
        DUtils.printLinkedList(s.removeNthFromEnd(DUtils.buildLinkedList(new int[] {1,2}), 1));
    }

}
