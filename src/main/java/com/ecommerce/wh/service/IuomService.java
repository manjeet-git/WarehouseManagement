package com.ecommerce.wh.service;

import java.util.List;

import com.ecommerce.wh.entity.Uom;

public interface IuomService {

	public int saveUom(Uom uom);

	public int updateUom(Uom uom);

	public void deleteUom(int id);

	public Uom getOneUom(int id);

	public List<Uom> findAllUom();

	public boolean isUomExist(int id);

}
