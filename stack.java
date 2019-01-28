package com.csc205.projects.project6;

/**
 * String util prints all non palindrome backwards 
 * <p>
 * has method to tell if it is palindrome, and a method to flip the word if it is not.
 * <p>
 * 
 * @author JAL2133386
 */

import jsjf.*;;

public class StringUtil {

	public static void main(String[] args) {

		// Are we not drawn onward to new era
		String testString = "Are we not drawn onward to new era?:*";
		System.out.println(stripSpaces(testString));
		System.out.println(upperCase(testString));
		System.out.println(lowerCase(testString));
		System.out.println(stripPunctuation(testString));

	}

	public static String stripSpaces(String s) {
		return s.replaceAll("\\s+", "");
	}
	
	public static String upperCase(String s) {
		return s.toUpperCase();
	}
	
	public static String lowerCase(String s) {
		return s.toLowerCase();
	}
	
	public static String stripNonAlpha(String s) {
		return s.replaceAll("\\W+", ""); 
	}
	
	/**
	 * Strips all kinds of stuff.
	 * 
	 * @param s any string 
	 * @return
	 */
	public static String stripPunctuation(String s) {
		return s.replaceAll("[.,<>?';:\"\\]\\[{}!@#$%^&*()_+-=]+" , ""); 
	}
	/**
	 * Method prints out non palindromes words backwards. 
	 * @param s any string
	 */
	public static void changeIt(String s) {
		
		String s2 = stripPunctuation(s);
		String[] words = s2.split(" ");
		for (String w: words) {
			if (!isPalindrome(w)) {
				LinkedStack<Character> stack = new LinkedStack<Character>();
				String backwards = "";
				for (int x = 0; x < w.length(); x++) {
					stack.push(w.charAt(x));
				}
				
				
				for (int i = 0; i < w.length(); i++) {
					backwards+= stack.pop();
				}
				
					System.out.print(backwards + " ");
				
			}
			
		}
		System.out.println();
		
	}
	/**
	 * 
	 * @param s any string 
	 * @return true or false depending on if the word is a palindrome
	 */
	public static boolean isPalindrome(String s) {
		String s3 = "";
		for (int x = 0; x < s.length(); x++) {
			if (s.charAt(x) != ' ') {
				s3+= s.charAt(x);
			}
		
			
		}
		String s2 = stripPunctuation(s3);
		LinkedStack<Character> stack = new LinkedStack<Character>();
		String backwards = "";
		for (int x = 0; x < s2.length(); x++) {
			stack.push(s2.charAt(x));
		}
		
		
		for (int i = 0; i < s2.length(); i++) {
			backwards+= stack.pop();
			
		}
		
		return backwards.equalsIgnoreCase(s2);
	}

}
