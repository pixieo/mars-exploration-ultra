package com.codecool.marsexploration.service;

import com.codecool.marsexploration.model.Context;
import com.codecool.marsexploration.model.Coordinate;
import com.codecool.marsexploration.model.Rover;
import com.codecool.marsexploration.model.SimulationInput;
import com.codecool.marsexploration.service.filereader.MapCoordinates;
import com.codecool.marsexploration.service.filereader.ReadMap;
import com.codecool.marsexploration.service.phase.Scan;
import com.codecool.marsexploration.service.routine.Routine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExplorationSimulator {
    private final List<Routine> routines;
    public ExplorationSimulator(List<Routine> routines) {
        this.routines = routines;
    }
    public void simulate(SimulationInput input) throws IOException {
        List<Coordinate> mineralToCollect = new ArrayList<>();
        List<Coordinate> waterToCollect = new ArrayList<>();
        Set<Coordinate> trackRecords = new HashSet<>();

        Scan scan = new Scan();

        Rover rover = new Rover(
                input.roverId(),
                input.landing(),
                input.roverSight(),
                mineralToCollect,
                waterToCollect,
                0,
                0,
                routines.get(0),
                trackRecords,
                false);

        Context context = new Context(
                1,
                input.landing(),
                input.timeout(),
                MapCoordinates.getMapCoordinates(ReadMap.readFileToString(input.mapPath())),
                rover,
                input.mineralToCollect(),
                input.waterToCollect(),
                null,
                false,
                input.logPath()
        );

        scan.perform(context);

        while(!context.hasOutcomeBeenReached()) {
            context.getRover().getRoutine().move(context);
        }
    }
}
