package com.example.hw30https2;

import org.springframework.context.annotation.Bean;

public class TlsFeignConfiguration {
    @Bean
    public void Config() {
        System.setProperty("javax.net.ssl.trustStoreType", "JKS");
        System.setProperty("javax.net.ssl.trustStore", "HW30-https2/localhost1-trust.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "123123");
    }

}
