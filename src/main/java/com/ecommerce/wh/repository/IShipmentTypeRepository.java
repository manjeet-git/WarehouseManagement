package com.ecommerce.wh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.wh.entity.ShipmentType;


@Repository
public interface IShipmentTypeRepository extends JpaRepository<ShipmentType, Integer>{

}
