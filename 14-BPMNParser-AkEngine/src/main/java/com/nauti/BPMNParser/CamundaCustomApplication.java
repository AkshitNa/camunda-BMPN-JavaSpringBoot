package com.nauti.BPMNParser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CamundaCustomApplication {

	public static void main(String[] args) {
		SpringApplication.run(CamundaCustomApplication.class, args);
		System.out.println("BPMN Parser :: " +  "http://localhost:8080/bpmn/parse");
		System.out.println("EL Expression Evaluator :: " + "http://localhost:8080/evaluate");
		System.out.println("FEEL Expression Evaluator [Unary] :: " + "http://localhost:8080/feelEvaluateUnary");
		System.out.println("FEEL Expression Evaluator [Normal] :: " + "http://localhost:8080/feelEvaluate");
	}
}
