package com.suifenggyy.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hzgongyongyue
 * @desc
 * @date 2020/5/31 20:37
 */
public class LeetCode496_nextGreaterElement {
	public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
		if (nums1 == null || nums1.length == 0) {
			return nums1;
		}
		Map<Integer, Integer> nextMap = new HashMap<>(nums2.length);
		Deque<Integer> stack = new ArrayDeque<>();

		for (int i = 0; i < nums2.length; i++) {
			while (!stack.isEmpty() && nums2[i] > nums2[stack.peekLast()]) {
				nextMap.put(nums2[stack.pollLast()], nums2[i]);
			}
			stack.add(i);
		}
		int[] res = new int[nums1.length];
		for (int i = 0; i < nums1.length; i++) {
			res[i] = nextMap.getOrDefault(nums1[i], -1);
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums1 = {1,2,3,4,5};
		int[] nums2 = {2,4,1,5,7,6,3};
		System.out.println(nextGreaterElement(nums1, nums2));
	}
}
