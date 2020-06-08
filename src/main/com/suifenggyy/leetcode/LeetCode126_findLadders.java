package com.suifenggyy.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * @author hzgongyongyue
 * @desc
 * @date 2020/6/7 21:30
 */
public class LeetCode126_findLadders {
	public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		List<List<String>> res = new ArrayList<>();
		if (wordList == null || !wordList.contains(endWord)) {
			return res;
		}

		Deque<String> deque = new ArrayDeque<>();
		deque.add(beginWord);

		Deque<List<String>> listDeque = new ArrayDeque<>();
		List<String> beginList = new ArrayList<>();
		beginList.add(beginWord);
		listDeque.add(beginList);

		Map<String, Integer> firstIndex = new HashMap<>();
		String first, cur;
		List<String> curList;
		Set<String> leftSet = new HashSet<>(wordList);
		leftSet.remove(beginWord);
		int minSize = Integer.MAX_VALUE;
		List<String> nextWords = new ArrayList<>();
		while (!deque.isEmpty()) {
			first = deque.pollFirst();
			curList = listDeque.pollFirst();
			leftSet.remove(first);
			nextWords.clear();
			for (String word : leftSet) {
				if (firstIndex.getOrDefault(word, Integer.MAX_VALUE) > curList.size() && isNext(first, word)) {
					nextWords.add(word);
				}
			}
			if (nextWords.size() == 0) {
				continue;
			}

			if (nextWords.contains(endWord)) {
				curList.add(endWord);
				res.add(curList);
				minSize = Math.min(minSize, curList.size());
			} else {
				if (curList.size() >= minSize) {
					break;
				}
				for (int i = 1; i < nextWords.size(); i++) {
					List<String> copyList = new ArrayList<>(curList);
					cur = nextWords.get(i);
					copyList.add(cur);
					deque.add(cur);
					listDeque.add(copyList);
					firstIndex.put(cur, copyList.size());
				}
				cur = nextWords.get(0);
				curList.add(cur);
				deque.add(cur);
				listDeque.add(curList);
				firstIndex.put(cur, curList.size());
			}
		}
		return res;
	}

	public static boolean isNext(String a, String b) {
		int dif = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != b.charAt(i)) {
				dif ++;
			}
			if (dif > 1) {
				return false;
			}
		}
		return dif == 1;
	}


	public static List<List<String>> findLadders_1(String beginWord, String endWord, List<String> wordList) {
		Set<String> wordSet = new HashSet<>(wordList);
		List<List<String>> res = new ArrayList<>();
		if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
			return res;
		}

		Map<String, Set<String>> map = new HashMap<>();
		if (!bfs(beginWord, endWord, wordSet, map)) {
			return res;
		}

		Deque<String> path = new ArrayDeque<>();
		path.addLast(beginWord);
		dfs(beginWord, endWord, map, path, res);
		return res;
	}

	public static boolean bfs(String beginWord, String endWord, Set<String> words, Map<String, Set<String>> map) {
		Queue<String> queue = new LinkedList<>();
		queue.offer(beginWord);

		Set<String> visited = new HashSet<>();
		visited.add(beginWord);

		boolean findEnd = false;
		Set<String> nextSet = new HashSet<>();
		while (!queue.isEmpty()) {
			int curLen = queue.size();
			for (int i = 0; i < curLen; i++) {
				String cur = queue.poll();
				for (String next : words) {
					if (!visited.contains(next) && isNext(cur, next)) {
						if (next.equals(endWord)) {
							findEnd = true;
						}
						nextSet.add(next);
						queue.offer(next);
						Set<String> toSet = map.getOrDefault(cur, new HashSet<>());
						toSet.add(next);
						map.put(cur, toSet);
					}
				}
			}
			if (findEnd) {
				break;
			}
			words.removeAll(nextSet);
			visited.addAll(nextSet);
			nextSet.clear();
		}
		return findEnd;
	}


	private static void dfs(String beginWord, String endWord,
	                 Map<String, Set<String>> map,
	                 Deque<String> path, List<List<String>> res) {
		if (beginWord.equals(endWord)) {
			res.add(new ArrayList<>(path));
			return;
		}

		if (!map.containsKey(beginWord)) {
			return;
		}

		Set<String> successorWords = map.get(beginWord);
		for (String nextWord : successorWords) {
			path.addLast(nextWord);
			dfs(nextWord, endWord, map, path, res);
			path.removeLast();
		}
	}




	public static void main(String[] args) {
		String[] data = {"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"};
		List<String> wordList = Arrays.asList(data);

		System.out.println(JSON.toJSONString(findLadders_1("qa", "sq", wordList)));

	}

}
