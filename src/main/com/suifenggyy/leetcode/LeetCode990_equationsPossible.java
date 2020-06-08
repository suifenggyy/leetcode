package com.suifenggyy.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hzgongyongyue
 * @desc
 * @date 2020/6/8 22:36
 */
public class LeetCode990_equationsPossible {
	int[] parent = new int[26];
	public int find(int a) {
		while (parent[a] != a) {
			parent[a] = parent[parent[a]];
			a = parent[a];
		}
		return a;
	}

	public void merge(int a, int b) {
		parent[find(a)] = find(b);
	}

	public boolean equationsPossible(String[] equations) {
		for (int i = 0; i < 26; i++) {
			parent[i] = i;
		}

		if (equations == null || equations.length <= 0) {
			return true;
		}
		List<String> unEquList = new ArrayList<>();
		int a, b;
		for (String equation : equations) {
			if (equation.charAt(1) == '=') {
				a = equation.charAt(0) - 'a';
				b = equation.charAt(3) - 'a';
				merge(a, b);
			} else {
				unEquList.add(equation);
			}
		}
		for (String equation : unEquList) {
			a = equation.charAt(0) - 'a';
			b = equation.charAt(3) - 'a';
			if (find(a) == find(b)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		LeetCode990_equationsPossible soution = new LeetCode990_equationsPossible();
		String[] equations = {"a==b","b==c","c==d","f==e","g==f","c==g"};
		System.out.println(soution.equationsPossible(equations));
	}
}
