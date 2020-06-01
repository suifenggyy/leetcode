package com.suifenggyy.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hzgongyongyue
 * @desc
 * @date 2020/6/1 22:38
 */
public class LeetCode1431_kidsWithCandies {
	public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
		List<Boolean> res = new ArrayList<>();
		if (candies == null || candies.length == 0) {
			return res;
		}
		int max = 0;
		for (int can : candies) {
			if (max < can) {
				max = can;
			}
		}
		for (int can : candies) {
			res.add(can + extraCandies >= max);
		}
		return res;
	}

	public static void main(String[] args) {
		int[] cans = {2,3,5,1,3};
		System.out.println(JSON.toJSONString(kidsWithCandies(cans, 3)));
	}
}
