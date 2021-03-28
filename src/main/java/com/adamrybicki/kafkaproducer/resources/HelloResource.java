package com.adamrybicki.kafkaproducer.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloResource {

  @Autowired
  KafkaTemplate<Integer, String> template;

  @GetMapping
  public String getHello() {
    return "Hello to you";
  }

  @PostMapping
  public void postMessage() {
    template.send("HelloTopic", "data");
  }
}
