package singleton2;

public class TestMain {
	public static void main(String[] args) {
		FirstClass firstobj = new FirstClass();
		SecondClass secondobj = new SecondClass();
		SingletonClass singobj = SingletonClass.getInstance();
		System.out.println("main함수에서 싱글톤 객체 i 값은 " + singobj.getI());
	}
}
