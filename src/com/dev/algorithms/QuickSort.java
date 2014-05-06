package com.dev.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class QuickSort {
	
	private static int array[];
	private static int length;

	public static void sort(int[] inputRandomArray) {
		
		if (inputRandomArray == null || inputRandomArray.length == 0) {
			return;
		}
		array = inputRandomArray;
		length = inputRandomArray.length;
		quickSort(0, length - 1);
	}

	private static void quickSort(int lowIndexNumber, int highIndexNumber) {
		
		int i = lowIndexNumber;
		int j = highIndexNumber;
		// calculate pivot number, I am taking pivot as middle index number
		int pivotNum = array[lowIndexNumber+(highIndexNumber-lowIndexNumber)/2];
		// Divide into two arrays
		while (i <= j) {
			/**
			 * In each iteration, we will identify a number from left side which 
			 * is greater then the pivot value, and also we will identify a number 
			 * from right side which is less then the pivot value. Once the search 
			 * is done, then we exchange both numbers.
			 */
			while (array[i] < pivotNum) {
				i++;
			}
			while (array[j] > pivotNum) {
				j--;
			}
			if (i <= j) {
				swapNumbers(i, j);
				//move index to next position on both sides
				i++;
				j--;
			}
		}
		// call quickSort() method recursively
		if (lowIndexNumber < j)
			quickSort(lowIndexNumber, j);
		if (i < highIndexNumber)
			quickSort(i, highIndexNumber);
	}

	private static void swapNumbers(int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public static void main(String a[]){
		String size = null;
		System.out.println("Enter the size of random numbers");
		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(
				System.in));
		try {
			size = bufferRead.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

		int newsize = Integer.parseInt(size);
		int[] a1 = new int[newsize];
		Random randomGenerator = new Random();

		for (int idx = 0; idx < newsize; idx++) {
			int randomInt = randomGenerator.nextInt(100);
			a1[idx] = randomInt;
		}

		System.out.println("Generated random numbers are :");

		for (int idx = 0; idx < newsize; idx++) {

			System.out.print(a1[idx] + " ");
		}

		long startTime = System.currentTimeMillis();

		sort(a1);

		long endTime = System.currentTimeMillis();

		System.out.println("\n sorted array");

		for (int i = 0; i < a1.length; i++) {
			System.out.print(a1[i] + " ");

		}

		int mb = 1024 * 1024;
		Runtime runtime = Runtime.getRuntime();

		System.out.println("\n Heap utilization statistics [MB]");

		System.out.println("\n Used Memory:"
				+ (runtime.totalMemory() - runtime.freeMemory()) / mb);
		System.out.println("\n Free Memory:" + runtime.freeMemory() / mb);
		System.out.println("\n Total Memory:" + runtime.totalMemory() / mb);

		System.out.println("\n Max Memory:" + runtime.maxMemory() / mb);

		long cpuTime = endTime - startTime;
		System.out.println("\n Usage Cpu time: " + cpuTime + " in ms");

	}
}