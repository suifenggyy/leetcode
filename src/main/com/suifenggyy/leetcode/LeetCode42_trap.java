package com.suifenggyy.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author hzgongyongyue
 * @desc
 * @date 2020/5/31 22:08
 */
public class LeetCode42_trap {
	public static int trap(int[] height) {
		if (height == null || height.length < 3) {
			return 0;
		}

		Deque<Integer> stack = new ArrayDeque<>();
		int preH = 0;
		int sum = 0;
		for (int i = 0; i < height.length; i++) {
			if (height[i] > preH) {
				while (stack.size() > 0) {
					sum += preH - height[stack.pollLast()];
				}
				preH = height[i];
			}
			stack.add(i);
		}

		while (stack.size() > 0) {
			preH = height[stack.pollLast()];
			while (stack.size() > 0 && height[stack.peekLast()] >= preH) {
				preH = height[stack.pollLast()];
			}
			while (stack.size() > 0 && height[stack.peekLast()] <= preH) {
				sum += preH - height[stack.pollLast()];
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		int[] height = {1,2,3,4,5,6,7,5,4,3,2,1};

		System.out.println(trap(height));
	}


}
