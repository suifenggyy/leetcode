package com.suifenggyy.leetcode;

/**
 * @author hzgongyongyue
 * @desc
 * @date 2020/6/1 23:05
 */
public class LeetCode73_setZeroes {
	public static void setZeroes(int[][] matrix) {
		if (matrix == null) {
			return;
		}
		int m = matrix.length;
		if (m == 0) {
			return;
		}
		int n = matrix[0].length;
		if (n == 0) {
			return;
		}

		boolean colZero = false, rowZero = false;
		int i, j;
		for (i = 0; i < m; i++) {
			if (matrix[i][0] == 0) {
				rowZero = true;
				break;
			}
		}
		for (i = 0; i < n; i++) {
			if (matrix[0][i] == 0) {
				colZero = true;
				break;
			}
		}

		for (i = 1; i < m; i++) {
			for (j = 1; j < n; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}

		for (i = 1; i < m; i++) {
			if (matrix[i][0] == 0) {
				for (j = 1; j < n; j++) {
					matrix[i][j] = 0;
				}
			}
		}

		for (j = 1; j < n; j++) {
			if (matrix[0][j] == 0) {
				for (i = 1; i < m; i++) {
					matrix[i][j] = 0;
				}
			}
		}

		if (rowZero) {
			for (i = 0; i < m; i++) {
				matrix[i][0] = 0;
			}
		}

		if (colZero) {
			for (j = 0; j < n; j++) {
				matrix[0][j] = 0;
			}
		}
	}


	public static void main(String[] args) {
//		int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};

		int[][] matrix = {{1,0,3}};
		setZeroes(matrix);
		System.out.println();
	}
}
