package pl.mikolaj.r2025.leetcode.addtwonumbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

	Solution solution = new Solution();

	@Test
	void addTwoNumbers() {
		ListNode l1 = intToList(3);
		ListNode l2 = intToList(8);
		ListNode result = solution.addTwoNumbers(l1, l2);
		System.out.println(listToString(result));
		assertEquals("11", listToString(result));

		l1 = intToList(342);
		l2 = intToList(465);
		result = solution.addTwoNumbers(l1, l2);
		System.out.println(listToString(result));
		assertEquals("807", listToString(result));

		l1 = intToList(0);
		l2 = intToList(0);
		result = solution.addTwoNumbers(l1, l2);
		System.out.println(listToString(result));
		assertEquals("0", listToString(result));

		l1 = intToList(9999999);
		l2 = intToList(9999);
		result = solution.addTwoNumbers(l1, l2);
		System.out.println(listToString(result));
		assertEquals("10009998", listToString(result));
	}

	private ListNode intToList(int number) {
		String numberString = String.valueOf(number);
		ListNode l1 = new ListNode(charToInt(numberString.charAt(0)));

		for (int i = 1; i < numberString.length(); i++) {
			l1 = new ListNode(charToInt(numberString.charAt(i)), l1);
		}

		return l1;
	}

	private int charToInt(char c) {
		return c - '0';
	}

	private int listToInt(ListNode head) {
		return Integer.parseInt(listToString(head));
	}

	private String listToString(ListNode head) {
		StringBuilder sb = new StringBuilder();
		ListNode current = head;

		while(current != null) {
			sb.append(current.val);
			current = current.next;
		}

		return sb.reverse().toString();
	}


}