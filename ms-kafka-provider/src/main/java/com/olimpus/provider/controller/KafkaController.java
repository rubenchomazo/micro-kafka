package com.olimpus.provider.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.olimpus.provider.service.impl.KafkaServiceImpl;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/kafka")
@AllArgsConstructor
public class KafkaController {

	private final KafkaServiceImpl kafkaServiceImpl;

	@PostMapping(path = "/send")
	ResponseEntity<String> saveProduct(@RequestBody String message) {
		try {
			kafkaServiceImpl.sendMessage(message);
			return ResponseEntity.ok("Send Message OK");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}