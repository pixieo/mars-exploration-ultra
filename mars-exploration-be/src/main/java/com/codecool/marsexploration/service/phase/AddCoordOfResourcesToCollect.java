package com.codecool.marsexploration.service.phase;

import com.codecool.marsexploration.model.Context;
import com.codecool.marsexploration.model.Coordinate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddCoordOfResourcesToCollect implements Phase {
    private char targetSymbol;
    public AddCoordOfResourcesToCollect (char targetSymbol) {
        this.targetSymbol = targetSymbol;
    }
    @Override
    public void perform(Context context) throws IOException {
        char[][] map = context.getMap();
        List<Coordinate> coordinatesToCollect = new ArrayList<>();

        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map[0].length; y++) {
                if (map[x][y] == targetSymbol) {
                    coordinatesToCollect.add(new Coordinate(x, y));
                }
            }
        }
        if (targetSymbol == '*') {
            context.getRover().setCoordinatesOfMineralToCollect(coordinatesToCollect);
        } else if (targetSymbol == '~') {
            context.getRover().setCoordinatesOfWaterToCollect(coordinatesToCollect);
        }
    }
}
