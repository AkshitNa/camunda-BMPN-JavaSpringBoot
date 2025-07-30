package com.nauti.BPMNParser.service;

import com.nauti.BPMNParser.utils.MultipartFileValidation;
import org.camunda.bpm.model.bpmn.Bpmn;
import org.camunda.bpm.model.bpmn.BpmnModelInstance;
import org.camunda.bpm.model.xml.ModelParseException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.InputStream;

@Service
public class BpmnParserService {

    public String parseBpmnFile(MultipartFile file) throws Exception {
         //File Validation
        MultipartFileValidation.validateFile(file);

        try (InputStream inputStream = file.getInputStream()) {
            BpmnModelInstance bpmnModelInstance = Bpmn.readModelFromStream(inputStream);
            return BpmnElementExtractor.extractBPMNDetails(bpmnModelInstance);
        } catch (ModelParseException e) {
            System.out.println("ModelParseException while parsing BPMN file: " + e.getMessage());
            throw new IllegalArgumentException("Invalid BPMN structure: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error while parsing BPMN: " + e.getMessage());
            throw new Exception("Unexpected error while parsing BPMN file", e);
        }
    }
}
