package mergeSortDemo;

import java.util.Arrays;

public class mergoSortDemo {
	
	public static void main(String args[]){
		long start = System.currentTimeMillis();
		System.out.println(start);
		
		int[] abc = {12,32,11,-15,27,33,22,19,28,13,17};
		int[] aaa = Arrays.copyOf(abc, abc.length);
		
		DoMerge(aaa);
		System.out.println(Arrays.toString(abc));
		System.out.println(Arrays.toString(aaa));
		long end = System.currentTimeMillis();
		
		System.out.println(end);
		System.out.println("running time :" + (end - start));
	}
	public static void DoMerge(int[] arr){
		int m = arr.length/2;
		int[] arr1 = Arrays.copyOf(arr, m);
		int[] arr2 = Arrays.copyOfRange(arr, m, arr.length);
		if(m>0){
			DoMerge(arr1);
			DoMerge(arr2);
			doSort(arr1,arr2,arr);
		}		
	}
	public static void doSort(int[] arr1,int[] arr2,int[] result){
		int i = 0;
		int j = 0;
		int k = 0;
		int[] temp = new int[ arr1.length + arr2.length ];
		while(i<arr1.length && j < arr2.length) {
			if(arr1[i] > arr2[j]){
				temp[k++] = arr1[i++];
			} else{
				temp[k++] = arr2[j++];
			}
		}
		while(i<arr1.length) {
			temp[k++] = arr1[i++];
		}
		while(j<arr2.length) {
			temp[k++] = arr2[j++];
		}
		for(i=0; i <temp.length; i++) {
			result[i] =temp[i];
		}
	}
}
