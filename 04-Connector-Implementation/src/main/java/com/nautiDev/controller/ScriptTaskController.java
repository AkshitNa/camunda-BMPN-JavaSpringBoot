package com.nautiDev.controller;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.runtime.ProcessInstantiationBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScriptTaskController {

    //http://localhost:8080/executeTask
    @GetMapping("/executeTask")
    public String execute() {
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        ProcessInstantiationBuilder instance = engine.getRuntimeService().createProcessInstanceByKey("MyScriptTask-01");
        instance.executeWithVariablesInReturn();
        return "Executed Camunda BPMN :: ScriptTasks";
    }
}



