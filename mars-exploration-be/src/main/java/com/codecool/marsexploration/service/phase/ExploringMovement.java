package com.codecool.marsexploration.service.phase;

import com.codecool.marsexploration.model.Context;
import com.codecool.marsexploration.model.Coordinate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class ExploringMovement implements Phase{
    @Override
    public void perform(Context context) {
        Coordinate currentPosition = context.getRover().getPosition();
        List<Coordinate> neighbouringCoords = getNeighbouringCoords(currentPosition);
        Coordinate nextPosition = chooseNextPosition(neighbouringCoords, context);
        context.getRover().setPosition(nextPosition);
    }

    private Coordinate chooseNextPosition(List<Coordinate> neighbouringCoords, Context context){
        Set<Coordinate> visitedCoords = context.getRover().getTrackRecords();

        List<Coordinate> unvisitedCoords = neighbouringCoords.stream()
                .filter(coordinate -> !visitedCoords.contains(coordinate))
                .toList();

        if (unvisitedCoords.isEmpty()) {
            return context.getRover().getPosition();
        } else {
            int randomIndex = new Random().nextInt(unvisitedCoords.size());
            return unvisitedCoords.get(randomIndex);
        }
    }

    public static List<Coordinate> getNeighbouringCoords(Coordinate currentPosition){
        List<Coordinate> neighbouringCoords = new ArrayList<>();
        Coordinate upperNeigh = new Coordinate(currentPosition.x(),currentPosition.y() + 1);
        Coordinate lowerNeigh = new Coordinate(currentPosition.x(), currentPosition.y() - 1);
        Coordinate leftNeigh = new Coordinate(currentPosition.x() - 1, currentPosition.y());
        Coordinate rightNeigh = new Coordinate(currentPosition.x() + 1, currentPosition.y());
        neighbouringCoords.add(upperNeigh);
        neighbouringCoords.add(lowerNeigh);
        neighbouringCoords.add(leftNeigh);
        neighbouringCoords.add(rightNeigh);
        return neighbouringCoords;
    }
}
