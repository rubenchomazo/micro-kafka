package com.olimpus.provider.service.impl;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.olimpus.provider.service.KafkaService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class KafkaServiceImpl implements KafkaService {

	private final KafkaTemplate<String, String> kafkaTemplate;

	@Override
	public void sendMessage(String message) {
		kafkaTemplate.send("kafka-topic-test", message);
	}

}
