package com.ecommerce.wh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.wh.entity.OrderMethod;

@Repository
public interface IOrderMethodRepository extends JpaRepository<OrderMethod, Integer> {

}
