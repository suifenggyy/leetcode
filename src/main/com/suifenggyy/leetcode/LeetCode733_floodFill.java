package com.suifenggyy.leetcode;

/**
 * @author hzgongyongyue
 * @desc
 * @date 2020/8/16 21:36
 */
public class LeetCode733_floodFill {
	int[][] MV_DIR = {{-1, 0}, {1, 0}, {0, -1}, {0,  1}};
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		int m = image.length;
		int n =  image[0].length;
		int color = image[sr][sc];
		if (color != newColor) {
			dfs_733(image, sr, sc, newColor, color, m, n);
		}
		return image;

	}

	public void dfs_733(int[][] image, int sr, int sc, int newColor, int color, int m, int n) {
		if (sr >=m || sr < 0 || sc >=  n || sc < 0) {
			return;
		}
		if (image[sr][sc] == color) {
			image[sr][sc] = newColor;
			for (int i = 0; i < 4; i++) {
				dfs_733(image, sr + MV_DIR[i][0], sc + MV_DIR[i][1], newColor, color, m, n);
			}
		}
	}
}
