package com.suifenggyy.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hzgongyongyue
 * @desc
 * @date 2020/6/6 22:08
 */
public class LeetCode128_longestConsecutive {
	public static int longestConsecutive(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int i : nums) {
			set.add(i);
		}

		int next;
		int max = 0;
		for (int i : nums) {
			if (i != Integer.MIN_VALUE && set.contains(i - 1)) {
				continue;
			}
			next = i;
			while (next != Integer.MAX_VALUE && set.contains(next + 1)) {
				next ++;
			}
			max = Math.max(max, next - i + 1);
		}
		return max;
	}


	public static void main(String[] args) {
		int[] nums = {100};
		System.out.println(longestConsecutive(nums));
	}
}
