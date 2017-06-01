package com.aleksandra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aleksandra.model.OrderItem;
import com.aleksandra.service.OrderItemService;

@RestController
public class OrderItemController {
	
	@Autowired
	private OrderItemService orderItemService;
	
	@GetMapping("orderItems/order")
	public List<OrderItem> getOrderItemsByOrder(@RequestParam("id") String id){
		List<OrderItem> orderItems =orderItemService.getOrderItemsByOrder(Long.valueOf(id)); 
		return orderItems;
	}

	@PostMapping("/orderItems")
	public OrderItem saveOrderItem(@RequestBody OrderItem orderItem){
		//return new OrderItem();
		return orderItemService.saveOrderItem(orderItem);
	}
}
