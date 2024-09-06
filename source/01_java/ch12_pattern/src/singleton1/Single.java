package singleton1;

/* 데이터 영역 메모리 	| heap메모리 영역
 * 클래스(설계도)static	| 일반변수 */
public class Single {
	private int i;
	private static Single INSTANCE = new Single();

	public static Single getInstance() {
		return INSTANCE;
	}
//	private static Single INSTANCE;
//
//	public static Single getInstance() {
//		if (INSTANCE == null) {
//			INSTANCE = new Single();
//		}
//		return INSTANCE;
//	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

}
