package com.nauti.BPMNParser.controller;

import com.nauti.BPMNParser.service.BpmnParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/bpmn")
public class BpmnParserController {

    @Autowired
    private BpmnParserService bpmnParserService;

    @PostMapping("/parse")
    public ResponseEntity<String> parseBpmn(@RequestParam("file") MultipartFile file) {
        try {
            String result = bpmnParserService.parseBpmnFile(file);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error parsing BPMN: " + e.getMessage());
        }
    }
}
