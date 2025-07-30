package com.nautiDev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CamundaApplication {

  public static void main(String... args) {
    SpringApplication.run(CamundaApplication.class, args);
    System.out.println(" Tasklist: http://localhost:8080/camunda/app/tasklist/ ");
    System.out.println(" Cockpit: http://localhost:8080/camunda/app/cockpit/ ");
  }
}