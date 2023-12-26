package com.example.kafka.demo.two.listener;

import com.example.kafka.demo.two.model.KafkaMessageExample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DemoKafkaListener {

  @KafkaListener(topics = "main_topic", groupId = "demo-2", containerFactory = "exampleKafkaListenerContainerFactory")
  public void listenToMainTopic(KafkaMessageExample message) {
    log.info("Received message on topic main_topic: {}", message);
  }
}
