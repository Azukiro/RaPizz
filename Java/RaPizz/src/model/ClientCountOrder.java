package model;

public class ClientCountOrder {
	private final Client client;
	
	private final int countOrder;

	public ClientCountOrder(Client client, int countOrder) {
		super();
		this.client = client;
		this.countOrder = countOrder;
	}

	public Client getClient() {
		return client;
	}

	public int getCountOrder() {
		return countOrder;
	}
	
	
}
