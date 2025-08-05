package com.nautiDev.BPMNParser.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nauti.BPMNParser.controller.ExpressionEvaluatorFEELController;
import com.nauti.BPMNParser.model.ExpressionRequest;
import com.nauti.BPMNParser.service.ExpressionEvaluatorFEELService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Map;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

public class ExpressionEvaluatorFEELControllerTest {

    @Mock
    private ExpressionEvaluatorFEELService feelEvaluationService;

    @InjectMocks
    private ExpressionEvaluatorFEELController expressionEvaluatorFEELController;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(expressionEvaluatorFEELController).build();
        objectMapper = new ObjectMapper();
    }

    @DisplayName("Test :: Unary Test Evaluation")
    @Test
    void testEvaluateUnaryTests() throws Exception {

        //Creating Request
        ExpressionRequest request = new ExpressionRequest();
        request.setExpression("x<5");
        request.setVariables(Map.of("x", 3));

        // Mock the service call
        when(feelEvaluationService.evaluateSingleTest(request.getExpression(), request.getVariables()))
                .thenReturn("true");

        String jsonData = objectMapper.writeValueAsString(request);

        // Perform the request and verify
        mockMvc.perform(post("/feelEvaluateUnary")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonData))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }

    @DisplayName("Test :: Normal Expression Evaluation")
    @Test
    void testEvaluateExpression() throws Exception {

        //Creating Request
        ExpressionRequest request = new ExpressionRequest();
        request.setExpression("if x > 10 then \"high\" else \"low\"");
        request.setVariables(Map.of("x", 20));

        // Mock the service call
        when(feelEvaluationService.evaluateNormalExpression(request.getExpression(), request.getVariables()))
                .thenReturn("high");

        String jsonData = objectMapper.writeValueAsString(request);

        // Perform the request and verify
        mockMvc.perform(post("/feelEvaluate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonData))
                .andExpect(status().isOk())
                .andExpect(content().string("high"));
    }
}