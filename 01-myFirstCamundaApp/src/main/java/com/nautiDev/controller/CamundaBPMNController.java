package com.nautiDev.controller;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.runtime.ProcessInstanceWithVariables;
import org.camunda.bpm.engine.runtime.ProcessInstantiationBuilder;
import org.camunda.bpm.engine.variable.VariableMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CamundaBPMNController {

    //http://localhost:8080/execute
    @GetMapping("/execute")
    public String execute(){
        // To get Camunda Process Engine, the main object used to start and manage processes.
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        // Create a new process instance using the BPMN diagram with the ID/key MyFirstCamundaBPMN.
        ProcessInstantiationBuilder instance = engine.getRuntimeService().createProcessInstanceByKey("MyFirstCamundaBPMN");
        // Start the process and return any process variables (though we're not using them here)
        instance.executeWithVariablesInReturn();
        // Return a message confirming the process has started
        return "Camunda Modeler BPMN has executed";
    }

    //http://localhost:8080/executingJavaVariable
    @GetMapping("/executingJavaVariable")
    public String executeVariable(){
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        ProcessInstantiationBuilder instance = engine.getRuntimeService().createProcessInstanceByKey("MyFirstCamundaBPMN");

        // Create a variable to pass into the process
        String javaVariable = "Akshit Nautiyal Loves Java";
        // Set the variable "newJavaVariable" with the value of "javaVariable" into the process
        instance.setVariable("newJavaVariable", javaVariable);
        // Start the process and pass the variable; any result variables can be returned (if needed)
        instance.executeWithVariablesInReturn();
        // Return a message confirming the process has started
        return "Camunda Modeler BPMN has executed";
    }

    //http://localhost:8080/executeBusinessKey
    @GetMapping("/executeBusinessKey")
    public String executeBusinessKey(){
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        ProcessInstantiationBuilder instance = engine.getRuntimeService().createProcessInstanceByKey("MyFirstCamundaBPMN");
        // Set a business key for this process instance
        // A business key is a unique string you can use to identify or group process instances
        instance.businessKey("This is Akshit Business Key");
        instance.executeWithVariablesInReturn();
        return "Camunda Modeler BPMN has executed";
    }

    //http://localhost:8080/executeJsVariable
    @GetMapping("/executeJsVariable")
    public String executeJsVariable() {
        // Step 1: Get the default Camunda ProcessEngine instance
        // This is the core engine to start and interact with Camunda workflows
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        // Step 2: Create a new process instance using the process definition key "MyFirstCamundaBPMN"
        // Also set a business key to uniquely identify or group the process instance
        ProcessInstantiationBuilder instance = engine.getRuntimeService()
                .createProcessInstanceByKey("MyFirstCamundaBPMN")
                .businessKey("JavaScript-Camunda-Spring-Boot");
        // Step 3: Start the process instance and retrieve any variables set during execution
        // This includes variables created inside the BPMN model, like from a JavaScript Script Task
        ProcessInstanceWithVariables processInstanceWithVariables = instance.executeWithVariablesInReturn();
        // Step 4: Extract all process variables into a map-like structure
        // These variables may include ones set by Spring Boot or inside Camunda (JavaScript)
        VariableMap vars = processInstanceWithVariables.getVariables();
        // Step 5: Access the variable set by the JavaScript Script Task inside the BPMN model
        // Make sure the script includes: execution.setVariable("javaScriptVariable", value);
        String javaScriptMessage = vars.get("javaScriptVariable").toString();
        // Step 6: Return the value received from the JavaScript logic to the browser/client
        return "Received from JavaScript in BPMN: " + javaScriptMessage;
    }
}