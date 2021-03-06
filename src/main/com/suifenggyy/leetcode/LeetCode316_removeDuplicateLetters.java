package com.suifenggyy.leetcode;

import java.util.*;

/**
 * @author hzgongyongyue
 * @desc
 * @date 2020/6/5 2:07
 */
public class LeetCode316_removeDuplicateLetters {
	public static String removeDuplicateLetters_Error(String s) {
		if (s == null || s.length() <= 1) {
			return s;
		}
		Set<Character> containSet = new HashSet<>();
		List<Character> list = new ArrayList<>();
		int index = 0;
		Character ch;
		for (int i = s.length() -1; i >= 0; i--) {
			ch = s.charAt(i);
			if (!containSet.contains(ch) || index == 0 || ch.compareTo(list.get(index - 1)) < 0) {
				containSet.add(ch);
				list.add(ch);
				index ++;
			}
		}

		StringBuilder stringBuilder = new StringBuilder();
		containSet.clear();
		for (int i = list.size() - 1; i >= 0; i--) {
			ch = list.get(i);
			if (!containSet.contains(ch)) {
				containSet.add(ch);
				stringBuilder.append(ch);
			}
		}
		return stringBuilder.toString();
	}

	public static String removeDuplicateLetters(String s) {
		if (s == null || s.length() <= 1) {
			return s;
		}
		Map<Character, Integer> maxIndex = new HashMap<>(26);
		Deque<Character> stack = new ArrayDeque<>(26);
		Set<Character> containSet = new HashSet<>(26);
		Character ch;
		for (int i =0; i < s.length(); i++) {
			ch = s.charAt(i);
			maxIndex.put(ch, i);
		}

		for (int i =0; i < s.length(); i++) {
			ch = s.charAt(i);
			if (!containSet.contains(ch)) {
				while (stack.size() > 0 && stack.peekLast() > ch && maxIndex.get(stack.peekLast()) > i) {
					containSet.remove(stack.pollLast());
				}
				stack.add(ch);
				containSet.add(ch);
			}
		}
		StringBuilder stringBuilder = new StringBuilder();
		while (! stack.isEmpty()) {
			stringBuilder.append(stack.pollFirst());
		}
		return stringBuilder.toString();

	}

	public static void main(String[] args) {
		System.out.println(removeDuplicateLetters("cbacdcbc"));
	}
}
