package strategy2.modularization;

import strategy2.interfaces.FuelHybird;
import strategy2.interfaces.Km20;

public class CarTestMain {
	public static void main(String[] args) {
		Genesis genesis = new Genesis();
		Sonata sonata = new Sonata();
		Casper casper = new Casper();
		Car cars[] = { genesis, sonata, casper };

		for (Car car : cars) {
			car.drive();
			car.shape();
			car.engine();
			car.km();
			car.fuel();
			System.out.println();
		}

		System.out.println("소나타를 하이브리드로 교체하고 연비를 20으로 교체후 소나타는 다음과 같다");
		sonata.setFuel(new FuelHybird());
		sonata.setKm(new Km20());
		sonata.fuel();
		sonata.km();
	}
}
