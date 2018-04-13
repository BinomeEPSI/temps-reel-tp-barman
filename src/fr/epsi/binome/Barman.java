package fr.epsi.binome;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Barman extends Thread {

	private String name;

	private Backlog orders;

	private Date workDay;

	private int drinksPrepared;

	public Barman(String name, Backlog orders) {
		this(name, orders, 5);
	}
	
	public Barman(String name, Backlog orders, int minuteOfWork) {
		this.name = name;
		this.orders = orders;
		Calendar work = Calendar.getInstance();
		work.add(Calendar.MINUTE, minuteOfWork);
		this.workDay = work.getTime();
		this.drinksPrepared = 0;
	}

	@Override
	public void run() {
		Cocktail cCocktail;
		long seconds = 0;

		do {
			Date now = new Date();
			long timeLeftAtWork = this.workDay.getTime() - now.getTime();
			seconds = TimeUnit.MILLISECONDS.toSeconds(timeLeftAtWork);

			cCocktail = orders.dequeue();
			if (cCocktail != null) {
				this.drinksPrepared++;
				String message = String.format(
						"%s has prepared  \t%s\t\tHe has prepared %d drinks and will continue to work for %d seconds",
						this.name, cCocktail, this.drinksPrepared, seconds);
				System.out.println(message);
			}

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.err.println("ERR --> " + e.getMessage());
			}
		} while (seconds > 0);

		String message = String.format("%s is out with %d drinks prepared !", this.name, this.drinksPrepared);
		System.out.println(message);
	}

}
