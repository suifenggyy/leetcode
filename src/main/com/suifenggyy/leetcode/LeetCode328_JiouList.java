package com.suifenggyy.leetcode;

/**
 * @author hzgongyongyue
 * @desc
 * @date 2020/5/28 23:01
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class LeetCode328_JiouList {
	public ListNode oddEvenList(ListNode head) {
		if(head == null || head.next == null || head.next.next == null) {
			return head;
		}
		ListNode res = head;
		ListNode jList = head;
		ListNode oList = head.next;
		ListNode oListHead = oList;
		head = head.next.next;
		while (head != null) {
			jList.next = head;
			jList = jList.next;
			if (head.next != null) {
				oList.next = head.next;
				oList = oList.next;
			} else {
				break;
			}
			head = head.next.next;
		}
		oList.next = null;
		jList.next = oListHead;
		return res;
	}

	public static void main(String[] args) {
		ListNode node7 = new ListNode(7);
		node7.next = null;
		ListNode node6 = new ListNode(6, node7);
		ListNode node5 = new ListNode(5, node6);
		ListNode node4 = new ListNode(4, node5);
		ListNode node3 = new ListNode(3, node4);
		ListNode node2 = new ListNode(2, node3);
		ListNode node1 = new ListNode(1, node2);
		ListNode head = node1;
		while (head != null) {
			System.out.print(head.val + " -> ");
			head = head.next;
		}
		System.out.println("");
		head = node1;
		LeetCode328_JiouList solution = new LeetCode328_JiouList();
		ListNode res = solution.oddEvenList(head);
		while (res != null) {
			System.out.print(res.val + " -> ");
			res = res.next;
		}
	}
}
