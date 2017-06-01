package com.aleksandra.dao;

import java.util.List;

import com.aleksandra.model.Food;
import com.aleksandra.model.FoodType;

public interface FoodDao {
	
	public List<Food> getFoodsByFoodType(FoodType foodType);
	
	public List<Food> getFoods();
	
	public Food findById(Long id);

}
