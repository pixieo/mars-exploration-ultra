package com.codecool.marsexploration.service.phase;

import com.codecool.marsexploration.model.Context;

public class StepIncrement implements Phase{
    @Override
    public void perform(Context context) {
        context.setStepNumber((int) (context.getStepNumber() + 1));
    }
}
