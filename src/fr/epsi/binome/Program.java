package fr.epsi.binome;

import java.util.Random;

public class Program {

	private static final int ORDER_NUM = 200;
	private static final long ORDER_INTERVAL = 100;

	public static void main(String[] args) throws InterruptedException {
		Cocktail [] carte = {
			new Cocktail("Driver's punch", new String[] { "Cranberry juice", "Blood orange juice", "lime" }),
			new Cocktail("Bar", new String[] { "drink2", "drink3" }),
			new Cocktail("FooBar", new String[] { "drink3", "drink1" })
		};
		Backlog orders = new Backlog();
		Barman [] team = {
			new Barman("Tata", orders),
			new Barman("Toto", orders),
			new Barman("Titi", orders),
			new Barman("Tutu", orders)
		};
		for(Barman member : team) {
			member.start();
		}
		Random customers = new Random();
		for(int i=0; i<ORDER_NUM; i++) {
			int choice = customers.nextInt(carte.length);
			orders.enqueue(carte[choice]);
			Thread.sleep(ORDER_INTERVAL);
		}
		for(Barman member : team) {
			member.join();
		}
	}
}