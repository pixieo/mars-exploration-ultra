package com.codecool.marsexploration.service.phase;

import com.codecool.marsexploration.model.Context;
import com.codecool.marsexploration.model.Coordinate;
import com.codecool.marsexploration.model.Symbol;

import java.util.ArrayList;
import java.util.List;

public class Scan implements Phase{
    @Override
    public void perform(Context context) {
        List<Coordinate> neighbouringCoords = getNeighbouringCoordsDependingOnRoverSight(context.getRover().getPosition(), context.getRover().getSight(), context);
        for (Coordinate coordinate : neighbouringCoords) {
            char coordinateChar = context.getMap()[coordinate.x()][coordinate.y()];

            if (coordinateChar == Symbol.MINERAL.getSymbol()) {
                context.getRover().getCoordinatesOfMineralToCollect().add(coordinate);
            }
            if (coordinateChar == Symbol.WATER.getSymbol()) {
                context.getRover().getCoordinatesOfWaterToCollect().add(coordinate);
            }
            if (coordinateChar == Symbol.ALIEN.getSymbol()){
                context.getRover().setAlienSpotted(true);
            }
        }
    }

    private List<Coordinate> getNeighbouringCoordsDependingOnRoverSight(Coordinate currentPosition, int sight, Context context) {
        List<Coordinate> neighbouringCoords = new ArrayList<>();

        for (int x = currentPosition.x() - sight; x < currentPosition.x() + sight ; x++) {
            for (int y = currentPosition.y() - sight; y < currentPosition.y() + sight; y++) {

                if (isWithinMapRange(x, y, context)) {
                    if (x != currentPosition.x() && y != currentPosition.y()) {
                        neighbouringCoords.add(new Coordinate(x, y));
                    }
                }
            }
        }

        return neighbouringCoords;
    }

    private boolean isWithinMapRange(int x, int y, Context context) {
        return x >= 0 && x < context.getMap().length && y >= 0 && y < context.getMap()[0].length;
    }
}
