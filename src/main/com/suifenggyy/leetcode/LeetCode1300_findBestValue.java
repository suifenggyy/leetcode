package com.suifenggyy.leetcode;

import java.util.Arrays;

/**
 * @author hzgongyongyue
 * @desc
 * @date 2020/6/14 17:33
 */
public class LeetCode1300_findBestValue {

	public int findBestValue(int[] arr, int target) {
		Arrays.sort(arr);

		int sum = 0;
		int min = Integer.MAX_VALUE;
		int size = arr.length;
		int lefSize = size;
		int floor, ceil, diff, res = 0;
		double avg;
		for (int i = 0; i < size - 1; i ++) {
			lefSize = size - i;
			if (sum >= target) {
				break;
			}
			avg = (double) (target - sum) / (size - i);
			floor = (int) Math.floor(avg);

			if (floor <= arr[i] && (i == 0 || floor >= arr[i - 1])) {
				if (floor == avg) {
					return floor;
				}

				diff = Math.abs(target - floor * lefSize - sum);
				if (diff < min) {
					min = diff;
					res = floor;
				}
			}

			ceil = (int) Math.ceil(avg);
			if (ceil <= arr[i] && (i == 0 || ceil >= arr[i - 1])) {
				if (ceil == avg) {
					return ceil;
				}

				diff = Math.abs(target - ceil * lefSize - sum);
				if (diff < min) {
					min = diff;
					res = ceil;
				}
			}
			sum += arr[i];
		}

		sum += arr[size - 1];
		if (sum <= target) {
			res = arr[size - 1];
		}

		return res;
	}

	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0) {
			return "";
		}
		if (strs.length == 1) {
			return strs[0];
		}
		StringBuilder stringBuilder = new StringBuilder();
		boolean flag;
		for (int i = 0; i < strs[0].length(); i ++) {
			flag = true;
			for (int j = 1; j < strs.length; j++) {
				if (strs[j].length() < i || strs[0].charAt(i) != strs[j].charAt(i)) {
					flag = false;
					break;
				}
			}
			if (flag) {
				stringBuilder.append(strs[0].charAt(i));
			} else {
				break;
			}
		}
		return stringBuilder.toString();

	}

	public static void main(String[] args) {
		LeetCode1300_findBestValue soution = new LeetCode1300_findBestValue();
		int[] arr = {1547, 83230, 57084, 93444, 70879};
		System.out.println(soution.findBestValue(arr, 71237));
	}


}
