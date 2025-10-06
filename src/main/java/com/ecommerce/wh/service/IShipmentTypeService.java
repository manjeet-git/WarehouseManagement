package com.ecommerce.wh.service;

import java.util.List;

import com.ecommerce.wh.entity.ShipmentType;

public interface IShipmentTypeService {
	
	Integer saveShipmentType(ShipmentType shipmentType);
	
	void updateShipmentType(ShipmentType shipmentType);
	
	void deleteShipmentType(int id);
	
	ShipmentType getOneShipmentType(int id);
	
	List<ShipmentType>  findAllShipmentType();
	
	boolean isShipmentTypeExist(int id);
}
