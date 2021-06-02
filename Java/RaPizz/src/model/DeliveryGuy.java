package model;

public class DeliveryGuy {
	
	private final int id;
	private final String firstName;
	private final String lastName;
	private final String phone;
	
	public DeliveryGuy(int id, String firstName, String lastName, String phone) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
	}
	

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return lastName;
	}
}
