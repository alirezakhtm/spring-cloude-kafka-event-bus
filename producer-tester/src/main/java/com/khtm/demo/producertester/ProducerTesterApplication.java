package com.khtm.demo.producertester;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.kafka.annotation.EnableKafka;

@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
public class ProducerTesterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProducerTesterApplication.class, args);
    }

}
