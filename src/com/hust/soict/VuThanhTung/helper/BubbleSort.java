package com.hust.soict.VuThanhTung.helper;

public class BubbleSort implements NumberSorter{

	@Override
	public void sort(int[] arr) {
		// TODO Auto-generated method stub
		for (int i = 0; i < arr.length; i++) {
			boolean is_sorted = true;
			for (int j = 1; j < arr.length-i; j++) {
				if(arr[j-1] > arr[j]) {
					int temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
					is_sorted = false;
				}
			}
			if(is_sorted) break;
		}
	}

}
