package com.aleksandra.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aleksandra.dao.OrderDao;
import com.aleksandra.model.Orders;

@Repository
@Transactional
public class OrderDaoImpl implements OrderDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Orders> getOrders(String username) {
		return sessionFactory.getCurrentSession().createCriteria(Orders.class).createAlias("user", "user")
				.add(Restrictions.eq("user.username", username)).list();
	}

	@Override
	public Orders saveOrder(Orders order) {
		sessionFactory.getCurrentSession().saveOrUpdate(order);
		return order;
	}

	@Override
	public Orders findById(Long id) {
		return (Orders) sessionFactory.getCurrentSession().createCriteria(Orders.class).add(Restrictions.eq("id", id))
				.uniqueResult();
	}

	@Override
	public void deleteOrder(Orders order) {
		sessionFactory.getCurrentSession().delete(order);
	}

}
