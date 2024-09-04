package com.lec.loop;

//1~10까지 누적합 출력 : 55
//1~10까지 누적합 출력 1+2+3 ... +9+10
public class Ex02for {
	public static void main(String[] args) {
		int total = 0;
		for(int i=1; i<=10;i++) {
			total += i; //total = total +i;
			
			if(i<10) {
				System.out.print(i+"+");
			}else {
				System.out.print(i+"=");
			}
			
		}
		System.out.println(total);
	
//		total = total + 1;  //1
//		total = total + 2;	//1+2(3)
//		total = total + 3;	//1+2+3(6)
//		total = total + 4;
		
	}
}
