package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExportCommand implements Command {
    private DocumentRepository repository;
    private String output;

    public ExportCommand(DocumentRepository repository, String output) {
        this.repository = repository;
        this.output = output;
    }

    @Override
    public void execute(DocumentRepository repository) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        File repo = new File("masterDirectory");
        File[] files = repo.listFiles();
        String jsonData = "";
        Map<Integer, String> map = new HashMap<>();
        if (files == null || files.length == 0) {
            System.out.println("Repository is empty");
            return;
        }
        int i = 0;
        for (File file : files) {
            if (file.isFile()) {
                map.put(i,file.getName());i++;
                jsonData = mapper.writeValueAsString(map);
            }
        }
        Path outputFile = Paths.get(output);
        Files.write(outputFile, jsonData.getBytes());

        System.out.println("Repository data exported to file: " + outputFile);
    }
}
