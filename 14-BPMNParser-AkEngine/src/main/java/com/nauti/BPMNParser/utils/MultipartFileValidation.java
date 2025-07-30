package com.nauti.BPMNParser.utils;

import org.springframework.web.multipart.MultipartFile;

public class MultipartFileValidation {

    public static void validateFile(MultipartFile file) {
        if (file == null || file.isEmpty()) {
            throw new IllegalArgumentException("No BPMN file provided");
        }
        String filename = file.getOriginalFilename();
        if (filename == null || !filename.toLowerCase().endsWith(".bpmn")) {
            throw new IllegalArgumentException("File must have a .bpmn extension");
        }
    }
}
