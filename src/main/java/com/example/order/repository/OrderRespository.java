package com.example.order.repository;

import com.example.order.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRespository extends MongoRepository<Order, Integer> {
}
