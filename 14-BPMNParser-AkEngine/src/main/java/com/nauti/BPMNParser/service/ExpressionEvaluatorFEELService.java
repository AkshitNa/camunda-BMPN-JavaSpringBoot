package com.nauti.BPMNParser.service;
import org.springframework.stereotype.Service;
import org.camunda.feel.FeelEngine;
import scala.util.Either;

import java.util.Map;

@Service
public class ExpressionEvaluatorFEELService {

    //Creating FEEL Engine
    private final FeelEngine myFeelEngine = new FeelEngine.Builder().build();

    //To Evaluate "Normal Expressions"
    public Object evaluateNormalExpression(String expression, Map<String, Object> variables) {

        //success or failure/error
        Either<FeelEngine.Failure, Object> result = myFeelEngine.evalExpression(expression, variables);
        if (result.isRight()) {
            return result.right().get(); //right side deals with "SUCCESS"
        } else {
            throw new RuntimeException("Evaluation failed: " + result.left().get());
        }
    }

    //To Evaluate "Single Expressions"
    public Object evaluateSingleTest(String expression, Map<String, Object> variables) {
        Either<FeelEngine.Failure, Object> result = myFeelEngine.evalUnaryTests(expression, variables);
        if (result.isRight()) {
            return result.right().get(); //right side deals with "SUCCESS"
        } else {
            throw new RuntimeException("Evaluation failed: " + result.left().get());
        }
    }
}
