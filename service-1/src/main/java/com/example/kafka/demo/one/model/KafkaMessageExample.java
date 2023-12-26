package com.example.kafka.demo.one.model;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class KafkaMessageExample {

  private String message;
  private String signature;
  private String topic;
}
