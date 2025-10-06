package com.ecommerce.wh.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.wh.entity.Uom;
import com.ecommerce.wh.repository.UomRepository;
import com.ecommerce.wh.service.IuomService;

@Service
public class UomServiceImpl implements IuomService {

	@Autowired
	UomRepository repository;
	
	@Override
	@Transactional
	public int saveUom(Uom uom) {
		Uom persistedUom=repository.save(uom);
		return persistedUom.getUomId();
	}

	@Override
	@Transactional
	public int updateUom(Uom uom) {
		// TODO Auto-generated method stub
		Uom updatedUom=repository.save(uom);
		return updatedUom.getUomId();
	}

	@Override
	@Transactional
	public void deleteUom(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Uom getOneUom(int id) {
		// TODO Auto-generated method stub
		Optional<Uom> optionalUom=repository.findById(id);
		if(optionalUom.isPresent())
			return optionalUom.get();
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Uom> findAllUom() {
		// TODO Auto-generated method stub
		List<Uom> uoms=repository.findAll();
		if(uoms.size()>0)
			return uoms;
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public boolean isUomExist(int id) {
		// TODO Auto-generated method stub
		boolean isExist=repository.existsById(id);
		
		return isExist;
	}

}
