package com.example.recipeapp.services;

import org.springframework.beans.factory.annotation.Value;

public interface FilesService {
    /*boolean saveToFile(String json);*/

    /*String readFromFile();*/

    /*@Value("${name.of.data.file}")
        private String dataFileName;*/

    boolean saveToFile(String json, String dataFileName);

    String readFromFile(String dataFileName);

    /*boolean cleanDataFile();*/

    boolean cleanDataFile(String dataFileName);
}
