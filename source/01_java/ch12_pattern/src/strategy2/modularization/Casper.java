package strategy2.modularization;

import strategy2.interfaces.*;

public class Casper extends Car{
	public Casper() {
		setEngine(new EngineLow());
		setKm(new Km20());
		setFuel(new FuelDiesel());
	}
	@Override
	public void shape() {
		System.out.println("★캐스퍼door, 캐스퍼sheet, 캐스퍼handle로 이루어져 있습니다★");
	}
	
}
