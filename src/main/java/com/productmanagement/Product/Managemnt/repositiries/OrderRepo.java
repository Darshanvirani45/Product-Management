package com.productmanagement.Product.Managemnt.repositiries;

import com.productmanagement.Product.Managemnt.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepo extends JpaRepository<Order,Integer> {
}
