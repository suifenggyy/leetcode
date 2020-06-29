package com.suifenggyy.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author hzgongyongyue
 * @desc
 * @date 2020/6/30 0:06
 */
public class LeetCodeO9_CQueue {
	class CQueue {

		Deque<Integer> stackA;
		Deque<Integer> stackB;
		public CQueue() {
			stackA = new LinkedList<>();
			stackB = new LinkedList<>();
		}

		public void appendTail(int value) {
			stackA.addLast(value);
		}

		public Integer deleteHead() {
			if (!stackB.isEmpty()) {
				return stackB.removeLast();
			}
			while (!stackA.isEmpty()) {
				stackB.addLast(stackA.removeLast());
			}
			if (!stackB.isEmpty()) {
				return stackB.removeLast();
			}
			return null;
		}
	}


}
