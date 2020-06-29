package com.suifenggyy.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hzgongyongyue
 * @desc
 * @date 2020/6/30 0:41
 */
public class LeetCode3_lengthOfLongestSubstring {
	public int lengthOfLongestSubstring(String s) {
		Map<Character, Integer> map = new HashMap<>(256);
		int start = 0, end = 0;
		int len = s.length();
		char ch;
		int cnt, max = 0;
		while (end < len) {
			ch = s.charAt(end);
			map.put(ch, map.getOrDefault(ch, 0) + 1);
			while (map.size() != end - start + 1) {
				ch = s.charAt(start);
				cnt = map.get(ch);
				if (cnt == 1) {
					map.remove(ch);
				} else {
					map.put(ch, cnt - 1);
				}
			}
			max = Math.max(max, map.size());
		}
		return max;
	}
}
