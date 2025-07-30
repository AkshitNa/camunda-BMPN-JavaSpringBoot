package com.nauti.BPMNParser.service;

import org.camunda.bpm.model.bpmn.BpmnModelInstance;
import org.camunda.bpm.model.bpmn.instance.*;
import org.camunda.bpm.model.bpmn.instance.Process;

import java.util.Collection;

public class BpmnElementExtractor {

    public static String extractBPMNDetails(BpmnModelInstance modelInstance) {
        StringBuilder result = new StringBuilder();

        Collection<Process> processes = modelInstance.getModelElementsByType(Process.class);
        for (Process process : processes) {
            result.append("Process ID: ").append(process.getId()).append("\n");
            result.append("Process Name: ").append(process.getName()).append("\n\n");

            Collection<FlowElement> elements = process.getFlowElements();
            for (FlowElement element : elements) {
                result.append("Element Type: ").append(element.getElementType().getTypeName())
                        .append(", ID: ").append(element.getId());

                if (element instanceof StartEvent) {
                    result.append(" (Start Event)");
                } else if (element instanceof EndEvent) {
                    result.append(" (End Event)");
                } else if (element instanceof UserTask) {
                    UserTask task = (UserTask) element;
                    result.append(" (User Task) - Name: ").append(task.getName());
                    result.append(", Assignee: ").append(task.getCamundaAssignee());
                } else if (element instanceof ServiceTask) {
                    ServiceTask task = (ServiceTask) element;
                    result.append(" (Service Task) - Name: ").append(task.getName());
                    result.append(", Implementation: ").append(task.getCamundaClass());
                } else if (element instanceof ExclusiveGateway) {
                    result.append(" (Exclusive Gateway)");
                } else if (element instanceof ParallelGateway) {
                    result.append(" (Parallel Gateway)");
                } else if (element instanceof SequenceFlow) {
                    SequenceFlow flow = (SequenceFlow) element;
                    result.append(" (Sequence Flow) - From: ").append(flow.getSource().getId())
                            .append(", To: ").append(flow.getTarget().getId());
                }
                result.append("\n");
            }
        }
        return result.toString();
    }
}

