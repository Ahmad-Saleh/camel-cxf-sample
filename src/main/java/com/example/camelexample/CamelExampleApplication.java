package com.example.camelexample;

import com.example.camelexample.camel.Account;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;
import org.apache.commons.io.IOUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.stream.Collectors;

@SpringBootApplication
public class CamelExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(CamelExampleApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner init(CamelContext camelContext) {
//        return args -> {
//            ProducerTemplate producerTemplate = camelContext.createProducerTemplate();
//            Object object = producerTemplate.sendBody("direct:processRecord", ExchangePattern.InOut, Account.builder()
//                    .accNumber("777777722")
//                    .accDescription("koko")
//                    .activeFlag(true)
//                    .tenantName("corpay").build());
//            InputStream is = (InputStream) object;
//            String result = String.join("", IOUtils.readLines(is, "UTF-8"));
//            System.out.println(result);
//        };
//    }
}
