package com.productmanagement.Product.Managemnt.service;

import com.productmanagement.Product.Managemnt.Configuration.AdminConfig;
import com.productmanagement.Product.Managemnt.Configuration.TwilioMailConfig;
import com.productmanagement.Product.Managemnt.Configuration.TwilioSmsConfig;
import com.productmanagement.Product.Managemnt.Configuration.TwilioWhatsappConfig;
import com.productmanagement.Product.Managemnt.models.Product;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class AdminMessingService {

    @Autowired
    private AdminConfig adminConfig;

    @Autowired
    private TwilioSmsConfig twilioSmsConfig;

    @Autowired
    private TwilioMailConfig twilioMailConfig;

    @Autowired
    private TwilioWhatsappConfig twilioWhatsappConfig;

    @Autowired
    private JavaMailSender javaMailSender;


    public void sendSms(Product product){
        Message.creator(new PhoneNumber(adminConfig.getPhoneNumber()),new PhoneNumber(twilioSmsConfig.getTrialNumber()),"⚠Alert "+product.getTitle()+" remaining only "+product.getInventoryCount()).create();
    }

    public void sendEmail(Product product){
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        System.out.println(adminConfig.getEmail());
        simpleMailMessage.setTo(adminConfig.getEmail());
        simpleMailMessage.setFrom(twilioMailConfig.getUsername());
        simpleMailMessage.setSubject("Reminder");
        simpleMailMessage.setText("⚠Alert "+product.getTitle()+" remaining only "+product.getInventoryCount());
        javaMailSender.send(simpleMailMessage);
    }

    public void sendWhatsapp(Product product) {
        System.out.println(adminConfig.getWhatsappNumber());
        System.out.println(twilioWhatsappConfig.getTrialNumber());
        Message.creator(new PhoneNumber(adminConfig.getWhatsappNumber()),new PhoneNumber(twilioWhatsappConfig.getTrialNumber()),"⚠Alert "+product.getTitle()+" remaining only "+product.getInventoryCount()).create();
    }

    public void sendReportOfStock(){
//        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
//        simpleMailMessage.setTo(adminConfig.getEmail());
//        simpleMailMessage.setFrom(twilioMailConfig.getUsername());
//        simpleMailMessage.setSubject("Stock Report");
//        simpleMailMessage.setText(stockReport);
//
//        javaMailSender.send(simpleMailMessage);


        try {
            MimeMessage message=javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(message,true);

            mimeMessageHelper.setFrom(twilioMailConfig.getUsername());
            mimeMessageHelper.setTo(adminConfig.getEmail());
            mimeMessageHelper.setText("Stock Report of Products");
            mimeMessageHelper.setSubject("Stock Report");


            Date date=new Date(System.currentTimeMillis());
            SimpleDateFormat sm=new SimpleDateFormat("dd-MM-yyyy");
            String format=sm.format(date);

            String fileName="stock-report("+format+").csv";

            FileSystemResource fileSystemResource=new FileSystemResource(new File("D:\\Product Managemnt\\Product-Managemnt\\src\\main\\resources\\reports\\"+fileName));
            mimeMessageHelper.addAttachment(fileSystemResource.getFilename(),fileSystemResource);

            javaMailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
