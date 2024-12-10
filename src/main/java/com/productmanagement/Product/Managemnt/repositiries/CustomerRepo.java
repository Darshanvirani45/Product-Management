package com.productmanagement.Product.Managemnt.repositiries;

import com.productmanagement.Product.Managemnt.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer> {
}
