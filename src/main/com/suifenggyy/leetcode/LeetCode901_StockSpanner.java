package com.suifenggyy.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author hzgongyongyue
 * @desc
 * @date 2020/6/3 1:30
 */
public class LeetCode901_StockSpanner {
	Deque<Integer> stack = new ArrayDeque<>();
	List<Integer> prices = new ArrayList<>();
	int pre = 0;
	public int next(int price) {
		while (!stack.isEmpty() && prices.get(stack.peekLast()) <= price) {
			stack.pollLast();
		}
		if (!stack.isEmpty()) {
			pre = stack.peekLast();
		} else {
			pre = -1;
		}
		stack.add(prices.size());
		prices.add(price);
		return prices.size() - 1 - pre;
	}



	Deque<Integer> pQue = new ArrayDeque<>();
	Deque<Integer> lQue = new ArrayDeque<>();
	int ans;
	public int next2(int price) {
		ans = 1;
		while (!pQue.isEmpty() && pQue.peekLast() <= price) {
			pQue.pollLast();
			ans += lQue.pollLast();
		}
		pQue.add(price);
		lQue.add(ans);
		return ans;
	}

	public static void main(String[] args) {
		LeetCode901_StockSpanner spanner = new LeetCode901_StockSpanner();
		int[] p = {100, 80, 60, 70, 60, 75, 85};
		for (int price : p) {
			System.out.println(spanner.next2(price));
		}
	}
}
