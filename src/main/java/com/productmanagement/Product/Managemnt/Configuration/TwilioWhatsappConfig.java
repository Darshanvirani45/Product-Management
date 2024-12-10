package com.productmanagement.Product.Managemnt.Configuration;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "twilio.whatsapp")
public class TwilioWhatsappConfig {

    private String trialNumber;

    public TwilioWhatsappConfig() {
    }

    public TwilioWhatsappConfig(String trialNumber) {
        this.trialNumber = trialNumber;
    }

    public String getTrialNumber() {
        return trialNumber;
    }

    public void setTrialNumber(String trialNumber) {
        this.trialNumber = trialNumber;
    }

    @Override
    public String toString() {
        return "ConfigTwilioWhatsapp{" +
                "trialNumber='" + trialNumber + '\'' +
                '}';
    }
}
