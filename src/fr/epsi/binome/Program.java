package fr.epsi.binome;

import java.util.Random;

public class Program {
	
	private static final int ORDER_NUM = 200;
	private static final long ORDER_INTERVAL = 100;

	public static void main(String[] args) throws InterruptedException {
		Cocktail[] carte = { 
				new Cocktail("Boisson 1", new String[] {"Ingredient A", "Ingrédient B"})
		};
		
		Backlog orders = new Backlog(); 
		Barman[] team = {
			new Barman("A", orders),
			new Barman("B", orders),
			new Barman("C", orders),
			new Barman("D", orders),
		};
		
		for (Barman member : team) {
			member.start();
		}
		
		Random customers = new Random();
		for (int i = 0; i < ORDER_NUM; i++) {
			int choice = customers.nextInt(carte.length);
			orders.enqueue(carte[choice]);
			Thread.sleep(ORDER_INTERVAL);
		}
		
		for (Barman barman : team) {
			barman.join();
		}

	}

}
