package fr.epsi.binome;

import java.util.LinkedList;

public class Backlog {
	
	private LinkedList<Cocktail> orders;
	
	public Backlog() {
		this.orders = new LinkedList<>();
	}
	
	public void enqueue(Cocktail cocktail) {
		synchronized (this.orders) {
			this.orders.add(cocktail);	
		}
	}
	
	public Cocktail dequeue() {
		synchronized (this.orders) {
			return this.orders.pollFirst();	
		}
	}
	
	public boolean isEmpty() {
		return this.orders.isEmpty();
	}
}
