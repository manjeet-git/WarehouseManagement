package com.ecommerce.wh.service;

import java.util.List;

import com.ecommerce.wh.entity.OrderMethod;

public interface IOrderMethodService {
	
	Integer saveOrderMethod(OrderMethod orderMethod);
	
	void updateOrderMethod(OrderMethod orderMethod);
	
	void deleteOrderMethod(int id);
	
	OrderMethod getOneOrderMethod(int id);
	
	List<OrderMethod>  findAllOrderMethod();
	
	boolean isOrderMethodExist(int id);
}
