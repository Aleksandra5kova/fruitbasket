package com.aleksandra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aleksandra.model.OrderItem;
import com.aleksandra.service.OrderItemService;

@RestController
public class OrderItemController {
	
	@Autowired
	private OrderItemService orderItemService;
	
	@GetMapping("orderItems/order")
	public List<OrderItem> getOrderItemsByOrder(@RequestParam("id") Long id){
		return orderItemService.getOrderItemsByOrder(id); 
	}

	@PostMapping("/orderItems")
	public OrderItem saveOrderItem(@RequestBody OrderItem orderItem){
		return orderItemService.saveOrderItem(orderItem);
	}
	
	@GetMapping("orderItems/totalPrice")
	public double totalPrice(@RequestParam("id") Long id){
		return orderItemService.totalPrice(id);
	}
	
	@RequestMapping (value = "/orderItems/{id}", method = RequestMethod.DELETE)
	public void deleteOrder(@PathVariable ("id") Long id){
		orderItemService.deleteOrderItem(id);
	}
}
