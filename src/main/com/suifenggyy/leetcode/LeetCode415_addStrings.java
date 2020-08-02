package com.suifenggyy.leetcode;

/**
 * @author hzgongyongyue
 * @desc
 * @date 2020/8/3 0:21
 */
public class LeetCode415_addStrings {
	public static String addStrings(String num1, String num2) {
		StringBuilder res = new StringBuilder();
		int len1 = num1 != null ? num1.length() : 0;
		int len2 = num2 != null ? num2.length() : 0;
		len1 --;
		len2 --;
		int jinwei = 0;
		int n1 = 0, n2 = 0, sum;
		while (len1 >= 0 || len2 >= 0) {
			if (len1 >= 0) {
				n1 = num1.charAt(len1) - '0';
			} else {
				n1 = 0;
			}
			if (len2 >= 0) {
				n2 = num2.charAt(len2) - '0';
			} else {
				n2 = 0;
			}
			sum = n1 + n2 + jinwei;
			if (sum >= 10) {
				sum -= 10;
				jinwei = 1;
			} else {
				jinwei = 0;
			}
			res.append((char) ('0' + sum));
			len1 --;
			len2 --;
		}
		if (jinwei == 1) {
			res.append('1');
		}
		return res.reverse().toString();
	}

	public static void main(String[] args) {
		System.out.println(addStrings("9", "1"));
	}
}
