package com.aleksandra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aleksandra.model.FoodType;
import com.aleksandra.service.FoodTypeService;

@RestController
public class FoodTypeController {
	
	@Autowired
	private FoodTypeService foodTypeService;
	
	@GetMapping("/foodTypes")
	public List<FoodType> getFoodTypes(){
		List<FoodType> foodtypes = foodTypeService.getFoodTypes();
		return foodtypes;
	}

}
