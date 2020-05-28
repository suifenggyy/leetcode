package com.suifenggyy.leetcode;

/**
 * @author hzgongyongyue
 * @desc
 * @date 2020/5/28 23:33
 */
public class LeetCode394_decode {
	public static String decodeString(String s) {
		char[] data = s.toCharArray();
		int num = 0;
		StringBuilder stringBuilder = new StringBuilder();
		for(int i = 0; i < data.length; i ++) {
			char ch = data[i];
			if (ch >= '0' && ch <= '9') {
				num = num * 10 + (ch - '0');
			} else if (ch == '[') {
				int end = findNext(data, i + 1);
				String sub = decodeString(s.substring(i + 1, end));
				while (num-- > 0) {
					stringBuilder.append(sub);
				}
				i = end;
				num = 0;
			} else {
				stringBuilder.append(ch);
			}

		}
		return stringBuilder.toString();
	}

	public static int findNext(char[] data, int start) {
		if (data == null) {
			return start;
		}
		int flag = 1;
		for(int i = start; i < data.length; i ++) {
			if (data[i] == '[') {
				flag ++;
			} else if (data[i] == ']') {
				flag --;
			}
			if (flag == 0) {
				return i;
			}
		}
		return start;
	}

	public static void main(String[] args) {
		System.out.println(decodeString("3[a]2[bc]"));
		System.out.println("[asd]".substring(1, 3));
	}

}
