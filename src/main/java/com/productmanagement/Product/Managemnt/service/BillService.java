package com.productmanagement.Product.Managemnt.service;


import com.productmanagement.Product.Managemnt.models.Bill;
import com.productmanagement.Product.Managemnt.models.Customer;
import com.productmanagement.Product.Managemnt.models.Order;
import com.productmanagement.Product.Managemnt.models.Product;
import com.productmanagement.Product.Managemnt.repositiries.BillRepo;
import com.productmanagement.Product.Managemnt.repositiries.CustomerRepo;
import com.productmanagement.Product.Managemnt.repositiries.OrderRepo;
import com.productmanagement.Product.Managemnt.repositiries.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class BillService {

    @Autowired
    private CustomerRepo customerRepo;


    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private BillRepo billRepo;


    @Autowired
    private OrderRepo orderRepo;


    @Autowired
    private CustomerMessingService customerMessingService;

    @Autowired
    private ProductService productService;

    @Autowired
    private AdminMessingService adminMessingService;

    public Bill createBill(Order order){
        Bill bill=null;
        try{
            bill=new Bill();
            Product product=productRepo.findById(order.getProduct().getProductId()).get();
            Customer customer=customerRepo.findById(order.getCustomer().getCustomerId()).get();

            // set shipped  address in bill obj
            bill.setAddress(order.getAddress());

            //calculate total amount with gst included
            double payAbleAmount=product.getCurrentPrice()+((product.getCurrentPrice()*product.getGst()));
            //add total amount into bill
            bill.setTotalAmountPayAble(payAbleAmount*order.getQuantity());

            //by direction relationship between bill and order
            bill.setOrder(order);
            order.setBill(bill);

            //by direction relationship between bill and customer
            bill.setCustomer(customer);
            customer.getBills().add(bill);

            //by direction relationship between bill and product
            bill.setProduct(product);
            product.getBills().add(bill);


            // add quantity in bill
            bill.setQuantity(order.getQuantity());

            //remove ordered quantity from inventory count
            product.setInventoryCount(product.getInventoryCount()-order.getQuantity());

            if(!payment()){
                return null;
            }

            orderRepo.save(order);
            billRepo.save(bill);
            customerRepo.save(customer);
            productRepo.save(product);


            //check if product stock is less then threshold value
            if(productService.isLessThenThresHold(product.getInventoryCount())){
                adminMessingService.sendSms(product);
                adminMessingService.sendEmail(product);
                adminMessingService.sendWhatsapp(product);
            }

            //at last we will send sms ,email,whatsapp message to customer
            customerMessingService.sendSms(customer);
            customerMessingService.sendMail(customer);
            customerMessingService.sendWhatsappMessage(customer);
        }catch (Exception e){
            e.printStackTrace();
        }
        return bill;
    }
    public boolean payment(){
        return new Random().nextBoolean();
    }
}
