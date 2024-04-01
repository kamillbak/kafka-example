package com.kamillbak.kafkaexample.listeners;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(topics = "myTopic", groupId = "group1")
    void listener(String data) {
        System.out.println("Listener get: " + data);
    }
}
