package com.example.WebClient.util;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
@Component
public class ReadFileInfo {
    public String returnContent() throws IOException {
        Resource resource = new ClassPathResource("third-party-api.txt");

        File file = resource.getFile();
        return new String(Files.readAllBytes(file.toPath()));

    }
}
