package com.codecool.marsexploration.service.phase;

import com.codecool.marsexploration.model.Context;

public class ReturningMovement implements Phase{
    @Override
    public void perform(Context context) {
        context.getRover().setPosition(context.getStartingCoords());
    }
}
