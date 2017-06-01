package com.aleksandra.dao;

import java.util.List;

import com.aleksandra.model.FoodType;

public interface FoodTypeDao {
	
	public List<FoodType> getFoodTypes();
	
	public FoodType findById(Long id);

}
