package com.hust.soict.VuThanhTung.helper;

public class InsertionSort implements NumberSorter{

	@Override
	public void sort(int[] arr) {
		// TODO Auto-generated method stub
		int key ,i ,j;
		for (i = 1; i < arr.length; i++) {
			key = arr[i];
			for (j = i-1; j >= 0 && arr[j] > key; j--)
				arr[j+1] = arr[j];
			arr[j+1] = key;
		}
	}

}
