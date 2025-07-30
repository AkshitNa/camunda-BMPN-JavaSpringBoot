package com.nautiDev.controller;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.runtime.ProcessInstantiationBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GatewayInclusiveController {

    //http://localhost:8080/executeGatewayInclusiveTasks
    @GetMapping("/executeGatewayInclusiveTasks")
    public String execute() {
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        ProcessInstantiationBuilder instance = engine.getRuntimeService().createProcessInstanceByKey("MyGatewayInclusiveFlow-03");
        instance.executeWithVariablesInReturn();
        return "Executed Camunda BPMN :: ScriptTasks";
    }
}



