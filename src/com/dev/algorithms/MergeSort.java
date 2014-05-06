package com.dev.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class MergeSort {
	
	public static void main(String a[]) {
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

		mergeSort(a1, 0, a1.length - 1);

		long endTime = System.currentTimeMillis();

		System.out.println("\n sorted array");

		for (int i = 0; i < a1.length; i++) {
			System.out.print(a1[i] + " ");

		}

		int mb = 1024 * 1024;
		Runtime runtime = Runtime.getRuntime();

		System.out.println("\nHeap utilization statistics [MB]\n");

		System.out.println("\nUsed Memory:"
				+ (runtime.totalMemory() - runtime.freeMemory()) / mb);
		System.out.println("\nFree Memory:" + runtime.freeMemory() / mb);
		System.out.println("\nTotal Memory:" + runtime.totalMemory() / mb);

		System.out.println("\nMax Memory:" + runtime.maxMemory() / mb);

		long cpuTime = endTime - startTime;
		System.out.println("\n Usage Cpu time: " + cpuTime + " in ms");

	}

	public static void mergeSort(int randomArray[], int leastNum, int maxNum) {
		int low = leastNum;
		int high = maxNum;
		if (low >= high) {
			return;
		}

		int middle = (low + high) / 2;
		mergeSort(randomArray, low, middle);
		mergeSort(randomArray, middle + 1, high);
		int endNumber = middle;
		int startNumber = middle + 1;
		while ((leastNum <= endNumber) && (startNumber <= high)) {
			if (randomArray[low] < randomArray[startNumber]) {
				low++;
			} else {
				int Temp = randomArray[startNumber];
				for (int k = startNumber - 1; k >= low; k--) {
					randomArray[k + 1] = randomArray[k];
				}
				randomArray[low] = Temp;
				low++;
				endNumber++;
				startNumber++;
			}
		}
	}
}