package com.lec.ex2_store;

// HeadQuarterStore를 상속받은 측에서 반드시 override 하도록
// 추상클래스 : 추상메소드가 1개 이상
public interface HeadQuarterStore {
	public void kimchi();

	public void bude();

	public void bibim();

	public void sunde();

	public void gongi();

	@Override
	public String toString();
}
