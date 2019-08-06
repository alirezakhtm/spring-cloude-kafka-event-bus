package com.khtm.demo.bulkpayment.consumer.bulkpaymentconsumer.configuration;

import com.khtm.demo.bulkpayment.model.kafka.BulkPayment;
import liquibase.integration.spring.SpringLiquibase;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
@PropertySource("classpath:kafka-config.properties")
public class BulkPaymentConsumerConfig {

    @Value("${com.khtm.kafka.config.server-address}")
    private String KAFKA_SERVER_ADDRESS;

    @Value("${com.khtm.kafka.config.group-id-config}")
    private String GROUP_ID_CONFIG;

    @Autowired
    private DataSource dataSource;

    // General beans

    @Bean
    public Map<String, Object> getConfigGeneral(){
        Map<String, Object> config = new HashMap<>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KAFKA_SERVER_ADDRESS);
        config.put(ConsumerConfig.GROUP_ID_CONFIG, "group-id");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        return config;
    }

    @Bean
    public ConsumerFactory<Object, Object> generalConsumerFactory(){
        return new DefaultKafkaConsumerFactory<Object, Object>(getConfigGeneral());
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<Object, Object> generalFactory(){
        ConcurrentKafkaListenerContainerFactory<Object, Object> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(generalConsumerFactory());
        return factory;
    }

    // Beans for bulk-payment

    @Bean
    public Map<String, Object> getConfigBulkPaymentKafkaConsumer(){
        Map<String, Object> config = new HashMap<>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KAFKA_SERVER_ADDRESS);
        config.put(ConsumerConfig.GROUP_ID_CONFIG, GROUP_ID_CONFIG);
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        config.put(JsonDeserializer.TRUSTED_PACKAGES, "com.khtm.demo.bulkpayment.model.kafka");
        return config;
    }

    @Bean
    public ConsumerFactory<String, BulkPayment> bulkPaymentConsumerFactory(){
        return new DefaultKafkaConsumerFactory<String, BulkPayment>(getConfigBulkPaymentKafkaConsumer());
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, BulkPayment> bulkPaymentKafkaConsumer(){
        ConcurrentKafkaListenerContainerFactory<String, BulkPayment> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(bulkPaymentConsumerFactory());
        return factory;
    }

    @Bean
    public SpringLiquibase liquibase(){
        SpringLiquibase springLiquibase = new SpringLiquibase();
        springLiquibase.setDataSource(dataSource);
        springLiquibase.setChangeLog("classpath:db/changelog/liquibase-changelog.xml");
        return springLiquibase;
    }

}
