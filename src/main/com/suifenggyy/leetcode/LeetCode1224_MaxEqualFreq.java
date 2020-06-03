package com.suifenggyy.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author hzgongyongyue
 * @desc
 * @date 2020/5/29 21:34
 */
public class LeetCode1224_MaxEqualFreq {
	/**
	 * 思路错了，有可能一个很多，多出来的补齐到其他不足的上了，即使元素不相等
	 * @param nums
	 * @return
	 */
	public static int maxEqualFreq(int[] nums) {
		if (nums.length <= 2) {
			return nums.length;
		}
		Set<Integer> numSet = new HashSet<>();
		int num1 = -1;
		int num2 = -1;
		int count1 = 0;
		int count2 = 0;
		int max = 0;
		int avg;
		int cur;
		int mod;
		for (int i = 1; i <= nums.length; i++) {
			cur = nums[i -1];
			numSet.add(cur);
			if (count1 == 0) {
				num1 = cur;
				count1 = 1;
			} else if (cur == num1) {
				count1 ++;
			} else if (count2 == 0) {
				num2 = cur;
				count2 = 1;
			} else if (cur == num2) {
				count2 ++;
			}

			if (i / count1 == numSet.size() -1 && i % count1 == 1 || count2 > 0 && i / count2 == numSet.size() -1 && i % count2 == 1) {
				max = i;
			}
		}

		return max;
	}

	public static int maxEqualFreq_map(int[] nums) {
		if (nums.length <= 2) {
			return nums.length;
		}
		Map<Integer, Integer> cntMap = new HashMap<>();
		int max = 0;
		int maxCnt = 0;
		int cnt;
		int flag = 0;
		for (int i = 0; i < nums.length; i++) {
			cnt = cntMap.getOrDefault(nums[i], 0) + 1;
			cntMap.put(nums[i], cnt);
			if (maxCnt < cnt) {
				if (maxCnt != 0) {
					flag += cntMap.size() - 1;
				}
				maxCnt = cnt;
			} else if (cnt <= maxCnt) {
				if (cnt == 1) {
					flag += maxCnt - 1;
				} else {
					flag--;
				}
			}
			if (flag == maxCnt - 1 && cnt == 1 || flag == cntMap.size() - 1 && cnt != 1) {
				max = i;
			}

		}

		return max + 1;
	}

	public static int maxEqualFreq_Freq(int[] nums) {
		if (nums.length <= 2) {
			return nums.length;
		}
		Map<Integer, Integer> cntMap = new HashMap<>();
		int maxCnt = 0;
		int maxFreq = 0;
		int preMaxFreq = 0;
		int cnt;
		int len = 0;
		for (int i = 0; i < nums.length; i++) {
			cnt = cntMap.getOrDefault(nums[i], 0);
			if (cnt == maxCnt) {
				preMaxFreq = maxFreq - 1;
				maxCnt += 1;
				maxFreq = 1;
			} else if (cnt == maxCnt - 1) {
				maxFreq += 1;
			}
			cntMap.put(nums[i], cnt + 1);
			if (cntMap.size() == 1 || cntMap.size() == i + 1 || maxFreq == 1 && preMaxFreq == i || maxFreq == i && preMaxFreq == 1) {
				len = i + 1;
			}

		}
		return len;
	}

	public static void main(String[] args) {
		int[] nums = {1,1,1,2,3,3,3,4,4,4,5,5,5,42,97,5,46};
		System.out.println(maxEqualFreq_Freq(nums));
	}
}
