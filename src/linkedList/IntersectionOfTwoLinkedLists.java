package linkedList;

/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/#/description
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 */
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pa = headA, pb = headB;
        while (pa != null && pb != null) {
            pa = pa.next;
            pb = pb.next;
        }
        while (pa != null) {
            pa = pa.next;
            headA = headA.next;
        }
        while (pb != null) {
            pb = pb.next;
            headB = headB.next;
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}
