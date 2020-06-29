package com.suifenggyy.leetcode;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author hzgongyongyue
 * @desc
 * @date 2020/6/29 22:52
 */
public class LeetCode215_findKthLargest {
	class Solution {
		public int findKthLargest(int[] nums, int k) {
			return quickSelect(nums, 0, nums.length - 1, nums.length - k);
		}

		public int quickSelect(int[] nums, int start, int end, int index) {
			int selindex = randomSelect(nums, start, end);
			if (selindex == index) {
				return nums[selindex];
			} else {
				if (index < selindex) {
					return quickSelect(nums, start, selindex - 1, index);
				} else {
					return quickSelect(nums, selindex + 1, end, index);
				}
			}
		}

		public int randomSelect(int[] nums, int start, int end) {
			int randIndex = ThreadLocalRandom.current().nextInt(start, end);
			int tmp = nums[randIndex];
			nums[randIndex] = nums[start];
			nums[start] = tmp;
			int i = start, j = end, s;
			while (i < j) {
				while (nums[j] >= tmp && i < j) {
					j--;
				}
				while (nums[i] <= tmp && i < j) {
					i ++;
				}
				if (i < j) {
					s = nums[i];
					nums[i] = nums[j];
					nums[j] = s;
				}
			}
			nums[start] = nums[i];
			nums[i] = tmp;
			return i;
		}
	}


	public static void main(String[] args) {
		int[] nums = {7,6,5,4,3,2,1};

	}
}
