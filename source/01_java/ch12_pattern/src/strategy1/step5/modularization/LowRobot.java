package strategy1.step5.modularization;

import strategy1.step4.interfaces.*;

public class LowRobot extends Robot {

	public LowRobot() {
		setFly(new FlyNo());
		setMissile(new MissileNo());
		setKnife(new KnifeNo());
	}

	@Override
	public void shape() {
		System.out.println("= = 로우로봇의 외형은 팔, 다리, 머리, 몸통이 있습니다 = =");
	}
}
