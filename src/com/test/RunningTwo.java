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

public class RunningTwo {
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arrOriginal = { 7,2,3,10,2,4,8,1   };
		int[] arrA = {7,2,3,10,2,4,8,1   };
	 
		int k = arrA.length;
		int n = arrA.length;
		ArrayList<Integer> listRes= new ArrayList<>(arrA.length);

		methodArr(arrA, k, n, listRes);

		Integer maxValue = methodListToArray(listRes);
        
		System.out.print("Given an array " + Arrays.toString(arrOriginal) + " then return " + maxValue);
	}

	private static Integer methodListToArray(ArrayList<Integer> listRes) {
		// Convert ArrayList to Array
        Integer[] array = listRes.toArray(new Integer[0]);
		Integer maxValue = array[0] ;

		for (int i = 0; i < array.length; i++) {
			if (array[i] > maxValue) {
				maxValue = array[i];
			}
		}
		return maxValue;
	}

	private static void methodArr(int[] arrA, int k, int n, ArrayList<Integer> listRes) {
		reverse(arrA, n , k); 
		for (int i = 0; i < arrA.length; i++) {
			int next = -1; 
			for (int j = i+1; j < arrA.length; j++) {
				int arrMinElement;
				if (arrA[i] > arrA[j]) 
                { 
                    next = arrA[j]; 
                    
                    arrMinElement = arrA[i] - next ;
                    listRes.add(arrMinElement);
                    
                }
				else {
					 next = arrA[j]; 
	                 arrMinElement = arrA[i] - next ;
					if (arrA[i] - arrA[j] <=  0) {
						listRes.add(arrMinElement);
					}
				}
			}

		}
	}
	
	// Function to reverse every sub-array formed by 
    // consecutive k elements 
    static void reverse(int arr[], int n, int k) 
    { 
        for (int i = 0; i < n; i += k) 
        { 
            int left = i; 
      
            // to handle case when k is not multiple 
            // of n 
//            System.out.println("=================================================================");
//            System.out.println("n = " + n);
//            System.out.println("k = " + k);
            int right = Math.min(i + k - 1, n - 1); 
            int temp; 
//            System.out.println("i !r    = " + i);
//            System.out.println("left !r = " + left);
//            System.out.println("right !r= " + right);
            
//            System.out.println("=================================================================");
            
            // reverse the sub-array [left, right] 
            while (left < right) 
            { 
//            	System.out.println("i reverse      = " + i);
                
                temp=arr[left]; 
//                System.out.println("arr[left]    = " + arr[left]);
//                System.out.println("arr[right]   = " + arr[right]);
                arr[left]=arr[right]; 
//                System.out.println("arr[left]    = " + arr[right]);
//                System.out.println("arr[right]   = " + arr[left]);
                arr[right]=temp; 
//                System.out.println("temp         = " + temp);
                left+=1; 
                right-=1; 
//                System.out.println("left reverse = " + left);
//                System.out.println("right reverse= " + right);
                
            } 
        } 
    } 


}