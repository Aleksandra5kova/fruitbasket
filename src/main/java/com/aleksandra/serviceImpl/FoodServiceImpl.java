package com.aleksandra.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aleksandra.dao.FoodDao;
import com.aleksandra.dao.FoodTypeDao;
import com.aleksandra.model.Food;
import com.aleksandra.model.FoodType;
import com.aleksandra.service.FoodService;

@Service
public class FoodServiceImpl implements FoodService {

	@Autowired
	private FoodDao foodDao;
	
	@Autowired
	private FoodTypeDao foodTypeDao;
	
	@Override
	public List<Food> getFoodsByFoodType(Long id) {
		FoodType foodType = foodTypeDao.findById(id);
		return foodDao.getFoodsByFoodType(foodType);
	}

	@Override
	public List<Food> getFoods() {
		return foodDao.getFoods();
	}

}
