package model;

import java.util.Date;

public class Order {
	
	private final int id;
	private final Pizza pizza;
	private final Client client;
	private final DeliveryGuy deliveryGuy;
	private final Vehicle vehicle;
	private final Date orderTime;
	private final Date deliveryTime;
	
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
	
	
	
}
