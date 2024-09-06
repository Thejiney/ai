package singleton2;

public class SingletonClass {
	private int i = 10;
	private static SingletonClass INSTANCE;

	public static SingletonClass getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new SingletonClass();
		}

		return INSTANCE;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

}
