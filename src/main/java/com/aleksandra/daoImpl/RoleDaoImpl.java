package com.aleksandra.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aleksandra.dao.RoleDao;
import com.aleksandra.model.Role;

@Transactional
@Repository
public class RoleDaoImpl implements RoleDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> getAll() {
		return sessionFactory.getCurrentSession().createCriteria(Role.class).list();
	}

}
