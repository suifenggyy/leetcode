package com.suifenggyy.leetcode;

/**
 * @author hzgongyongyue
 * @desc
 * @date 2020/6/24 0:30
 */
public class LeetCode67_addBinary {
	static class Solution {
		public String addBinary(String a, String b) {
			int al = a.length() - 1;
			int bl = b.length() - 1;
			int jinwei = 0;
			StringBuilder stringBuilder = new StringBuilder();
			char ac, bc;
			int sum;
			while (al >= 0 || bl >= 0) {
				sum = 0;
				if (al >= 0) {
					ac = a.charAt(al);
					sum += ac - '0';
				}
				al --;
				if (bl >= 0) {
					bc = b.charAt(bl);
					sum += bc - '0';
				}
				bl --;
				sum += jinwei;
				if (sum <= 1) {
					stringBuilder.insert(0, sum);
				} else {
					stringBuilder.insert(0, 0);
					jinwei = 1;
				}
			}
			if (jinwei == 1) {
				stringBuilder.insert(0, 1);
			}
			return stringBuilder.toString();
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.addBinary("0", "1"));

	}
}
