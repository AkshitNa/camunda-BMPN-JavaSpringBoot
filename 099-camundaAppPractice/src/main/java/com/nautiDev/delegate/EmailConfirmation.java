package com.nautiDev.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class EmailConfirmation implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("Sending mail that transaction of order of amount " + execution.getVariable("orderTotal")
                + " is a " + execution.getVariable("paymentStatus"));
    }
}
