package com.cts.string;

import java.util.Arrays;
import java.util.Collections;

public class RevStrPosition {

	public static int getElementPosition(String arr[], String str) {
		Arrays.sort(arr, Collections.reverseOrder());
		for(int i=0; i<arr.length; i++) {
			if(arr[i].equals(str)) return i+1;
		}
		return -1;
	}
}
