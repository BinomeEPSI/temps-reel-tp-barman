package fr.epsi.binome;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Program {

	private static final int ORDER_NUM = 200;
	private static final long ORDER_INTERVAL = 100;

	public static void main(String[] args) throws InterruptedException {
		Bottle[] bottles = { new Bottle("Rhum"), new Bottle("Whisky"), new Bottle("Cranberry juice"),
				new Bottle("Blood orange juice"), new Bottle("Lime"), new Bottle("drink1"), new Bottle("drink2"),
				new Bottle("drink3") };

		BottlesList bar = new BottlesList();
		for (Bottle b : bottles) {
			bar.add(b);
		}

		Cocktail[] carte = {
				new Cocktail("Driver's punch",
						new ArrayList<Bottle>(Arrays.asList(bar.getDrink("Cranberry juice"),
								bar.getDrink("Blood orange juice"), bar.getDrink("drink1")))),
				new Cocktail("Bar",
						new ArrayList<Bottle>(Arrays.asList(bar.getDrink("drink1"), bar.getDrink("drink3")))),
				new Cocktail("FooBar",
						new ArrayList<Bottle>(Arrays.asList(bar.getDrink("drink3"), bar.getDrink("drink1")))) };

		Backlog orders = new Backlog();
		Barman[] team = { new Barman("Tata", orders), new Barman("Toto", orders), new Barman("Titi", orders),
				new Barman("Tutu", orders) };
		for (Barman member : team) {
			member.start();
		}
		Random customers = new Random();
		for (int i = 0; i < ORDER_NUM; i++) {
			int choice = customers.nextInt(carte.length);
			orders.enqueue(carte[choice]);
			Thread.sleep(ORDER_INTERVAL);
		}
		for (Barman member : team) {
			member.join();
		}
	}
}