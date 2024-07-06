package com.KMPalgorithim;

import java.util.ArrayList;
import java.util.List;

public class KMPAlgorithm {

	public static List<Integer> KMPSearch(String text, String pattern) {
		List<Integer> positions = new ArrayList<>();
		int[] lps = computeLPSArray(pattern);

		int i = 0; // index for text
		int j = 0; // index for pattern

		while (i < text.length()) {
			if (pattern.charAt(j) == text.charAt(i)) {
				j++;
				i++;
			}

			if (j == pattern.length()) {
				positions.add(i - j);
				j = lps[j - 1];
			} else if (i < text.length() && pattern.charAt(j) != text.charAt(i)) {
				if (j != 0) {
					j = lps[j - 1];
				} else {
					i++;
				}
			}
		}

		return positions;
	}

	private static int[] computeLPSArray(String pattern) {
		int[] lps = new int[pattern.length()];
		int len = 0; // length of the previous longest prefix suffix
		int i = 1;

		while (i < pattern.length()) {
			if (pattern.charAt(i) == pattern.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			} else {
				if (len != 0) {
					len = lps[len - 1];
				} else {
					lps[i] = 0;
					i++;
				}
			}
		}

		return lps;
	}

	public static void main(String[] args) {
		String text = "AABAACAADAABAAABAA";
		String pattern = "AABA";

		List<Integer> positions = KMPSearch(text, pattern);

		if (positions.isEmpty()) {
			System.out.println("Pattern not found in text.");
		} else {
			System.out.println("Pattern found at positions:");
			for (int pos : positions) {
				System.out.println(pos);
			}
		}
	}
}
