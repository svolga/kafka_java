package com.spring_kafka_api.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Message {
    private String key;
    private String message;
}