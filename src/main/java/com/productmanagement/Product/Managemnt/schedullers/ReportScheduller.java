package com.productmanagement.Product.Managemnt.schedullers;


import com.productmanagement.Product.Managemnt.service.StockReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;


@Configuration
@EnableScheduling
public class ReportScheduller {

    @Autowired
    private StockReportService stockReportService;

    @Scheduled(cron = "30 59 23 * * *")
    public void scheduledReport(){
        stockReportService.sendStockReport();
    }
}
