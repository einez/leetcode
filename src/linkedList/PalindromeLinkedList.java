package linkedList;

/**
 * https://leetcode.com/problems/palindrome-linked-list/#/description
 * Given a singly linked list, determine if it is a palindrome.
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode mid = head, tail = head.next;
        while (tail != null && tail.next != null) {
            mid = mid.next;
            tail = tail.next.next;
        }
        ListNode rev = new ListNode(head.val);
        while (head != mid) {
            head = head.next;
            ListNode tmp = new ListNode(head.val);
            tmp.next = rev;
            rev = tmp;
        }
        if (tail != null) {
            mid = mid.next;
        }
        while (rev != null || mid != null) {
            if (rev == null || mid == null || rev.val != mid.val) {
                return false;
            }
            rev = rev.next;
            mid = mid.next;
        }
        return true;
    }
}
