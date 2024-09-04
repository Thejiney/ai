package com.lec.quiz;

import java.util.Arrays;

// 76,45,34,89,50  5개의 값을 배열로 초기화 하고 이들 값들을 크기 순으로 나타내는 프로그램을 작성 하시오.
// 배열의 오름차순 정렬
public class Quiz1_sort {
	public static void main(String[] args) {
		int[] arr = { 76, 45, 34, 89, 50 };
		
//		for (int a : arr) {
//			System.out.print(a + "\t");
//		}
		System.out.println("정렬전 :" + Arrays.toString(arr));
		
		// 정렬
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					// i번째와 j번째 바꿔
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}//if
			}//for-j
		}//for-i
		
//		for (int i = 0; i < arr.length; i++) {
//			System.out.print(arr[i] + " ");
//		}
//		System.out.println();
		System.out.println("정렬후 :" + Arrays.toString(arr));
	}
}
