package com.productmanagement.Product.Managemnt.service;

import com.productmanagement.Product.Managemnt.Configuration.ProductThresHoldConfig;
import com.productmanagement.Product.Managemnt.dto.PageResponseDto;
import com.productmanagement.Product.Managemnt.models.Product;
import com.productmanagement.Product.Managemnt.repositiries.ProductRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private ProductThresHoldConfig configProductThresHold;


    //this method is form add product list into db
    public List<Product> addProducts(List<Product> products){
        try {
            return productRepo.saveAll(products);
        }catch (Exception exception){
            exception.printStackTrace();
        }

        return null;
    }

    public PageResponseDto getProducts(int offset, int pageSize){
        try {
            Pageable pageable= PageRequest.of(offset,pageSize);
            Page<Product> page=productRepo.findAll(pageable);

            PageResponseDto pageResponseDto=new PageResponseDto();

            pageResponseDto.setProducts(page.getContent());
            pageResponseDto.setPageNumber(page.getNumber());
            pageResponseDto.setTotalPages(page.getTotalPages());
            pageResponseDto.setSize(pageSize);

            return pageResponseDto;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    //this method check whether quantity is less thea threshold value
    public boolean isLessThenThresHold(int quantity){
        return quantity<=configProductThresHold.getThresholdValue();
    }
}
