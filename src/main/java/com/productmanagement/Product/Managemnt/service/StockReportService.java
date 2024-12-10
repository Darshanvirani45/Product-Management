package com.productmanagement.Product.Managemnt.service;

import com.productmanagement.Product.Managemnt.models.Product;
import com.productmanagement.Product.Managemnt.repositiries.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class StockReportService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private AdminMessingService adminMessingService;

    // make stock report
    public void sendStockReport() {
        Date date=new Date(System.currentTimeMillis());
        SimpleDateFormat sm=new SimpleDateFormat("dd-MM-yyyy");
        String format=sm.format(date);
        try(Writer writer=new FileWriter("D:\\Product Managemnt\\Product-Managemnt\\src\\main\\resources\\reports\\stock-report("+format+").csv");
            ICsvBeanWriter iCsvBeanWriter=new CsvBeanWriter(writer, CsvPreference.STANDARD_PREFERENCE)){

            String[] headers={"productId","title","inventoryCount"};
            iCsvBeanWriter.writeHeader(headers);

            List<Product> products=productRepo.findAll();

            for (Product product:products){
                iCsvBeanWriter.write(product,headers);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        adminMessingService.sendReportOfStock();
    }
}
