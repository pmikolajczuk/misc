package pl.mikolaj.r2025.leetcode.addtwonumbers;

public class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = new ListNode();
		ListNode current = head;

		int carry = 0;
		int l1Val = 0, l2Val = 0;
		while (true) {
			if (l1 != null) {
				l1Val = l1.val;
				l1 = l1.next;
			}

			if (l2 != null) {
				l2Val = l2.val;
				l2 = l2.next;
			}

			current.val = (l1Val + l2Val + carry) % 10;

			if (l1Val + l2Val + carry >= 10) {
				carry = 1;
			} else {
				carry = 0;
			}
			l1Val = l2Val = 0;

			if(l1 == null && l2 == null) {
				break;
			} else {
				current.next = new ListNode();
				current = current.next;
			}
		}

		if (carry == 1) {
			current.next = new ListNode(1);
		}

		return head;
	}
}