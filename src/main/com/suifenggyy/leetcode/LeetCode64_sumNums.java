package com.suifenggyy.leetcode;

/**
 * @author hzgongyongyue
 * @desc
 * @date 2020/6/2 0:50
 */
public class LeetCode64_sumNums {
	public int sumNums(int n) {
		// try {
		//     int m = 1/n;
		//     return sumNums(n-1) + n;
		// } catch(Exception e) {
		//     return 0;
		// }

		boolean flag = (n > 0) && ((n += sumNums(n-1)) > 0);
		return n;
	}
}
