package model;

public class Ingredient {
	
	private final int id;
	private final String label;
	
	public Ingredient(int id, String label) {
		super();
		this.id = id;
		this.label = label;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((label == null) ? 0 : label.hashCode());
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
		Ingredient other = (Ingredient) obj;
		if (id != other.id)
			return false;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		return true;
	}
	
	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return label;
	}
}
