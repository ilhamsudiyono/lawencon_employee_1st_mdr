package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.sun.xml.internal.bind.v2.model.util.ArrayInfoUtil;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import sun.reflect.generics.tree.ArrayTypeSignature;

public class RunningOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arrA = { 4, 7, 6, 15, 13, 9 };
		int[] arrB = { 1, 14, 14, 12, 14, 10 };
		int[] arrC = { 12, 6, 4, 9, 8, 11 };
		int[] arrD = { 7, 14, 3, 7, 10, 3 };

		int[] allArr = merge(arrA, arrB);
		int[] allArrSecond = merge(arrC, arrD);
		int[] allArrRes = merge(allArr, allArrSecond);

		bubbleSort(allArrRes);

		ArrayList<Integer> listOfInts = new ArrayList<>(allArrRes.length);
		boolean countValue[] = new boolean[allArrRes.length];

		Arrays.fill(countValue, false);
		resultSort(allArrRes, listOfInts);

		System.out.print("Result Sort: " + listOfInts);
		CountValue(allArrRes, countValue);
	}

	private static void CountValue(int[] allArrRes, boolean[] countValue) {
		for (int i = 0; i < allArrRes.length; i++) {
			
			if (countValue[i] == true) 
	            continue; 
	  
	        // Count freq 
	        int count = 1; 
	        for (int j = i + 1; j < allArrRes.length; j++) { 
	            if (allArrRes[i] == allArrRes[j]) { 
	            	countValue[j] = true; 
	                count++; 
	            } 
	        }
	        
	       
	        System.out.println(allArrRes[i] + ":" + count);

		}
	}

	private static void resultSort(int[] allArrRes, ArrayList<Integer> listOfInts) {
		for (int i = 0; i < allArrRes.length; i++) {
			if (i == 0) {
				listOfInts.add(allArrRes[i]);

			} else if (allArrRes[i] != allArrRes[i - 1]) {
				listOfInts.add(allArrRes[i]);

			}

		}
	}

	public static int[] merge(int[] arrA, int[] arrB) {

		int arrMerge = arrA.length + arrB.length;
		int[] resultMerge = new int[arrMerge];
		System.arraycopy(arrA, 0, resultMerge, 0, arrA.length);
		System.arraycopy(arrB, 0, resultMerge, arrA.length, arrB.length);

		return resultMerge;

	}

	static void bubbleSort(int[] arr) {
		int n = arr.length;
		int temp = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {
				if (arr[j - 1] > arr[j]) {
					// swap elements
					temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				}

			}
		}
	}

}