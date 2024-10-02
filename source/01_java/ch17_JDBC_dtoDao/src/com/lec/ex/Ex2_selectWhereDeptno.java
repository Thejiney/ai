package com.lec.ex;
// 부서번호를 입력받아 부서정보 출력

import java.util.Scanner;

import com.lec.dao.DeptRepository;
import com.lec.dto.Dept;

public class Ex2_selectWhereDeptno {
	public static void main(String[] args) {
		DeptRepository repository = DeptRepository.getInstance();
		Scanner scanner = new Scanner(System.in);
		System.out.print("원하는 부서번호는 > ");
		int deptno = scanner.nextInt();
		scanner.close();
		Dept dept = repository.getDept(deptno);
		if (dept != null) {
			System.out.println(dept);
		} else {
			System.out.println("해당 부서는 존재하지 않습니다.");
		}
	}
}
