package com.aleksandra.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "order_item")
@NamedQueries({
		@NamedQuery(name = "OrderItem.deleteOrderItemsByOrder", query = "delete OrderItem where order.id = :id"),
		@NamedQuery(name = "OrderItem.totalPrice", query = "select sum(quantity * price) from OrderItem oi where order.id = :id") })
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_item_id")
	private Long id;

	@Column(name = "order_item_quantity")
	private Double quantity;

	@Column(name = "order_item_unit")
	private String unit;

	@Column(name = "order_item_price")
	private Double price;

	@Column(name = "order_item_discount")
	private Double discount;

	@ManyToOne
	@JoinColumn(name = "order_id")
	private Orders order;

	@ManyToOne
	@JoinColumn(name = "food_id")
	private Food food;

	public OrderItem() {

	}

	public OrderItem(Double quantity, String unit, Double price, Double discount) {
		super();
		this.quantity = quantity;
		this.unit = unit;
		this.price = price;
		this.discount = discount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", quantity=" + quantity + ", unit=" + unit + ", price=" + price + ", discount="
				+ discount + "]";
	}

}
