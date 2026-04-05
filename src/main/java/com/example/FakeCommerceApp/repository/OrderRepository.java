package com.example.FakeCommerceApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.FakeCommerceApp.schema.OrderProduct;

public interface OrderRepository extends JpaRepository<OrderProduct, Long> {

}
