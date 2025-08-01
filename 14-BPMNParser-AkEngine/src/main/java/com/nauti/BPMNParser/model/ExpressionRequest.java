package com.nauti.BPMNParser.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class ExpressionRequest {
    private String expression;
    private Map<String, Object> variables;
    // Getters and setters
}
