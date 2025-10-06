package com.ecommerce.wh.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="shipment_type_tab")
public class ShipmentType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_col",length = 4)
	private int shipmentId;

	@Column(name="shipment_mode_col",length = 10,nullable = false)
	private String shipmentMode;

	@Column(name="shipment_code_col", length = 10,nullable = false)
	private String shipmentCode;

	@Column(name="enable_shipment_col", length = 4,nullable = false)
	private String enableShipment;

	@Column(name="shipment_grade_col", length = 3, nullable = false)
	private String shipmentGrade;

	@Column(name="discription_col",length = 150)
	private String discription;


}
