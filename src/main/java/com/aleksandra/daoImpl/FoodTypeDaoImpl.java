package com.aleksandra.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aleksandra.dao.FoodTypeDao;
import com.aleksandra.model.FoodType;

@Repository
@Transactional
public class FoodTypeDaoImpl implements FoodTypeDao {

	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<FoodType> getFoodTypes() {
		return sessionFactory.getCurrentSession().createCriteria(FoodType.class).list();
	}

	@Override
	public FoodType findById(Long id) {
		return (FoodType) sessionFactory.getCurrentSession().createCriteria(FoodType.class)
				.add(Restrictions.eq("id", id)).uniqueResult();
	}

}
