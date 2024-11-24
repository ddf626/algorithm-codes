package ddf.p09_linked_list;

import utils.ListNode;

import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/palindrome-linked-list/description">leetcode 234.回文链表</a>
 */
public class C31_PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        ListNode cur = head;

        Stack<ListNode> stack = new Stack<>();

        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        cur = head;

        while (cur != null) {
            if (cur.val != stack.pop().val) {
                return false;
            }
            cur = cur.next;
        }

        return true;
    }

    // todo 第二种方法，后半侧反转后对比
    // O(1)空间复杂度
    public boolean isPalindrome2(ListNode head) {
        return false;
    }


    public static void main(String[] args) {
        ListNode h1 = new ListNode(1);
        h1.next = new ListNode(2);
        h1.next.next = new ListNode(2);
        h1.next.next.next = new ListNode(1);

        C31_PalindromeLinkedList s = new C31_PalindromeLinkedList();
        System.out.println(s.isPalindrome(h1));

    }



}
