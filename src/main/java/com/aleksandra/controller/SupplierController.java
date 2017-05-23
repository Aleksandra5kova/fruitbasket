package com.aleksandra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aleksandra.model.Supplier;
import com.aleksandra.service.SupplierService;

@RestController
public class SupplierController {
	
	@Autowired
	private SupplierService supplierService;
	
	@GetMapping("/suppliers")
	public List<Supplier> getSuppliers(){
		return supplierService.getSuppliers();
	}
	
}
