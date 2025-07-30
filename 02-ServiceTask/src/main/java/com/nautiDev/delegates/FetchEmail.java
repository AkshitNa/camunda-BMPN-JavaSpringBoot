package com.nautiDev.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class FetchEmail implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("Coming form Fetch Email");
        System.out.println("Global variable :: " + execution.getVariable("number01"));
        //this has global scope
        execution.setVariable("myEmail", "nauti.akshit005@gmail.com");
        System.out.println(execution.getVariable("myEmail"));
    }
}



