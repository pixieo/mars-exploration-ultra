package com.codecool.marsexploration.model.map;

public record MapConfiguration(String filename, int mapWidth, int mountainCount, int[] mountainSizes, int pitCount, int[] pitSizes, int mineralCount, int waterCount) {
}
