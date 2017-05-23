package com.aleksandra.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.aleksandra.model.Orders;

public interface OrderDao {

	public List<Orders> getOrders();

}
