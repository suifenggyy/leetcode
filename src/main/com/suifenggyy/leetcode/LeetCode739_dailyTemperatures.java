package com.suifenggyy.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author hzgongyongyue
 * @desc
 * @date 2020/5/31 21:27
 */
public class LeetCode739_dailyTemperatures {
	public static int[] dailyTemperatures(int[] T) {
		if (T == null || T.length == 0) {
			return T;
		}

		int[] res = new int[T.length];
		Deque<Integer> stack = new ArrayDeque<>();
		int pollIndex = 0;
		for (int i = 0; i < T.length; i++) {
			while (stack.size() > 0 && T[i] > T[stack.peekLast()]) {
				pollIndex = stack.pollLast();
				res[pollIndex] = i - pollIndex;
			}
			stack.add(i);
		}
		return res;
	}

	public static void main(String[] args) {
		int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
		dailyTemperatures(T);
	}
}