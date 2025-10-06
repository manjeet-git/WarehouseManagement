package com.ecommerce.wh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.wh.entity.Uom;

@Repository
public interface UomRepository extends JpaRepository<Uom, Integer>{

}
