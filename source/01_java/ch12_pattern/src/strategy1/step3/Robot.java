package strategy1.step3;

public abstract class Robot {
	public void shape() {
		String className = getClass().getName(); // 클래스이름 "SuperRobot"
		int idx = className.lastIndexOf(".");
		String name = className.substring(idx + 1);
		System.out.println(name + "의 외형은 팔, 다리, 머리, 몸통이 있습니다 = = =");
	}

	public void actionWalk() {
		System.out.println("걸을 수 있습니다");
	}

	public void actionRun() {
		System.out.println("달릴 수 있습니다");
	}

	// @formatter:off
	public abstract void actionFly();
	public abstract void actionMissile();
	public abstract void actionKnife();
	// @formatter:on
}
