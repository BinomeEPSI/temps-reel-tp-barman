package fr.epsi.binome;

public class Cocktail {

	private String name;
	private String[] ingredients;

	public Cocktail(String name, String[] ingredients) {
		this.name = name;
		this.ingredients = ingredients;
	}

	public String getName() {
		return this.name;
	}

	public String[] getIngredients() {
		return this.ingredients;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.name);
		sb.append(" (");
		for (String ingredient : this.ingredients) {
			sb.append(ingredient).append(" ");
		}
		return sb.append(")").toString();
	}
}
