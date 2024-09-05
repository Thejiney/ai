package com.lec.quiz;

// name, annalSalary, computePay(),computeIncentive()
public class SalaryEmployee extends Employee {
	private int annalsalary;

	public SalaryEmployee(String name, int annalsalary) {
		super(name);
		this.annalsalary = annalsalary;
	}

	@Override
	public int computePay() {
		return annalsalary / 12;
	}
}
