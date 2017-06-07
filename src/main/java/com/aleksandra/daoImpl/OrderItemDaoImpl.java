package com.aleksandra.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aleksandra.dao.OrderItemDao;
import com.aleksandra.model.OrderItem;
import com.aleksandra.model.Orders;

@Repository
@Transactional
public class OrderItemDaoImpl implements OrderItemDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderItem> getOrderItemsByOrder(Orders order) {
		return sessionFactory.getCurrentSession().createCriteria(OrderItem.class).add(Restrictions.eq("order", order))
				.list();
	}

	@Override
	public OrderItem saveOrderItem(OrderItem orderItem) {
		return (OrderItem) sessionFactory.getCurrentSession().merge(orderItem);
	}

	@Override
	public void deleteOrderItemsByOrder(Long id) {
		Query query = sessionFactory.getCurrentSession().createQuery("delete OrderItem where order.id = :id");
		query.setParameter("id", id);
		query.executeUpdate();
	}

	@Override
	public double totalPrice(Long id) {
		Query query = sessionFactory.getCurrentSession()
				.createQuery("select sum(quantity * food.price) from OrderItem oi where order.id = :id");
		query.setParameter("id", id);
		return (double) (query.uniqueResult() == null ? 0d : query.uniqueResult());
	}

	@Override
	public void deleteOrderItem(OrderItem orderItem) {
		OrderItem managed = (OrderItem) sessionFactory.getCurrentSession().merge(orderItem);
		sessionFactory.getCurrentSession().delete(managed);
	}

	@Override
	public OrderItem findById(Long id) {
		return (OrderItem) sessionFactory.getCurrentSession().createCriteria(OrderItem.class)
				.add(Restrictions.eq("id", id)).uniqueResult();
	}

}
