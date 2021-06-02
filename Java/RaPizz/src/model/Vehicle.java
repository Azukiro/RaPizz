package model;

public class Vehicle {
	
	private final int id;
	private final String label;
	private final String type;
	
	public Vehicle(int id, String label) {
		this(id, label, "Default");
	}
	
	public Vehicle(int id, String label, String type) {
		super();
		this.id = id;
		this.label = label;
		this.type = type;
	}


	public String getType() {
		// TODO Auto-generated method stub
		return type;
	}
	
	public String getLabel() {
		// TODO Auto-generated method stub
		return label;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return label;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Vehicle other = (Vehicle) obj;
		if (id != other.id)
			return false;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
	
	
}
