package com.codecool.marsexploration.service.analyzer;

import com.codecool.marsexploration.model.Context;
import com.codecool.marsexploration.model.Outcome;

import java.util.Optional;

public class LackOfResourcesAnalyzer implements Analyzer{
    @Override
    public Optional<Outcome> analyze(Context context) {
        if (context.getRover().getCoordinatesOfMineralToCollect().size() <= context.getNumberOfMineralToCollect()
                && context.getRover().getCoordinatesOfWaterToCollect().size() <= context.getNumberOfWaterToCollect()) {
            context.setHasOutcomeBeenReached(true);
            return Optional.of(Outcome.NOT_COLONIZABLE_RESOURCES);
        }
        return Optional.empty();
    }
}
