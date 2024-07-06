package com.navinPattern;

public class NaivePatternSearch {

	public static void searchPattern(String text, String pattern) {
		int n = text.length();
		int m = pattern.length();
		int comparisons = 0;

		for (int i = 0; i <= n - m; i++) {
			int j;
			for (j = 0; j < m; j++) {
				comparisons++;
				if (text.charAt(i + j) != pattern.charAt(j)) {
					break;
				}
			}
			if (j == m) {
				System.out.println("Pattern found at index " + i);
			}
		}

		System.out.println("Total comparisons: " + comparisons);
	}

	public static void main(String[] args) {
		String text = "AABAACAADAABAAABAA";
		String pattern = "AABA";

		System.out.println("Text: " + text);
		System.out.println("Pattern: " + pattern);

		System.out.println("Occurrences of pattern:");
		searchPattern(text, pattern);
	}
}
