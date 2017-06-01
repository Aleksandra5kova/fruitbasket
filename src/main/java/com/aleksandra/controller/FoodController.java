package com.aleksandra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aleksandra.model.Food;
import com.aleksandra.service.FoodService;

@RestController
public class FoodController {
	
	@Autowired
	private FoodService foodService;
	
	@GetMapping("/foods/foodtype")
	public List<Food> getFoodsByFoodType(@RequestParam("id") String id){
		List<Food> foods = foodService.getFoodsByFoodType(Long.valueOf(id));
		return foods;
	}
	
	@GetMapping("/foods")
	public List<Food> getFoods(){
		return foodService.getFoods();
	}

}
