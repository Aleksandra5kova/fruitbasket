package com.aleksandra.service;

import java.util.List;

import com.aleksandra.model.Food;

public interface FoodService {
	
	public List<Food> getFoodsByFoodType(Long id);
	
	public List<Food> getFoods();
	
}
