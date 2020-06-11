package com.suifenggyy.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hzgongyongyue
 * @desc
 * @date 2020/6/12 0:05
 */
public class LeetCode15_threeSum {
	public List<List<Integer>> threeSum_1(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return res;
		}

		Arrays.sort(nums);
		find(nums, 0, nums.length - 1, res);
		return res;
	}

	public void find(int[] nums, int start, int end, List<List<Integer>> res) {
		if (end - start < 2) {
			return;
		}
		int mid;
		mid = Arrays.binarySearch(nums, start + 1, end, 0 - nums[start] - nums[end]);
		if (mid > 0) {
			boolean in = false;
			for(List<Integer> old : res) {
				if (nums[start] == old.get(0) && nums[mid] == old.get(1) && nums[end] == old.get(2)) {
					in = true;
				}
			}
			if (!in) {
				List<Integer> list = new ArrayList<>();
				list.add(nums[start]);
				list.add(nums[mid]);
				list.add(nums[end]);
				res.add(list);
			}
		}

		while (nums[start + 1] == nums[start] && start < end - 1) {
			start += 1;
		}
		find(nums, start + 1, end, res);
		while (nums[end - 1] == nums[end] && start < end - 1) {
			end -= 1;
		}
		find(nums, start, end - 1, res);

	}



	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return res;
		}

		Arrays.sort(nums);

		int a, b, c, sum;
		int size = nums.length;
		for (a = 0; a < size - 2; a ++) {
			if (a > 0 && nums[a] == nums[a - 1]) {
				continue;
			}
			c = size - 1;
			for (b = a + 1; b < size - 1; b ++) {
				if (b > a + 1 && nums[b] == nums[b - 1]) {
					continue;
				}
				sum = nums[a] + nums[b];
				while (sum + nums[c] > 0 && c > b) {
					c --;
				}
				if (c == b) {
					break;
				}
				if (sum + nums[c] == 0) {
					List<Integer> list = new ArrayList<>();
					list.add(nums[a]);
					list.add(nums[b]);
					list.add(nums[c]);
					res.add(list);
				}
			}
		}

		return res;
	}

	public static void main(String[] args) {
		LeetCode15_threeSum soution = new LeetCode15_threeSum();
		int[] nums = {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
		System.out.println(JSON.toJSONString(soution.threeSum(nums)));
	}

}
