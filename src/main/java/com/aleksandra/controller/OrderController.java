package com.aleksandra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aleksandra.model.Orders;
import com.aleksandra.service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/orders")
	public List<Orders> getOrders() {
		return orderService.getOrders();
	}

	@PostMapping("/orders")
	public Orders saveOrder(@RequestBody Orders order){
		return orderService.saveOrder(order);
	}
	
	@RequestMapping (value = "/orders/{id}", method = RequestMethod.DELETE)
	public void deleteOrder(@PathVariable ("id") Long id){
		orderService.deleteOrder(id);
	}
	
}
