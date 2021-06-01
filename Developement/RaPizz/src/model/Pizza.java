package model;

import java.util.ArrayList;

public class Pizza {
	
	private final int id;
	private final String label;
	private final ArrayList<Ingredient> ingredients;
	private final double price;
	
	public Pizza(int id, String label,ArrayList<Ingredient> ingredients, double price) {
		super();
		this.id = id;
		this.label = label;
		this.ingredients = ingredients;
		this.price = price;
	}
	
}
