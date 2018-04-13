package fr.epsi.binome;

public class Backlog {
	
	private Cocktail cocktail;
	
	public void enqueue(Cocktail cocktail) {
		this.cocktail = cocktail;
	}
	
	public Cocktail dequeue() {
		return null;
	}
}
