package linkedList;

/**
 * https://leetcode.com/problems/remove-linked-list-elements/#/description
 * Remove all elements from a linked list of integers that have value val.
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        else if (head.val == val) {
            return removeElements(head.next, val);
        } else {
            head.next = removeElements(head.next, val);
            return head;
        }
    }
}
