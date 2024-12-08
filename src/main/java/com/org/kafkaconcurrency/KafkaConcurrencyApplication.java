package com.org.kafkaconcurrency;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class KafkaConcurrencyApplication {

  public static void main(String[] args) {
    SpringApplication.run(KafkaConcurrencyApplication.class, args);
  }

  @Bean
  CommandLineRunner commandLineRunner(KafkaTemplate<String, String> kafkaTemplate) {
    System.out.println("ii");
    return args -> {
      for (int i = 0; i < 1000; i++) {
        kafkaTemplate.send("topic", "Testing never " + i);
      }
    };
  }
}
