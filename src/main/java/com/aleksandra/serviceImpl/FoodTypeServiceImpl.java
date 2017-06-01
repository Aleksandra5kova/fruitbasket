package com.aleksandra.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aleksandra.dao.FoodTypeDao;
import com.aleksandra.model.FoodType;
import com.aleksandra.service.FoodTypeService;

@Service
public class FoodTypeServiceImpl implements FoodTypeService {

	@Autowired
	private FoodTypeDao foodTypeDao;
	
	@Override
	public List<FoodType> getFoodTypes() {
		return foodTypeDao.getFoodTypes();
	}
	
}
