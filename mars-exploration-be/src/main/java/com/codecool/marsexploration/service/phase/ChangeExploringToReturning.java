package com.codecool.marsexploration.service.phase;

import com.codecool.marsexploration.model.Context;
import com.codecool.marsexploration.service.routine.ReturningRoutine;

import java.io.IOException;

public class ChangeExploringToReturning implements Phase{
    @Override
    public void perform(Context context) throws IOException {
        if(context.getRover().getMineralsCollected() == context.getNumberOfMineralToCollect() &&
            context.getRover().getWaterCollected() == context.getNumberOfWaterToCollect()) {

            context.getRover().setRoutine(new ReturningRoutine());
        }
    }
}
