package day1;

import java.util.Arrays;

public class BubbleSort {
	
	public static void bubbleSort (int arr[] ) {
		if ( arr == null  || arr.length <2) return ;
		
		for (int i= arr.length - 1; i >  0 ; i --) {
			for (int j = 0  ; j < i ; j ++) {
				if (arr[j] > arr[j+1])
					swap(arr,j ,j+1);
			}
		}
	}

	public static void swap (int arr[],int i ,int j ) {
//		int temp = arr[i];
//		arr[i] = arr[j];
//		arr[j] = temp;
		arr[i] = arr[i] ^ arr[j];
		arr[j] = arr[i] ^ arr[j];
		arr[i] = arr[i] ^ arr[j];

	}
	
	public static void print(int arr[]) {
		if (arr == null) return ;
		for (int i = 0 ; i< arr.length ; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	
	public static int [] generateRandomArray(int maxSize ,int maxValue) {
		int [] arr = new int [(int) ((maxSize+1) * Math.random())];
		for (int i = 0 ; i < arr.length ; i ++  ) {
			arr[i] =(int) ((maxValue +1) * Math.random() )- (int) (maxValue*Math.random() );	
		}
		return arr; 
	}
	
	
	public static void comparator (int arr []) {
		Arrays.sort(arr);
	}
	
	
	public static int[] copyArray(int arr []) {
		if (arr == null) return null;
		int [] res = new int [arr.length];
		for (int i = 0 ;i <arr.length ;i ++) {
			res[i] = arr[i];
		}
		return res;
	}
	
	
	public static boolean isEqual(int arr [] ,int res []) {
		
		if (arr == null || res == null ) return true;
		if ((arr == null && res != null) || (arr != null && res == null)) return false ;
		if (arr.length != res.length) return false;
		for (int i =0 ; i <arr.length ; i++) {
			if (arr[i] != res[i]) return false;
		}
		return true;
				
	}
	
	public static void main(String[] args){
		int maxSize =10;
		int maxValue = 100;
		int testTime =1000;
		boolean suceed = true;
		for (int i = 0; i <testTime;i ++) {
			int [] arr2 = new int [maxSize];
			arr2 = generateRandomArray(maxSize,maxValue);
			int [] arr1 = copyArray(arr2);
			bubbleSort(arr2);
			comparator(arr1);
			if (!isEqual(arr2,arr1)) {
				suceed =false;
				print(arr1);
				print(arr2);
				break;
			}
		}
		
		System.out.println(suceed ? "Fine!" : "Fucking Fucked !");
		
		int [] arr = new int [maxSize];
		arr = generateRandomArray(maxSize,maxValue);
		print(arr);
		bubbleSort(arr);
		print(arr);
		
	}
}
