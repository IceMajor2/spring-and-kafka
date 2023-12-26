package com.example.kafka.demo.listener;

import com.example.kafka.demo.model.KafkaMessageExample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DemoListener {

  @KafkaListener(topics = "main_topic", groupId = "demo", containerFactory = "exampleKafkaListenerContainerFactory")
  public void listenToMainTopic(KafkaMessageExample message) {
    log.info("Received message on topic main_topic: {}", message);
  }
}
