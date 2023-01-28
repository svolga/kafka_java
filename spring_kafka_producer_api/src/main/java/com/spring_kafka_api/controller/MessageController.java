package com.spring_kafka_api.controller;

import com.spring_kafka_api.model.Message;
import com.spring_kafka_api.service.KafkaProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api/v1/message")
public class MessageController {

    private final KafkaProducerService producerService;

    private static final Logger logger = LoggerFactory.getLogger(MessageController.class);

    public MessageController(KafkaProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping(path = "/send",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> send (@RequestBody Message message ){
        logger.info("message in controller -> {}", message);
        producerService.sendMessage(message);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(path = "/other",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> sendOther (@RequestBody Message message ){
        logger.info("message Other in controller -> {}", message);
        producerService.sendOtherMessage(message);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
