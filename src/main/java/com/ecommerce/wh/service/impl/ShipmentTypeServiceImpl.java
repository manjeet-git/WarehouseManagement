package com.ecommerce.wh.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.wh.entity.ShipmentType;
import com.ecommerce.wh.repository.IShipmentTypeRepository;
import com.ecommerce.wh.service.IShipmentTypeService;

@Service
public class ShipmentTypeServiceImpl implements IShipmentTypeService {

	@Autowired
	IShipmentTypeRepository repository;
	
	@Override
	@Transactional
	public Integer saveShipmentType(ShipmentType shipmentType) {
		int id=repository.save(shipmentType).getShipmentId();
		return id;
	}

	@Override
	@Transactional
	public void updateShipmentType(ShipmentType shipmentType) {
		repository.save(shipmentType);

	}

	@Override
	@Transactional
	public void deleteShipmentType(int id) {
		repository.deleteById(id);

	}

	@Override
	@Transactional(readOnly = true)
	public ShipmentType getOneShipmentType(int id) {
		Optional<ShipmentType> shipmentType=repository.findById(id);
		if(shipmentType.isPresent())
			return shipmentType.get();
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<ShipmentType> findAllShipmentType() {
		List<ShipmentType> shipmentTypes=repository.findAll();
		return shipmentTypes;
	}

	@Override
	@Transactional(readOnly = true)
	public boolean isShipmentTypeExist(int id) {
		// TODO Auto-generated method stub
		return repository.existsById(id);
	}

}
