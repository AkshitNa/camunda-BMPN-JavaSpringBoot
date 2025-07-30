package com.nautiDev.controller;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.runtime.ProcessInstantiationBuilder;
import org.camunda.bpm.model.bpmn.instance.FlowNode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GatewayServiceController {

    //http://localhost:8080/executeGatewayServiceTasks
    @GetMapping("/executeGatewayServiceTasks")
    public String execute() {
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        ProcessInstantiationBuilder instance = engine.getRuntimeService().createProcessInstanceByKey("MyGatewayServiceFlow-04");
        instance.executeWithVariablesInReturn();
        return "Executed Camunda BPMN :: ScriptTasks";
    }
}



