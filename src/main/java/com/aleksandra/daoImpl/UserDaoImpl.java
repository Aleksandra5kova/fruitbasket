package com.aleksandra.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aleksandra.dao.UserDao;
import com.aleksandra.model.User;

@Transactional
@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public User findByUsername(String username) {
		User user = null;
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(User.class);
		cr.add(Restrictions.eq("username", username));
		List<User> users = cr.list();
		if (users.size() != 0) {
			user = users.get(0);
		}
		return user;
	}

	@Override
	public void persist(User user) {
		sessionFactory.getCurrentSession().persist(user);
	}

}
