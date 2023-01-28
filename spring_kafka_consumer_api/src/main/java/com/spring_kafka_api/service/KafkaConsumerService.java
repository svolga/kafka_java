package com.spring_kafka_api.service;

import com.spring_kafka_api.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    private final String topicDigital1 = "digital1";
    private final String topicDigital10 = "digital10";
    private final String groupEmail = "group_email";
    private final String groupConverter = "group_converter";

    private final Logger logger = LoggerFactory.getLogger(getClass().getName());


    @KafkaListener(topics = topicDigital1, groupId = groupEmail)
    public void consumeDigital1GroupEmail(Message message){

        logger.info("!!! Consuming message from kafka --> {}; groupId --> {}", message.toString(), groupEmail);

    }

    @KafkaListener(topics = topicDigital1, groupId = groupConverter)
    public void consumeDigital1GroupConverter(Message message){

        logger.info("!!! Consuming message from kafka --> {}; groupId --> {}", message.toString(), groupConverter);

    }



    @KafkaListener(groupId = groupEmail, topics = topicDigital10)
    public void consumeDigital(Message message){

        logger.info("+++ Consuming message -->{} topic --> {}, groupId --> {}", topicDigital10, message.toString());

    }
    


}
