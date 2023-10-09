package com.codecool.marsexploration.service.analyzer;

import com.codecool.marsexploration.model.Context;
import com.codecool.marsexploration.model.Outcome;

import java.util.Optional;

public class TimeoutAnalyzer implements Analyzer{
    @Override
    public Optional<Outcome> analyze(Context context) {
        if (context.getStepNumber() == context.getTimeout()) {
            context.setHasOutcomeBeenReached(true);
            return Optional.of(Outcome.TIMEOUT);
        }
        return Optional.empty();
    }
}
