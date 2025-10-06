package com.ecommerce.wh.entity;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "uom_tab")
public class Uom {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	//Custom generator
	/*
	 * @GeneratedValue(generator = "shipment_id_generator")
	 * 
	 * @GenericGenerator(name = "shipment_id_generator", strategy = "")
	 */
	@Column(name="uom_id_col",length = 5,nullable = false)
	private int uomId;
	
	@Column(name="uom_type_col", length = 10,nullable = false)
	private String uomType;
	
	@Column(name="uom_model_col", length = 10,nullable = false)
	private String uomModel;
	
	@Column(name="description_col", length = 150,nullable = false)
	private String description;
}
