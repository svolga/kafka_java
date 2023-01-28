package com.spring_kafka_api.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {

    @Value(value = "${spring.kafka.producer.bootstrap-servers}")
    private String bootstrapAddress;

    @Value("${kafka.topic1}")
    private String topic1;

    @Value("${kafka.partition1}")
    private int partition1;

    @Value("${kafka.topic2}")
    private String topic2;

    @Value("${kafka.partition2}")
    private int partition2;


    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        return new KafkaAdmin(configs);
    }


    @Bean
    public NewTopic topic1() {
        return new NewTopic(topic1, partition1, (short) 1);
    }

    @Bean
    public NewTopic topic2() {
        return new NewTopic(topic2, partition2, (short) 1);
    }


}
