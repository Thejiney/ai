package strategy2.modularization;

import strategy2.interfaces.*;

public abstract class Car {
	private EngineImpl engine;
	private KmImpl km;
	private FuelImpl fuel;

	public void drive() {
		System.out.println("드라이브할 수 있습니다");
	}

	public abstract void shape();

	public void engine() {
		engine.engine();
	}

	public void km() {
		km.kmPerLiter();
	}

	public void fuel() {
		fuel.fuel();
	}

	public void setEngine(EngineImpl engine) {
		this.engine = engine;
	}

	public void setKm(KmImpl km) {
		this.km = km;
	}

	public void setFuel(FuelImpl fuel) {
		this.fuel = fuel;
	}

}
