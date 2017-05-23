package com.aleksandra.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aleksandra.dao.SupplierDao;
import com.aleksandra.model.Supplier;
import com.aleksandra.service.SupplierService;

@Service
public class SuppliersServiceImpl implements SupplierService {

	@Autowired
	private SupplierDao supplierDao;
	
	@Override
	public List<Supplier> getSuppliers() {
		return supplierDao.getSuppliers();
	}

}
