package com.nauti.BPMNParser.service;

import jakarta.el.ELContext;
import jakarta.el.ExpressionFactory;
import jakarta.el.StandardELContext;
import jakarta.el.ValueExpression;
import org.apache.el.ExpressionFactoryImpl;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ExpressionEvaluatorService {

    public boolean evaluateExpression(String expression, Map<String, Object> variables) {
        try {
            //this engine can work on "${}" like expression
            ExpressionFactory expressionFactoryEngine = new ExpressionFactoryImpl();
            //creating a container which can hold the "${}" like expression
            ELContext contextEnvironment = new StandardELContext(expressionFactoryEngine);

            if (variables != null) {
                //Looping each "Variable"
                for (Map.Entry<String, Object> jsonVariables : variables.entrySet()) {
                    //Value Expression is a special format that my "Expression Engine" can understand
                    ValueExpression valExpr = expressionFactoryEngine.createValueExpression(jsonVariables.getValue(), Object.class);
                    //Assigning the respective values of "Variables".
                    contextEnvironment.getVariableMapper().setVariable(jsonVariables.getKey(), valExpr);
                }
            }

            // Camunda Expression Syntax Creation
            /*
            In JSON,
            Expression: "age == 12 && height == 13"
            variables: age = 10 and height = 15 //this will be stored in "CONTEXT ENVIRONMENT"
            through "VALUE EXPRESSION"
             */
            ValueExpression mainExpression = expressionFactoryEngine.createValueExpression(contextEnvironment, "${" + expression + "}", Boolean.class);
            //Executing my expression
            Object result = mainExpression.getValue(contextEnvironment);
            return Boolean.TRUE.equals(result);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}
