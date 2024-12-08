package com.org.kafkaconcurrency;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListenersApplication {

  @KafkaListener(
      topics = "topic",
      groupId = "groupId"
  )
  void listener(String data) {
    System.out.println("Listener received " + data + " ");
  }
}
