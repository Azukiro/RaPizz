package model;

public class Client {
	
	private final int id;
	private final String firstName;
	private final String lastName;
	private final String phone;
	private final String adress;
	
	public Client(int id, String firstName, String lastName, String phone,String adress) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.adress = adress;
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
