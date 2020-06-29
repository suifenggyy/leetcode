package com.suifenggyy.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hzgongyongyue
 * @desc
 * @date 2020/6/30 1:00
 */
public class LeetCode424_characterReplacement {
	public static int characterReplacement(String s, int k) {
		Map<Character, Integer> map = new HashMap<>(26);
		int start = 0, end = 0;
		int len = s.length();
		char ch;
		int cnt, max = 0;
		// 最多的次数
		int maxChCnt = 0;
		// 最多的次数出现的个数
		int maxChCntTime = 0;
		while (end < len) {
			ch = s.charAt(end);
			cnt = map.getOrDefault(ch, 0) + 1;
			map.put(ch, cnt);
			if (cnt == maxChCnt) {
				maxChCntTime += 1;
			} else if (cnt > maxChCnt) {
				maxChCnt = cnt;
				maxChCntTime = 1;
			}
			while (end - start + 1 - maxChCnt > k) {
				ch = s.charAt(start);
				cnt = map.get(ch);
				map.put(ch, cnt - 1);
				if (cnt == maxChCnt) {
					if (maxChCntTime == 1) {
						maxChCnt = cnt - 1;
						maxChCntTime = 0;
						for (int c : map.values()) {
							if (c == maxChCnt) {
								maxChCntTime += 1;
							}
						}
					}
				}
				start ++;
			}
			max = Math.max(max, end - start + 1);
			end ++;
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println(characterReplacement("ABAB", 2));
	}

}
