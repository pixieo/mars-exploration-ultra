package com.codecool.marsexploration.service.analyzer;

import com.codecool.marsexploration.model.Context;
import com.codecool.marsexploration.model.Outcome;

import java.util.Optional;

public class SuccessAnalyzer implements Analyzer{
    @Override
    public Optional<Outcome> analyze(Context context) {
        if (context.getRover().getMineralsCollected() >= context.getNumberOfMineralToCollect() && context.getRover().getWaterCollected() >= context.getNumberOfWaterToCollect()) {
            context.setHasOutcomeBeenReached(true);
            return Optional.of(Outcome.COLONIZABLE);
        }
        return Optional.empty();
    }
}
