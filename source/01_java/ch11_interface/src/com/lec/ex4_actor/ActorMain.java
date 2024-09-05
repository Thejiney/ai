package com.lec.ex4_actor;

public class ActorMain {
	public static void main(String[] args) {
		Actor park = new Actor("박보검");
		park.canCatchCriminal();
		park.canSearch();
		park.outFire();
		park.saveMan();
		park.makePizza();
		park.makeSpaghetti();

		System.out.println();

		IPoliceMan policePark = park;
		policePark.canCatchCriminal();
		policePark.canSearch();
//		policePark.outFire();
//		policePark.saveMan();
//		policePark.makePizza();
//		policePark.makeSpaghetti();

		System.out.println();

		IFireFighter fighterPark = park;
//		fighterPark.canCatchCriminal();
//		fighterPark.canSearch();
		fighterPark.outFire();
		fighterPark.saveMan();
//		fighterPark.makePizza();
//		fighterPark.makeSpaghetti();

		System.out.println();

		IChef chefPark = park;
//		chefPark.canCatchCriminal();
//		chefPark.canSearch();
//		chefPark.outFire();
//		chefPark.saveMan();
		chefPark.makePizza();
		chefPark.makeSpaghetti();
	}
}
