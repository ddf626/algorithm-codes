package ddf.p09_linked_list;

import utils.ListNode;

public class C29_IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        int n1 = 1;
        ListNode curA = headA;
        while (curA.next != null) {
            curA = curA.next;
            n1++;
        }

        int n2 = 1;
        ListNode curB = headB;
        while (curB.next != null) {
            curB = curB.next;
            n2++;
        }

        if (curA != curB) {
            return null;
        }

        if (n1 < n2) {
            ListNode temp = headA;
            headA = headB;
            headB = temp;
        }

        int gap = Math.abs(n2 - n1);

        curA = headA;
        while (gap-- > 0) {
            curA = curA.next;
        }

        curB = headB;
        while (curA != curB) {
            curA = curA.next;
            curB = curB.next;
        }

        return curA;
    }

    public static void main(String[] args) {
//        ListNode n1 = new ListNode(4);
//        ListNode n2 = new ListNode(1);
//        ListNode n3 = new ListNode(8);
//        ListNode n4 = new ListNode(4);
//        ListNode n5 = new ListNode(5);
//        ListNode n6 = new ListNode(5);
//        ListNode n7 = new ListNode(6);
//        ListNode n8 = new ListNode(1);
//
//        n6.next = n7;
//        n7.next = n8;
//        n8.next = n3;
//        n3.next = n4;
//        n4.next = n5;
//        n1.next = n2;
//        n2.next = n3;
//
//
        C29_IntersectionOfTwoLinkedLists s = new C29_IntersectionOfTwoLinkedLists();
//        ListNode intersectionNode = s.getIntersectionNode(n1, n6);
//
//        System.out.println(intersectionNode.val);

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(9);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode n6 = new ListNode(3);
        n6.next = n4;

        System.out.println(s.getIntersectionNode(n1, n6).val);

//        ListNode n1 = new ListNode(2);
//        ListNode n2 = new ListNode(6);
//        ListNode n3 = new ListNode(4);
//
//        n1.next = n2;
//        n2.next = n3;
//
//        ListNode n4 = new ListNode(1);
//        ListNode n5 = new ListNode(5);
//
//        n4.next = n5;
//
//        System.out.println(s.getIntersectionNode(n1, n4).val);

    }

}
