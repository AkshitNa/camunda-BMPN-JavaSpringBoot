package com.nauti.BPMNParser.controller;

import com.nauti.BPMNParser.model.ExpressionRequest;
import com.nauti.BPMNParser.service.ExpressionEvaluatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExpressionEvaluatorController {

    @Autowired
    private ExpressionEvaluatorService evaluatorService;

    //http://localhost:8080/evaluate
    @PostMapping("/evaluate")
    public boolean evaluate(@RequestBody ExpressionRequest expRequest) {
        return evaluatorService.evaluateExpression(expRequest.getExpression(), expRequest.getVariables());
    }
}
