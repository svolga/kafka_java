package com.spring_kafka_api.service;

import com.spring_kafka_api.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class KafkaProducerService {

    private final Logger logger = LoggerFactory.getLogger(KafkaProducerService.class);

    @Autowired
    private KafkaTemplate<String, Message> kafkaTemplate;

    @Value("${kafka.topic1}")
    private String topic1;


    @Value("${kafka.topic2}")
    private String topic10;


    public void sendMessage(Message message) {

        ListenableFuture<SendResult<String, Message>> future =
                kafkaTemplate.send(topic1, message.getKey(),  message);

        future.addCallback(new ListenableFutureCallback<SendResult<String, Message>>() {

            @Override
            public void onSuccess(SendResult<String, Message> result) {
                logger.info("Sent message --> {} with offset --> {}, topic --> {}, partition -->{}",
                        message,
                        result.getRecordMetadata().offset(),
                        result.getRecordMetadata().topic(),
                        result.getRecordMetadata().partition());
            }
            @Override
            public void onFailure(Throwable ex) {
                logger.info("Unable to send message --> {} , error --> {}",
                        message, ex.getMessage());
            }
        }
        );

    }

    public void sendOtherMessage(Message message) {

        ListenableFuture<SendResult<String, Message>> future =
                kafkaTemplate.send(topic10, message.getKey(),  message);

        future.addCallback(new ListenableFutureCallback<SendResult<String, Message>>() {

                               @Override
                               public void onSuccess(SendResult<String, Message> result) {
                                   logger.info("Sent Other message --> {} with offset --> {}, topic --> {}, partition -->{}",
                                           message,
                                           result.getRecordMetadata().offset(),
                                           result.getRecordMetadata().topic(),
                                           result.getRecordMetadata().partition());
                               }
                               @Override
                               public void onFailure(Throwable ex) {
                                   logger.info("Unable to send message --> {} , error --> {}",
                                           message, ex.getMessage());
                               }
                           }
        );

    }

}
