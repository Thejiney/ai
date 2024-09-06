package strategy2.interfaces;

public class FuelHybird implements FuelImpl {

	@Override
	public void fuel() {
		System.out.println("전기 하이브리드로 움직입니다");
	}

}
