package com.codecool.marsexploration.service.phase;

import com.codecool.marsexploration.model.Context;
import com.codecool.marsexploration.model.Symbol;
import com.codecool.marsexploration.service.routine.AproachingAlienRoutine;

import java.io.IOException;

public class ChangeExploringToAproachingAlien implements Phase{
    @Override
    public void perform(Context context) throws IOException {
        if(context.getRover().getTrackRecords().contains(Symbol.ALIEN.getSymbol())){
            context.getRover().setRoutine(new  AproachingAlienRoutine());
        }
    }
}
