package com.java8ex.filteringDictionary;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class FileLoader {

    public List<String> getAllWords(String path) {
        try {
            return readAllLines(path).stream()
                    .map(String::trim)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    private List<String> readAllLines(String path) throws IOException {
        return IOUtils.readLines(new FileInputStream(new File(path)), "UTF-8");
    }
}
