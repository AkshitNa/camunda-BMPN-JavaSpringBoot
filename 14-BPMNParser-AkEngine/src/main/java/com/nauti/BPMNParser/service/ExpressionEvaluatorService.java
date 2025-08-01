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
            ExpressionFactory factory = new ExpressionFactoryImpl();
            ELContext context = new StandardELContext(factory);

            if (variables != null) {
                for (Map.Entry<String, Object> entry : variables.entrySet()) {
                    ValueExpression valExpr = factory.createValueExpression(entry.getValue(), Object.class);
                    context.getVariableMapper().setVariable(entry.getKey(), valExpr);
                }
            }

            // Camunda Expression Syntax :: ${age > 12}
            ValueExpression expr = factory.createValueExpression(context, "${" + expression + "}", Boolean.class);

            Object result = expr.getValue(context);
            return Boolean.TRUE.equals(result);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}
