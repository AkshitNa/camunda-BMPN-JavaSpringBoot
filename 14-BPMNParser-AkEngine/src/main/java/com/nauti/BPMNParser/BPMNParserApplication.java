package com.nauti.BPMNParser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BPMNParserApplication {

	public static void main(String[] args) {
		SpringApplication.run(BPMNParserApplication.class, args);
		System.out.println("http://localhost:8080/bpmn/parse");
	}
}
