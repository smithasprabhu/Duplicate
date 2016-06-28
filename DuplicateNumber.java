package com.sei;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Logger;

/*  This is a class to remove the duplicate numbers from an array
 * 
 */
public class DuplicateNumber {

	static Logger logger = Logger.getLogger("DuplicateNumber");

	public int[] randomIntegers = { 1, 2, 34, 34, 25, 1, 45, 3, 26, 85, 4, 34, 86, 25, 43, 2, 1, 10000, 11, 16, 19, 1,
			18, 4, 9, 3, 20, 17, 8, 15, 6, 2, 5, 10, 14, 12, 13, 7, 8, 9, 1, 2, 15, 12, 18, 10, 14, 20, 17, 16, 3, 6,
			19, 13, 5, 11, 4, 7, 19, 16, 5, 9, 12, 3, 20, 7, 15, 17, 10, 6, 1, 8, 18, 4, 14, 13, 2, 11 };

	/*
	 * Main method to invoke the program
	 */
	public static void main(String[] args) {
		DuplicateNumber dup = new DuplicateNumber();

		logger.info(" removing the duplicates in the array ");
		long start = System.currentTimeMillis();
		dup.removedupLinkedHashSet();
		long end = System.currentTimeMillis();
		long ts = end - start;
		logger.info(" remove duplicate using linked hashset completed in time - " + ts);

		start = System.currentTimeMillis();
		dup.removedupHashSet();
		end = System.currentTimeMillis();
		ts = end - start;
		logger.info(" remove duplicate using hashset completed in time - " + ts);

		start = System.currentTimeMillis();
		int[] whitelist = removeDuplicates(dup.randomIntegers);
		end = System.currentTimeMillis();
		ts = end - start;
		logger.info(" remove duplicate using arrays completed in time - " + ts);

		for (int j = 0; j < whitelist.length; j++) {
			System.out.println(whitelist[j]);
		}

	}

	/*
	 * This method is used to remove the duplicate numbers by using the hashset
	 */
	public void removedupLinkedHashSet() {

		int end = randomIntegers.length;
		Set<Integer> uniqueSet = new LinkedHashSet<Integer>(); // LinkedHashSet maintains the original order															
		logger.info(" Adding to the LinkedHashSet ");
		for (int i = 0; i < end; i++) {
			uniqueSet.add(randomIntegers[i]);
		}

		logger.info(" Iterating the array after removing the duplicate ");
		Iterator<Integer> it = uniqueSet.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	public void removedupHashSet() {

		int end = randomIntegers.length;
		Set<Integer> uniqueSet = new HashSet<Integer>(); // Hashset is faster and removes the  duplicates but  doesn't maintain the original order
															
		logger.info(" Adding to the HashSet ");
		for (int i = 0; i < end; i++) {
			uniqueSet.add(randomIntegers[i]);
		}

		logger.info(" Iterating the array after removing the duplicate ");
		Iterator<Integer> it = uniqueSet.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	public static int[] removeDuplicates(int[] arr) {
		int end = arr.length;

		for (int i = 0; i < end; i++) {
			for (int j = i + 1; j < end; j++) {
				if (arr[i] == arr[j]) {
					
					arr[j] = arr[end - 1];
					end--;
					j--;
				}
			}
		}

		int[] whitelist = new int[end];
		
		System.arraycopy(arr, 0, whitelist, 0, end);
		return whitelist;
	}

}
