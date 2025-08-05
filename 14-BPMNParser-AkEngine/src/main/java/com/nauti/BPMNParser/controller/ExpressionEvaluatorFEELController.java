package com.nauti.BPMNParser.controller;

import com.nauti.BPMNParser.model.ExpressionRequest;
import com.nauti.BPMNParser.service.ExpressionEvaluatorFEELService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ExpressionEvaluatorFEELController {

    @Autowired
    private final ExpressionEvaluatorFEELService feelEvaluationService;

    //http://localhost:8080/feelEvaluateUnary
    @PostMapping("/feelEvaluateUnary")
    public Object evaluateUnaryTests(@RequestBody ExpressionRequest request) {
        return feelEvaluationService.evaluateSingleTest(request.getExpression(),request.getVariables());
    }

    //http://localhost:8080/feelEvaluate
    @PostMapping("/feelEvaluate")
    public Object evaluateExpression(@RequestBody ExpressionRequest request) {
        return feelEvaluationService.evaluateNormalExpression(request.getExpression(), request.getVariables());
    }
}
