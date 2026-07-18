package pl.mikolaj.old.leetcode.addtwonumbers;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode r1 = new ListNode();
        ListNode result = r1;
        while (true) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            r1.val = sum % 10;
            carry = sum / 10;
            if (l1 == null && l2 == null && carry == 0) {
                break;
            } else {
                r1.next = new ListNode();
                r1 = r1.next;
            }
        }
        return result;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

