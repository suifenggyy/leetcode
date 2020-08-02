package com.suifenggyy.leetcode;

/**
 * @author hzgongyongyue
 * @desc
 * @date 2020/7/12 13:38
 */
public class LeetCode174_calculateMinimumHP {
	public static int calculateMinimumHP(int[][] dungeon) {
		int m = dungeon.length;
		int n = dungeon[0].length;
		int[][] dp = new int[m][n];
		int[][] dm = new int[m][n];

		dp[0][0] = dungeon[0][0];
		dm[0][0] = dungeon[0][0];

		for (int i = 1; i < m; i++) {
			dp[i][0] = dp[i - 1][0] + dungeon[i][0];
			dm[i][0] = Math.min(dm[i - 1][0], dp[i][0]);
		}

		for (int i = 1; i < n; i++) {
			dp[0][i] = dp[0][i - 1] + dungeon[0][i];
			dm[0][i] = Math.min(dm[0][i - 1], dp[0][i]);

		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + dungeon[i][j];
				dm[i][j] = Math.min(Math.max(dm[i - 1][j], dm[i][j - 1]), dp[i][j]);
			}
		}
		return dm[m - 1][n - 1] * -1 + 1;
	}

	public static void main(String[] args) {
		int[][] dungeon = {{-2,-3,3},{-5, -10, 1},{10,30,-5}};
		System.out.println(calculateMinimumHP(dungeon));
	}
}
