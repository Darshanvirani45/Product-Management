package com.productmanagement.Product.Managemnt.repositiries;

import com.productmanagement.Product.Managemnt.models.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepo extends JpaRepository<Bill,Integer> {
}
