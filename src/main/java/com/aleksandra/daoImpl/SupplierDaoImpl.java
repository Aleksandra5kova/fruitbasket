package com.aleksandra.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aleksandra.dao.SupplierDao;
import com.aleksandra.model.Supplier;

@Repository
@Transactional
public class SupplierDaoImpl implements SupplierDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Supplier> getSuppliers() {
		return sessionFactory.getCurrentSession().createCriteria(Supplier.class).list();
	}

}
