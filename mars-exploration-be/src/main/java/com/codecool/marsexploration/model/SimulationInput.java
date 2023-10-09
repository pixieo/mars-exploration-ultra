package com.codecool.marsexploration.model;

public record SimulationInput(
        String mapPath,
        String roverId,
        int roverSight,
        Coordinate landing,
        int mineralToCollect,
        int waterToCollect,
        int timeout,
        String logPath
) {}