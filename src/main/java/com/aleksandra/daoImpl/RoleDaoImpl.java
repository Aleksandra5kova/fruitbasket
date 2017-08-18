package com.aleksandra.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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

	@Override
	public Role getRoleByDescription(String description) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Role.class);
		cr.add(Restrictions.eq("description", description));
		return (Role) cr.uniqueResult();
	}

}
