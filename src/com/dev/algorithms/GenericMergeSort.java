package com.dev.algorithms;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;


public class GenericMergeSort {
  @SuppressWarnings("unused")
public static void main(String[] args) {
  
    FileInputStream in;
	try {
		//Read the contents from the file
		in = new FileInputStream("C:\\Users\\rtummala\\pennyinput");
		BufferedReader br = new BufferedReader(new InputStreamReader(in));

	    String strLine;
	    ArrayList<Object> filearray;
	    filearray = new ArrayList<>();
	    int incr = 0;
	    //Add the contents of the file to an ArrayList
	    while ((strLine = br.readLine()) != null) {
			filearray.add(br.readLine());
			incr++;
		}
	    in.close();
	    //get strings from an ArrayList to an array
	    String[] fa = new String[filearray.size()];
	    for (int m = 0; m < filearray.size(); m++) {
			fa[m]=(String) filearray.get(m);
		}
	    //compare the strings
	    Comparator<String> compr = new Comparator<String>() {
	        public int compare(String d1, String d2) {
	          return d1.compareTo(d2);
	        }
	      };
	      MergeSorter.sort(fa, compr);
	      for (int i = 0; i < fa.length; i++){
	        System.out.print(fa[i]+"\n");
	      }
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}   
  }
}

class MergeSorter {

  public static <E> void sort(E[] a, Comparator<? super E> comp) {
    mergeSort(a, 0, a.length - 1, comp);
  }


  private static <E> void mergeSort(E[] a, int from, int to, Comparator<? super E> comp) {
    if (from == to)
      return;
    int mid = (from + to) / 2;
    // Sort the first and the second half
    mergeSort(a, from, mid, comp);
    //Sort the right side
    mergeSort(a, mid + 1, to, comp);
    //combine them
    merge(a, from, mid, to, comp);
  }

  @SuppressWarnings("unchecked")
private static <E> void merge(E[] a, int from, int mid, int to, Comparator<? super E> comp) {
    int n = to - from + 1;
    Object[] values = new Object[n];

    int fromValue = from;

    int middleValue = mid + 1;

    int index = 0;
    // Copy the smallest values from either the left or the right side back to the original array
    while (fromValue <= mid && middleValue <= to) {
      if (comp.compare(a[fromValue], a[middleValue]) < 0) {
        values[index] = a[fromValue];
        fromValue++;
      } else {
        values[index] = a[middleValue];
        middleValue++;
      }
      index++;
    }
    // Copy the rest of the left side of the array into the target array
    while (fromValue <= mid) {
      values[index] = a[fromValue];
      fromValue++;
      index++;
    }
    while (middleValue <= to) {
      values[index] = a[middleValue];
      middleValue++;
      index++;
    }

    for (index = 0; index < n; index++)
      a[from + index] = (E) values[index];
  }
}