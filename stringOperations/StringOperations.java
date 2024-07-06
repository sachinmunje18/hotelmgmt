package com.stringOperations;

public class StringOperations {

	public static String middleSubstring(String s1, String s2, int length) {
		String concatenated = s1.concat(s2);
		String reversed = new StringBuilder(concatenated).reverse().toString();

		int middleIndex = reversed.length() / 2;
		int startIndex = middleIndex - length / 2;
		int endIndex = startIndex + length;

		if (startIndex < 0) {
			startIndex = 0;
		}
		if (endIndex > reversed.length()) {
			endIndex = reversed.length();
		}

		return reversed.substring(startIndex, endIndex);
	}

	public static void main(String[] args) {
		String s1 = "Hello";
		String s2 = "World";
		int length = 5;

		String result = middleSubstring(s1, s2, length);
		System.out.println("Middle substring of length " + length + " after operations: " + result);
	}
}
