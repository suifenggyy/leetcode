package com.suifenggyy.leetcode;

import java.util.Stack;

/**
 * @author hzgongyongyue
 * @desc
 * @date 2020/5/30 10:49
 */
public class LeetCode84_largestRect {
	public static int largestRectangleArea(int[] heights) {
		if (heights == null || heights.length == 0) {
			return 0;
		}
		if (heights.length == 1) {
			return heights[0];
		}

		int size = heights.length;
		int max = 0, i, j;
		for(i = 0; i < size; i++) {
			if (max < heights[i]) {
				max = heights[i];
			}
		}
		for(i = 2; i <= size; i++) {
			for (j = size - 1; j >= i - 1; j--) {
				heights[j] = Math.min(heights[j], heights[j - 1]);
				max = Math.max(max, heights[j] * Math.min(i, j + 1));
			}
		}
		return max;
	}

	public static int largestRectangleAreaVector(int[] heights) {
		if (heights == null || heights.length == 0) {
			return 0;
		}
		if (heights.length == 1) {
			return heights[0];
		}

		int size = heights.length;
		int max = 0;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < size; i++) {
			while (stack.size() > 0 && heights[i] <= heights[stack.peek()]) {
				int top = stack.peek();
				stack.pop();
				max = Math.max(max, heights[top] * (stack.empty() ? i : (i - stack.peek() -1)));
			}
			stack.push(i);
		}
		while (stack.size() > 0) {
			int top = stack.peek();
			while (stack.size() > 0 && heights[top] == heights[stack.peek()]) {
				stack.pop();
			}
			max = Math.max(max, heights[top] * (stack.empty() ? size : (size - stack.peek() -1)));
		}
		return max;
	}

	public static void main(String[] args) {
		int[] heights = {1,2,4,3,5,3,6,7,8};
		System.out.println(largestRectangleAreaVector(heights));
	}
}
