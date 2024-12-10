package com.productmanagement.Product.Managemnt.service;

import com.productmanagement.Product.Managemnt.models.Customer;
import com.productmanagement.Product.Managemnt.repositiries.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CustomerService {

        @Autowired
        private CustomerRepo customerRepo;

        // add an customer
        public Customer addCustomer(Customer customer) {
            try{
                return customerRepo.save(customer);
            }catch (Exception exception){
                exception.printStackTrace();
            }

            return null;
        }

}
