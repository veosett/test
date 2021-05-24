package com.example.quote;

import org.slf4j.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuoteApplication {
    private static final Logger log = LoggerFactory.getLogger(QuoteApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(QuoteApplication.class, args);
    }

}
