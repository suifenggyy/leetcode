package com.suifenggyy.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hzgongyongyue
 * @desc
 * @date 2020/6/3 23:27
 */
public class LeetCode983_mincostTickets {
	public static int mincostTickets(int[] days, int[] costs) {
		Set<Integer> daySet = new HashSet<>();
		int maxDay = 0;
		for (int day : days) {
			daySet.add(day);
			if (maxDay < day) maxDay = day;
		}

		int[] sum = new int[366];
		int dayAft1, dayAft7, dayAft30;
		for (int i = maxDay; i > 0; i--) {
			dayAft1 = (i + 1) > maxDay ? 0 : (i + 1);
			if (daySet.contains(i)) {
				dayAft7 = (i + 7) > maxDay ? 0 : (i + 7);
				dayAft30 = (i + 30) > maxDay ? 0 : (i + 30);
				sum[i] = Math.min(Math.min(sum[dayAft1] + costs[0], sum[dayAft7] + costs[1])
						, sum[dayAft30] + costs[2]);
			} else {
				sum[i] = sum[dayAft1];
			}
		}

		return sum[1];
	}

	public static int getCost(int day, int[] cost) {
		if (day > 365 || day <= 0) {
			return 0;
		}
		return cost[day];
	}



	static Set<Integer> daySet = new HashSet<>();
	static int[] gCosts;
	static Integer[] sum = new Integer[366];
	public static int mincostTickets_digui(int[] days, int[] costs) {
		for (int day : days) {
			daySet.add(day);
		}
		gCosts = costs;
		return dp(1);
	}

	public static int dp(int day) {
		if (day > 365 || day <= 0) {
			return 0;
		}
		if (sum[day] != null) {
			return sum[day];
		}
		if (daySet.contains(day)) {
			return Math.min(Math.min(dp(day + 1) + gCosts[0], dp(day + 7) + gCosts[1]), dp(day + 30) + gCosts[2]);
		}
		return dp(day + 1);
	}

	static int[] gDays;
	static int[] len = {1, 7, 30};
	public static int mincostTickets_digui2(int[] days, int[] costs) {
		gCosts = costs;
		gDays = days;
		return dp2(1);
	}

	public static int dp2(int day) {
		if (day > 365 || day <= 0) {
			return 0;
		}
		if (sum[day] != null) {
			return sum[day];
		}
		sum[day] = Integer.MAX_VALUE;
		int j = day;
		for (int i = 0; i < 3; i ++) {

		}


		return 0;
	}


	public static void main(String[] args) {
		int[] days = {1,4,6,7,8,20}, costs = {2,7,15};
		System.out.println(mincostTickets_digui(days, costs));
	}


}
