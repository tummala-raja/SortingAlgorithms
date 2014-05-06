package com.dev.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class HeapSort {
	
	private static int[] a;
	private static int n;
	private static int left;
	private static int right;
	private static int largest;

	public static void buildheap(int[] a) {
		n = a.length - 1;
		for (int i = n / 2; i >= 0; i--) {
			maxheap(a, i);
		}
	}
	//The following method does maxHeap
	public static void maxheap(int[] a, int i) {
		//leftchild
		left = 2 * i;
		//rightchild
		right = 2 * i + 1;
		if (left <= n && a[left] > a[i]) {
			largest = left;
		} else {
			largest = i;
		}
		//get the largest value between the children and set to the internal node
		if (right <= n && a[right] > a[largest]) {
			largest = right;
		}

		if (largest != i) {
			exchange(i, largest);
			maxheap(a, largest);
		}
	}
	//Swap values
	public static void exchange(int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	public static void sort(int[] a0) {
		a = a0;
		buildheap(a);

		for (int i = n; i > 0; i--) {
			exchange(0, i);
			n = n - 1;
			maxheap(a, 0);
		}
	}

	public static void main(String[] args) {
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
		//Get random number for the array
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
        
		int mb = 1024*1024;
		Runtime runtime = Runtime.getRuntime();
      
        
        System.out.println("Heap utilization statistics [MB]\n");
         
        System.out.println("\nUsed Memory:"
            + (runtime.totalMemory() - runtime.freeMemory()) / mb);
        System.out.println("\nFree Memory:"
            + runtime.freeMemory() / mb);
        System.out.println("\nTotal Memory:" + runtime.totalMemory() / mb);
 
        System.out.println("\nMax Memory:" + runtime.maxMemory() / mb);
		
		long cpuTime = endTime - startTime;
		System.out.println("\n Usage Cpu time: " + cpuTime + " in ms");
	}
}
