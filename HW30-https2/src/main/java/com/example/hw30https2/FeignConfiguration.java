//package com.example.hw30https2;
//
//import feign.Client;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
//import org.apache.http.ssl.SSLContextBuilder;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.util.ResourceUtils;
//
//import javax.net.ssl.SSLContext;
//import javax.net.ssl.SSLSocketFactory;
//
//@Configuration
//@Slf4j
//public class FeignConfiguration { // not used if TlsFeignConfiguration
//
//    @Value("${app.password}")
//    public static final String PASSWORD = "123123";
//
//    @Bean
//    public Client feignClient() throws Exception {
//        log.info("Configuring SSL Context for Feign Client");
//        return new Client.Default(createSSLContext(), SSLConnectionSocketFactory.getDefaultHostnameVerifier());
//    }
//
//    private SSLSocketFactory createSSLContext() throws Exception {
//        String trustStorePath = "HW30-https2/localhost1-trust.jks";
//
//        log.info("Trust Store for Feign Client: " + trustStorePath);
//
//        SSLContext context = SSLContextBuilder.create()
//                .loadTrustMaterial(ResourceUtils.getFile(trustStorePath), PASSWORD.toCharArray())
//                .build();
//        return context.getSocketFactory();
//    }
//
//}
