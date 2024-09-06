package strategy1.step1;

public class RobotTestMain {
	public static void main(String[] args) {
		SuperRobot superRobot = new SuperRobot();
		StandardRobot standardRobot = new StandardRobot();
		LowRobot lowRobot = new LowRobot();
		superRobot.shape();
		superRobot.actionWalk();
		superRobot.actionRun();
		System.out.println("--------------------");
		superRobot.actionFly();
		superRobot.actionMissile();
		superRobot.actionKnife();
		System.out.println("--------------------");
		standardRobot.shape();
		standardRobot.actionWalk();
		standardRobot.actionRun();
		System.out.println("--------------------");
		standardRobot.actionFly();
		standardRobot.actionMissile();
		standardRobot.actionKnife();
		System.out.println("--------------------");
		lowRobot.shape();
		lowRobot.actionWalk();
		lowRobot.actionRun();
		System.out.println("--------------------");
		lowRobot.actionFly();
		lowRobot.actionMissile();
		lowRobot.actionKnife();
		System.out.println("--------------------");
	}
}
