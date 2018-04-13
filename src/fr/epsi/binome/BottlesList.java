package fr.epsi.binome;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BottlesList {

	private ArrayList<Bottle> bottles;

	public BottlesList() {
		this.bottles = new ArrayList<>();
	}

	public void add(Bottle bottle) {
		this.bottles.add(bottle);
	}

	public Bottle getDrink(String name) {
		List<Bottle> selected = this.bottles.stream().filter(bottle -> bottle.getName().contains(name))
				.collect(Collectors.toList());
		return selected.size() == 0 ? null : selected.get(0);
	}
}
