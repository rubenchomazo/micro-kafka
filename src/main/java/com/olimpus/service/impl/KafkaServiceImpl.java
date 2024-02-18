package com.olimpus.service.impl;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.olimpus.service.KafkaService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class KafkaServiceImpl implements KafkaService {

	private final KafkaTemplate<String, String> kafkaTemplate;

	@Override
	public void sendMessage(String message) {
		kafkaTemplate.send("topicKafka", message);
	}

	@KafkaListener(topics = "topicKafka", groupId = "my-group-id")
	public void listen(String message) {
		System.out.println("Received message: " + message);
	}

}
