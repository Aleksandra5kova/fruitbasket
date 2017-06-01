package com.aleksandra.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aleksandra.dao.FoodDao;
import com.aleksandra.model.Food;
import com.aleksandra.model.FoodType;

@Repository
@Transactional
public class FoodDaoImpl implements FoodDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Food> getFoodsByFoodType(FoodType foodType) {
		return sessionFactory.getCurrentSession().createCriteria(Food.class).add(Restrictions.eq("foodType", foodType))
				.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Food> getFoods() {
		return sessionFactory.getCurrentSession().createCriteria(Food.class).list();
	}

	@Override
	public Food findById(Long id) {
		return (Food) sessionFactory.getCurrentSession().createCriteria(Food.class).add(Restrictions.eq("id", id))
				.uniqueResult();
	}

}
