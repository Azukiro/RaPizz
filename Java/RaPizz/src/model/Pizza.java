package model;

import java.util.ArrayList;

public class Pizza {
	
	private final int id;
	private final String label;
	private ArrayList<Ingredient> ingredients;
	private final double price;
	
	public Pizza(int id, String label, double price) {
		this(id, label, new ArrayList<Ingredient>(), price);
	}
	
	
	public Pizza(int id, String label,ArrayList<Ingredient> ingredients, double price) {
		super();
		this.id = id;
		this.label = label;
		this.ingredients = ingredients;
		this.price = price;
	}
	
	public void addIngredient(Ingredient ig){
		ingredients.add(ig);
	}
	
	public String getLabel() {
		// TODO Auto-generated method stub
		return label;
	}
	
	


	public double getPrice() {
		return price;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((ingredients == null) ? 0 : ingredients.hashCode());
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pizza other = (Pizza) obj;
		if (id != other.id)
			return false;
		if (ingredients == null) {
			if (other.ingredients != null)
				return false;
		} else if (!ingredients.equals(other.ingredients))
			return false;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		return true;
	}
	
	public String toString() {
		// TODO Auto-generated method stub
		return label;
	}
	
	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}
}
