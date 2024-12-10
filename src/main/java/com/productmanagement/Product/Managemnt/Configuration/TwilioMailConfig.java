package com.productmanagement.Product.Managemnt.Configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spring.mail")
public class TwilioMailConfig {

    private String username;

    public TwilioMailConfig() {
    }

    public TwilioMailConfig(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    @Override
    public String toString() {
        return "ConfigTwilioMail{" +
                "username='" + username + '\'' +
                '}';
    }
}
