package com.ecommerce.wh.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.wh.entity.OrderMethod;
import com.ecommerce.wh.repository.IOrderMethodRepository;
import com.ecommerce.wh.service.IOrderMethodService;

public class OrderMethodServiceImpl implements IOrderMethodService {

	@Autowired
	IOrderMethodRepository repository;
	
	@Override
	@Transactional
	public Integer saveOrderMethod(OrderMethod orderMethod) {
		// TODO Auto-generated method stub
		int id =repository.save(orderMethod).getId();
		return id;
	}

	@Override
	@Transactional
	public void updateOrderMethod(OrderMethod orderMethod) {
		repository.save(orderMethod);

	}

	@Override
	@Transactional
	public void deleteOrderMethod(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);

	}

	@Override
	@Transactional(readOnly = true)
	public OrderMethod getOneOrderMethod(int id) {
		// TODO Auto-generated method stub
		Optional<OrderMethod> oOMethod=repository.findById(id);
		if(oOMethod.isPresent())
			return oOMethod.get();
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<OrderMethod> findAllOrderMethod() {
		// TODO Auto-generated method stub
		List<OrderMethod> orderMethods=repository.findAll();
		return orderMethods;
	}

	@Override
	@Transactional(readOnly = true)
	public boolean isOrderMethodExist(int id) {
		// TODO Auto-generated method stub
		boolean isAvailable=repository.existsById(id);
		return isAvailable;
	}

}
