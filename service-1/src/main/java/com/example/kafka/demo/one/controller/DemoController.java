package com.example.kafka.demo.one.controller;

import com.example.kafka.demo.one.model.KafkaMessageExample;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api")
@Slf4j
@RequiredArgsConstructor
public class DemoController {

  private final KafkaTemplate<String, KafkaMessageExample> kafkaTemplate;

  @PostMapping("/kafka-message")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void sendKafkaMessage(@RequestBody final KafkaMessageExample kafkaMessageExample) {
    log.info("Sending a message to {}: {}", kafkaMessageExample.getTopic(), kafkaMessageExample);
    kafkaTemplate.send(kafkaMessageExample.getTopic(), kafkaMessageExample);
  }
}
