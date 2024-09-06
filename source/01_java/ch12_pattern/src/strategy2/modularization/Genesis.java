package strategy2.modularization;

import strategy2.interfaces.*;

public class Genesis extends Car {
	public Genesis() {
		setEngine(new EngIneHigh());
		setKm(new Km10());
		setFuel(new FuelGasoline());
	}

	public void shape() {
		System.out.println("★제네시스 door, 제네시스sheet, 제네시스handle로 이루어져 있습니다★");
	}

}
