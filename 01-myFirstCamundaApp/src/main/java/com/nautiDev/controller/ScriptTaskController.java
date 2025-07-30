package com.nautiDev.controller;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.runtime.ProcessInstantiationBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScriptTaskController {

    //http://localhost:8080/executeScriptTask
    @GetMapping("/executeScriptTask")
    public String execute(){
        // To get Camunda Process Engine, the main object used to start and manage processes.
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        // Create a new process instance using the BPMN diagram with the ID/key MyFirstCamundaBPMN.
        ProcessInstantiationBuilder instance = engine.getRuntimeService().createProcessInstanceByKey("ScriptTaskExecute");
        // Start the process and return any process variables (though we're not using them here)
        instance.executeWithVariablesInReturn();
        // Return a message confirming the process has started
        return "Camunda Modeler BPMN has executed the Script Task";
    }
}
