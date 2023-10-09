package com.codecool.marsexploration.service.filereader;

import java.util.List;

public class MapCoordinates {
    public static char[][] getMapCoordinates(String mapString) {
        List<String> mapRows = mapString.lines().toList();

        int numRows = mapRows.size();
        int numCols = mapRows.get(0).length();

        char[][] map = new char[numRows][numCols];

        for (int rowIndex = 0; rowIndex < numRows; rowIndex++) {
            for (int colIndex = 0; colIndex < numCols; colIndex++) {
                map[rowIndex][colIndex] = mapRows.get(rowIndex).charAt(colIndex);
            }
        }

        return map;
    }
}
