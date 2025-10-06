package com.ecommerce.wh.generator;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class ShipmentGeneratorType implements IdentifierGenerator{

	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {
		String prefix="SHIPMENT-";
		String todayDate=new SimpleDateFormat("ddmmyy").format(new Date());
		return prefix+todayDate+"-"+new Random().nextInt(1000, 1000000);
	}

	

}
