package com.suifenggyy.leetcode;

/**
 * @author hzgongyongyue
 * @desc
 * @date 2020/6/3 22:48
 */
public class LeetCode837_new21Game {
	public static double new21Game(int N, int K, int W) {
		if (N - K + 1 >= W) {
			return 1.0d;
		}
		int size = K + W;
		double[] winRate = new double[size];
		int i;
		for (i = K; i <= N && i < size; i++) {
			winRate[i] = 1.0d;
		}
		double winSum = N - K + 1;
		for (i = K - 1; i >= 0; i --) {
			winRate[i] = winSum / W;
			winSum = winSum - winRate[i + W] + winRate[i];
		}
		return winRate[0];
	}
}
