package com.codecool.marsexploration.service.phase;

import com.codecool.marsexploration.model.Context;
import com.codecool.marsexploration.model.Symbol;

import java.io.IOException;
public class CollectResource implements Phase{
    @Override
    public void perform(Context context) throws IOException {
        int x = context.getRover().getPosition().x();
        int y = context.getRover().getPosition().y();

        if(x >= 0 && x < context.getMap().length && y >= 0 && y < context.getMap()[0].length){
            char currentRoverChar = context.getMap()[x][y];

            if (currentRoverChar == Symbol.MINERAL.getSymbol()) {
                context.getRover().setMineralsCollected(context.getRover().getMineralsCollected() + 1);
            }

            if (currentRoverChar == Symbol.WATER.getSymbol()) {
                context.getRover().setWaterCollected(context.getRover().getWaterCollected() + 1);
            }
        }
    }
}
