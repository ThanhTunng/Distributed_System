package com.hust.soict.VuThanhTung.helper;

public class SelectionSort implements NumberSorter{
	public void sort(int arr[]) {
		int n = arr.length;
		
		for (int i = 0; i < n; i++) {
			int min_index = i;
			for (int j = i+1; j < n; j++) {
				if(arr[j] < arr[min_index])
					min_index = j;
			}
			int temp = arr[min_index];
			arr[min_index] = arr[i];
			arr[i] = temp;
		}
	}
}
