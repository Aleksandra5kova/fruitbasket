package com.aleksandra.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "food_type")
public class FoodType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "food_id")
	private Long id;

	@Column(name = "food_name")
	private String name;

	public FoodType() {

	}

	public FoodType(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "FoodType [id=" + id + ", name=" + name + "]";
	}
}
