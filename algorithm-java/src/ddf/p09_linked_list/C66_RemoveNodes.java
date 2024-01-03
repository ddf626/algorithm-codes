package ddf.p09_linked_list;

import utils.DUtils;
import utils.ListNode;

import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/remove-nodes-from-linked-list">leetcode 2487.从链表中移除节点</a>
 */
public class C66_RemoveNodes {

    public ListNode removeNodes(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode next = removeNodes(head.next);

        if (next != null && next.val > head.val) {
            return next;
        }

        head.next = next;

        return head;
    }

    /**
     * 单调栈解法
     */
    public ListNode removeNodes2(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            if (stack.isEmpty() || stack.peek().val >= cur.val) {
                stack.push(cur);
                cur = cur.next;
            } else {
                // 栈顶元素 < cur
                stack.pop();
            }
        }

        ListNode node = null;
        while (!stack.isEmpty()) {
            ListNode pop = stack.pop();
            pop.next = node;
            node = pop;
        }

        return node;
    }

    /**
     * 方法3:反转链表做法
     */
    public ListNode removeNodes3(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode newHead = reverseLinkedList(head);
        ListNode cur = newHead;
        while (cur.next != null) {
            if (cur.next.val < cur.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return reverseLinkedList(newHead);
    }

    private ListNode reverseLinkedList(ListNode head) {
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

    public static void main(String[] args) {
        C66_RemoveNodes s = new C66_RemoveNodes();
        ListNode head = new ListNode(5);
        head.next = new ListNode(2);
        head.next.next = new ListNode(13);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(8);

        DUtils.printLinkedList(s.removeNodes3(head));
    }

}
