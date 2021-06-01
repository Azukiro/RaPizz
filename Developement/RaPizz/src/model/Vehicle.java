package model;

public class Vehicle {
	
	private final int id;
	private final String label;
	private final String type;
	
	public Vehicle(int id, String label, String type) {
		super();
		this.id = id;
		this.label = label;
		this.type = type;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return label;
	}
}
