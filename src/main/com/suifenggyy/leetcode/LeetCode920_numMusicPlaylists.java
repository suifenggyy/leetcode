package com.suifenggyy.leetcode;

/**
 * @author hzgongyongyue
 * @desc
 * @date 2020/6/19 0:38
 */
public class LeetCode920_numMusicPlaylists {
	class Solution {
		public int numMusicPlaylists(int N, int L, int K) {
			long[][] dp = new long[L + 1][N + 1];
			int mod = (int)1e9 + 7;
			dp[0][0] = 1;
			for (int i = 1; i <= L; i ++) {
				for (int j = 1; j <= N; j ++) {
					dp[i][j] = dp[i - 1][j - 1] * (N - j + 1) % mod;
					if (j > K) {
						dp[i][j] = (dp[i][j] + dp[i - 1][j] * (j - K)) % mod;
					}
				}
			}
			return (int)dp[L][N];
		}
	}

	public static void main(String[] args) {
		System.out.println((long)1e11 + 7);
	}
}
