package fr.epsi.binome;

import java.util.ArrayList;

public class Cocktail {

	private String name;
	private ArrayList<Bottle> bottles;

	public Cocktail(String name, ArrayList<Bottle> bottles) {
		this.name = name;
		this.bottles = bottles;
	}

	public String getName() {
		return this.name;
	}

	public ArrayList<Bottle> getBottles() {
		return this.bottles;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.name);
		sb.append(" (");
		for (Bottle bottle : this.bottles) {
			sb.append(bottle.getName()).append(" ");
		}
		return sb.append(")").toString();
	}
}
