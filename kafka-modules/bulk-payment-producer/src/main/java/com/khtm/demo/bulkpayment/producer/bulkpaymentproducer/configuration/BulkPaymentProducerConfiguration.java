package com.khtm.demo.bulkpayment.producer.bulkpaymentproducer.configuration;

import com.khtm.demo.bulkpayment.model.kafka.BulkPayment;
import liquibase.integration.spring.SpringLiquibase;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
@PropertySource("classpath:kafka-config.properties")
public class BulkPaymentProducerConfiguration {

    @Value("${com.khtm.kafka.config.server-address}")
    private String BOOTSTRAP_SERVERS_CONFIG;

    @Value("${com.khtm.kafka.config.group-id-config}")
    private String GROUP_ID_CONFIG;

    @Autowired
    private DataSource dataSource;

    @Bean
    public Map<String, Object> producerConfig(){
        Map<String, Object> config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS_CONFIG);
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return config;
    }

    @Bean
    public ProducerFactory<String, BulkPayment> producerFactory(){
        return new DefaultKafkaProducerFactory<String, BulkPayment>(producerConfig());
    }

    @Bean
    public KafkaTemplate<String, BulkPayment> kafkaTemplate(){
        return new KafkaTemplate<String, BulkPayment>(producerFactory());
    }

    @Bean
    public SpringLiquibase liquibase(){
        SpringLiquibase springLiquibase = new SpringLiquibase();
        springLiquibase.setDataSource(dataSource);
        springLiquibase.setChangeLog("classpath:db/changelog/liquibase-changelog.xml");
        return springLiquibase;
    }

}
