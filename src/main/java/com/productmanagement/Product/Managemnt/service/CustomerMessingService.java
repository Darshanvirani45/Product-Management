package com.productmanagement.Product.Managemnt.service;


import com.productmanagement.Product.Managemnt.Configuration.TwilioMailConfig;
import com.productmanagement.Product.Managemnt.Configuration.TwilioSmsConfig;
import com.productmanagement.Product.Managemnt.Configuration.TwilioWhatsappConfig;
import com.productmanagement.Product.Managemnt.models.Customer;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.hibernate.query.SortDirection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class CustomerMessingService {

    @Autowired
    private TwilioSmsConfig configTwilio;

    @Autowired
    private TwilioMailConfig configTwilioMail;

    @Autowired
    private TwilioWhatsappConfig configTwilioWhatsapp;


    @Autowired
    private JavaMailSender javaMailSender;

    //send sms to customer passes in parameter
    public void sendSms(Customer customer){
        Message.creator(new PhoneNumber("+91"+customer.getPhoneNumber()),new PhoneNumber(configTwilio.getTrialNumber()),"Dear Customer   "+ customer.getCustomerName() +"  Your Order on the way and delivered in few of days").create();
    }

    //send email to customer passes in parameter
    public void sendMail(Customer customer){
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setTo(customer.getEmail());
        simpleMailMessage.setFrom(configTwilioMail.getUsername());
        simpleMailMessage.setSubject("Order Details");
        simpleMailMessage.setText("Dear Customer   "+ customer.getCustomerName() +"  Your Order on the way and delivered in few of days");
        javaMailSender.send(simpleMailMessage);
    }

    //send whatsapp message to customer passes in parameter
    public void sendWhatsappMessage(Customer customer){
        System.out.println(customer.getPhoneNumber());
        Message.creator(new PhoneNumber("whatsapp:+91"+customer.getPhoneNumber()),new PhoneNumber(configTwilioWhatsapp.getTrialNumber()),"Dear Customer   "+ customer.getCustomerName() +"  Your Order on the way and delivered in few of days").create();
    }


}
