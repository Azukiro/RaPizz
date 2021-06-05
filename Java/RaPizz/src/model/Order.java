package model;

import java.util.Date;

public class Order {
	
	private int id;
	private Pizza pizza;
	private Client client;
	private DeliveryGuy deliveryGuy;
	private Vehicle vehicle;
	private PizzaSize size;
	private Date orderTime;
	private  Date deliveryTime;
	
	public Order() 
	{}
	
	public Order(int id, Pizza pizza, Client client, DeliveryGuy deliveryGuy, Vehicle vehicle,PizzaSize size, Date orderTime,
			Date deliveryTime) {
		super();
		this.id = id;
		this.pizza = pizza;
		this.client = client;
		this.deliveryGuy = deliveryGuy;
		this.vehicle = vehicle;
		this.orderTime = orderTime;
		this.deliveryTime = deliveryTime;
		this.size = size;
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

	public PizzaSize getSize() {
		return size;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + ((deliveryGuy == null) ? 0 : deliveryGuy.hashCode());
		result = prime * result + ((deliveryTime == null) ? 0 : deliveryTime.hashCode());
		result = prime * result + id;
		result = prime * result + ((orderTime == null) ? 0 : orderTime.hashCode());
		result = prime * result + ((pizza == null) ? 0 : pizza.hashCode());
		result = prime * result + ((vehicle == null) ? 0 : vehicle.hashCode());
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
		Order other = (Order) obj;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		if (deliveryGuy == null) {
			if (other.deliveryGuy != null)
				return false;
		} else if (!deliveryGuy.equals(other.deliveryGuy))
			return false;
		if (deliveryTime == null) {
			if (other.deliveryTime != null)
				return false;
		} else if (!deliveryTime.equals(other.deliveryTime))
			return false;
		if (id != other.id)
			return false;
		if (orderTime == null) {
			if (other.orderTime != null)
				return false;
		} else if (!orderTime.equals(other.orderTime))
			return false;
		if (pizza == null) {
			if (other.pizza != null)
				return false;
		} else if (!pizza.equals(other.pizza))
			return false;
		if (vehicle == null) {
			if (other.vehicle != null)
				return false;
		} else if (!vehicle.equals(other.vehicle))
			return false;
		return true;
	}
	
	
	
	
	
}
