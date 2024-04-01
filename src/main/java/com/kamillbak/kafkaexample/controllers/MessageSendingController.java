package com.kamillbak.kafkaexample.controllers;

import com.kamillbak.kafkaexample.dto.MessageDto;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/messages")
public class MessageSendingController {

    private KafkaTemplate<String, String> kafkaTemplate;

    public MessageSendingController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public void send(@RequestBody MessageDto messageDto) {
        kafkaTemplate.send("myTopic", messageDto.message());
    }
}
