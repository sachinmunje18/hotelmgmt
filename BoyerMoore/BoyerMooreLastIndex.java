package com.BoyerMoore;

import java.util.Arrays;

public class BoyerMooreLastIndex {

	private static final int CHAR_SIZE = 256; // Assuming ASCII characters

	public static int findLastIndex(String text, String pattern) {
		int n = text.length();
		int m = pattern.length();

		if (m > n) {
			return -1; // Pattern longer than text
		}

		int[] last = buildLastArray(pattern);

		int i = m - 1; // index for text
		int j = m - 1; // index for pattern

		while (i < n) {
			if (pattern.charAt(j) == text.charAt(i)) {
				if (j == 0) {
					return i; // Found a match
				}
				i--;
				j--;
			} else {
				int lastChar = getLastIndex(last, text.charAt(i));
				i = i + m - Math.min(j, 1 + lastChar);
				j = m - 1;
			}
		}

		return -1; // Pattern not found
	}

	private static int[] buildLastArray(String pattern) {
		int[] last = new int[CHAR_SIZE];
		Arrays.fill(last, -1);

		for (int i = 0; i < pattern.length(); i++) {
			last[pattern.charAt(i)] = i;
		}

		return last;
	}

	private static int getLastIndex(int[] last, char c) {
		return last[c];
	}

	public static void main(String[] args) {
		String text = "abacabadabacaba";
		String pattern = "abacaba";

		int lastIndex = findLastIndex(text, pattern);

		if (lastIndex == -1) {
			System.out.println("Pattern not found in text.");
		} else {
			System.out.println("Last occurrence of pattern starts at index: " + lastIndex);
		}
	}
}
