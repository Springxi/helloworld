package day1;

import java.util.Arrays;

public class InsertSort {

	
	
	public static void insertSort(int arr[]) {
		if (arr == null || arr.length < 2 ) return ;
		
		for (int end = 1  ;end < arr.length ;end ++) {
		
			/*
			 * arr[end] insert   arr   length = end-1
			 * if do it in start,it will overwrite element
			 * so begin at the end 
			 */
			for (int j = end - 1; j >= 0 && arr[j] > arr[j+1]; j--) {
				swap(arr,j,j+1);
			}
				
		}
		
	}
	
	public static void swap (int arr[] ,int i ,int j ) {
		arr[i] = arr[i] ^ arr[j];
		arr[j] = arr[i] ^ arr[j];
		arr[i] = arr[i] ^ arr[j];
		
	}
	
	

	//for test
	public static int [] generateRandomArray(int maxSize ,int maxValue) {
		
		int [] arr = new int [(int)((maxSize + 1 )* Math.random())];
		for (int i = 0 ;i < arr.length ;i ++) {
			arr[i] = (int)((maxValue+1) * Math.random()) - (int)(maxValue * Math.random()); 
		}
		
		return arr;
	}
	
	
	
	
	public static int [] copyArray ( int arr[]) {
		if (arr == null ) {
			return null ;
		}
		int [] res  = new int [arr.length];
		for (int i = 0 ; i < arr.length ;i ++) {
			res[i] = arr[i];
		}
		return res;
		
	}
	
	
	
	public static void print (int arr[]) {
		for (int i = 0 ; i < arr.length ; i++ ) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
	}
	
	public static void comparator (int arr[]) {
		Arrays.sort(arr);
	}
	
	
	
	public static boolean isEqual (int arr[], int res []) {
		if ((arr == null && res != null )|| (arr != null && res == null)) return false;
		if (arr == null && res == null) 	return true;
		if (arr.length != res.length) return false;
		for (int i = 0 ;i < arr.length ; i++ ) {
			if (arr[i] != res[i]) 	return false;
		}
		return true ;
	}
	
	
	
	

	public static void main(String[] args) {
		
		int maxSize = 10;
		int maxValue = 100;
		int testTime = 1000;
		boolean suceed = true;
		
		for (int i = 0 ; i < testTime ; i ++) {
		
			int [] arr1 = generateRandomArray(maxSize , maxValue);
			int [] arr2 = copyArray(arr1);
			insertSort(arr1);
			comparator(arr2);
			if (!isEqual (arr1,arr2)) {
				suceed = false;
				//System.out.println("********************");
				print(arr1);
				print(arr2);
				break;
			
			}
		
		}
		
		System.out.println(suceed?  "Nice!":"Flucking Fucked !");
		
		
	}
}
