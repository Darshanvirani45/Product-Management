package com.productmanagement.Product.Managemnt.Configuration;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "twilio")
public class TwilioSmsConfig {

    private String accountSid;

    private String trialNumber;

    private String authId;


    public TwilioSmsConfig() {
    }

    public TwilioSmsConfig(String accountSid, String authId, String trialNumber) {
        this.accountSid = accountSid;
        this.authId = authId;
        this.trialNumber = trialNumber;
    }

    public String getAccountSid() {
        return accountSid;
    }

    public void setAccountSid(String accountSid) {
        this.accountSid = accountSid;
    }

    public String getAuthId() {
        return authId;
    }

    public void setAuthId(String authId) {
        this.authId = authId;
    }

    public String getTrialNumber() {
        return trialNumber;
    }

    public void setTrialNumber(String trialNumber) {
        this.trialNumber = trialNumber;
    }

    @Override
    public String toString() {
        return "ConfigTwilio{" +
                "accountSid='" + accountSid + '\'' +
                ", trialNumber='" + trialNumber + '\'' +
                ", authId='" + authId + '\'' +
                '}';
    }
}
