package com.productmanagement.Product.Managemnt.Configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "product")
public class ProductThresHoldConfig {

    private int thresholdValue;

    public ProductThresHoldConfig() {
    }

    public ProductThresHoldConfig(int thresholdValue) {
        this.thresholdValue = thresholdValue;
    }

    public int getThresholdValue() {
        return thresholdValue;
    }

    public void setThresholdValue(int thresholdValue) {
        this.thresholdValue = thresholdValue;
    }
}
