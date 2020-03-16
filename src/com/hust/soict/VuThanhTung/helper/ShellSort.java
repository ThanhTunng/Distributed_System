package com.hust.soict.VuThanhTung.helper;

public class ShellSort implements NumberSorter{

	@Override
	public void sort(int[] arr) {
		// TODO Auto-generated method stub
		int gap, i, j;
		for (gap = arr.length/2; gap>0; gap/=2) {
			for (i = gap; i < arr.length; i++) {
				int key = arr[i];
				for( j = i; j>=gap && arr[j-gap]>key; j-=gap)
					arr[j] = arr[j-gap];
				arr[j] = key;
			}
		}
	}
}
