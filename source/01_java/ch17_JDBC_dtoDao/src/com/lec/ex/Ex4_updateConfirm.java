package com.lec.ex;

import java.util.Scanner;

import com.lec.dao.DeptRepository;
import com.lec.dto.Dept;

public class Ex4_updateConfirm {
	public static void main(String[] args) {
		DeptRepository deptRepository = DeptRepository.getInstance();
		Scanner scanner = new Scanner(System.in);
		System.out.print("수정할 부서번호는 > ");
		int deptno = scanner.nextInt();
		Dept dept = deptRepository.getDept(deptno); // 해당부서번호가 있는지 조회
		if (dept != null) {
			System.out.print("수정할 부서이름은 > ");
			String dname = scanner.next();
			System.out.print("수정할 부서위치는 > ");
			String loc = scanner.next();

			deptRepository.updateDept(deptno, dname, loc);
		} else {
			System.out.println("해당 부서번호는 유효하지 않습니다.");
		}
		scanner.close();
	}
}