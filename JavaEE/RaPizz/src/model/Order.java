package model;

import java.util.Date;

public class Order {
	
	private int id;
	private Pizza pizza;
	private Client client;
	private DeliveryGuy deliveryGuy;
	private Vehicle vehicle;
	private Date orderTime;
	private  Date deliveryTime;
	
	public Order() 
	{}
	
	public Order(int id, Pizza pizza, Client client, DeliveryGuy deliveryGuy, Vehicle vehicle, Date orderTime,
			Date deliveryTime) {
		super();
		this.id = id;
		this.pizza = pizza;
		this.client = client;
		this.deliveryGuy = deliveryGuy;
		this.vehicle = vehicle;
		this.orderTime = orderTime;
		this.deliveryTime = deliveryTime;
	}

	public int getId() {
		return id;
	}

	public Pizza getPizza() {
		return pizza;
	}

	public Client getClient() {
		return client;
	}

	public DeliveryGuy getDeliveryGuy() {
		return deliveryGuy;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public Date getDeliveryTime() {
		return deliveryTime;
	}
	
	
	
	
	
}
