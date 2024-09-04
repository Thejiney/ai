package com.lec.quiz;

import java.util.Arrays;

//배열에 담긴 값의 합계, 평균, 최대값, 최소값을 구하는 프로그램을 작성하시오.

public class Quiz2 {
	public static void main(String[] args) {
		int[] arr = { 10, 20, 30, 40, 50, 12, 13 };
		System.out.println(Arrays.toString(arr));

		int sum = 0, max = arr[0], min = arr[0];
		double avg = 0;

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (max < arr[i]) {
				max = arr[i];
			}
			if (min > arr[i]) {
				min = arr[i];
			}
		}
		avg = (double) sum / arr.length;
		System.out.printf("합계:%d, 평균:%.1f, 최대값:%d, 최소값:%d\n", sum, avg, max, min);
		
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));

	}
}
