package linkedList;


/**
 * https://leetcode.com/problems/add-two-numbers-ii/#/description
 * You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 */
public class AddTwoNumbersII {
    public static void main(String[] args) {
        ListNode a1 = new ListNode(9);
        ListNode a2 = new ListNode(8);
        ListNode a3 = new ListNode(8);
        ListNode a4 = new ListNode(9);
        a3.next = a4;
        a2.next = a3;
        a1.next = a2;
        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(1);
        ListNode b3 = new ListNode(1);
        b2.next = b3;
        b1.next = b2;
        ListNode ret = new AddTwoNumbersII().addTwoNumbers(a1, b1);
        while (ret != null) {
            System.out.print("->" + ret.val);
            ret = ret.next;
        }
        System.out.println();
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode c1 = reverse(l1);
        ListNode c2 = reverse(l2);
        int carry = 0;
        ListNode ret = new ListNode((c1.val + c2.val + carry) % 10);
        carry = (c1.val + c2.val) / 10;
        while (c1.next != null || c2.next != null) {
            c1 = c1.next == null ? c1 : c1.next;
            c2 = c2.next == null ? c2 : c2.next;
            ListNode tmp = new ListNode((c1.val + c2.val + carry) % 10);
            carry = (c1.val + c2.val + carry) / 10;
            tmp.next = ret;
            ret = tmp;
        }
        ret = ret.val != 0 ? ret : ret.next;
        return ret;
    }

    public ListNode reverse(ListNode origin) {
        ListNode ret = new ListNode(0);
        while (origin != null) {
            ListNode tmp = new ListNode(origin.val);
            tmp.next = ret;
            ret = tmp;
            origin = origin.next;
        }
        return ret;
    }
}
