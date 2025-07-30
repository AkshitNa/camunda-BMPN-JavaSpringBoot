package com.nauti.BPMNParser.service;

import org.camunda.bpm.model.bpmn.Bpmn;
import org.camunda.bpm.model.bpmn.BpmnModelInstance;
import org.camunda.bpm.model.bpmn.instance.FlowElement;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.camunda.bpm.model.bpmn.instance.Process;

import java.io.InputStream;
import java.util.Collection;

@Service
public class BpmnParserService {

    public String parseBpmnFile(MultipartFile file) throws Exception {
        try (InputStream inputStream = file.getInputStream()) {
            BpmnModelInstance modelInstance = Bpmn.readModelFromStream(inputStream);

            StringBuilder result = new StringBuilder();

            Collection<Process> processes = modelInstance.getModelElementsByType(Process.class);
            for (Process process : processes) {
                result.append("Process ID: ").append(process.getId()).append("\n");
                result.append("Process Name: ").append(process.getName()).append("\n\n");

                Collection<FlowElement> elements = process.getFlowElements();
                for (FlowElement element : elements) {
                    result.append("Element Type: ").append(element.getElementType().getTypeName())
                            .append(", ID: ").append(element.getId()).append("\n");
                }
            }

            return result.toString();
        }
    }
}
