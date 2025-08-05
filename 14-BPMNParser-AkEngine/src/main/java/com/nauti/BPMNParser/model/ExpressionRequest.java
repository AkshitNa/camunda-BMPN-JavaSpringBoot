package com.nauti.BPMNParser.model;

import lombok.*;

import java.util.Map;

@Getter
@Setter
//Format of my JSON
public class ExpressionRequest {
    @NonNull
    private String expression;
    private Map<String, Object> variables;
    // Getters and setters
}
