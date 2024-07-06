package com.rabinKarp;

import java.util.ArrayList;
import java.util.List;

public class RabinKarpAlgorithm {

	private static final int PRIME = 101; // A prime number to calculate hash

	public static List<Integer> rabinKarpSearch(String text, String pattern) {
		List<Integer> positions = new ArrayList<>();
		int n = text.length();
		int m = pattern.length();

		if (m > n) {
			return positions;
		}

		int patternHash = calculateHash(pattern, m);
		int textHash = calculateHash(text.substring(0, m), m);

		for (int i = 0; i <= n - m; i++) {
			if (patternHash == textHash && checkEquals(text, pattern, i)) {
				positions.add(i);
			}
			if (i < n - m) {
				textHash = recalculateHash(text, textHash, i, m);
			}
		}

		return positions;
	}

	private static int calculateHash(String str, int len) {
		int hash = 0;
		for (int i = 0; i < len; i++) {
			hash += str.charAt(i) * Math.pow(PRIME, i);
		}
		return hash;
	}

	private static int recalculateHash(String str, int oldHash, int index, int len) {
		int newHash = oldHash - str.charAt(index);
		newHash /= PRIME;
		newHash += str.charAt(index + len) * Math.pow(PRIME, len - 1);
		return newHash;
	}

	private static boolean checkEquals(String text, String pattern, int startIndex) {
		for (int i = 0; i < pattern.length(); i++) {
			if (pattern.charAt(i) != text.charAt(startIndex + i)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String text = "AABAACAADAABAAABAA";
		String pattern = "AABA";

		List<Integer> positions = rabinKarpSearch(text, pattern);

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
