package com.codecool.marsexploration.service.filereader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadMap {
    public static String readFileToString(String pathName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(pathName)));
    }
}
