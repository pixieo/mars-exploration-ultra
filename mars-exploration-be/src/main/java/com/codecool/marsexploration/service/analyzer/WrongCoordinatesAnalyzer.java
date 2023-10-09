package com.codecool.marsexploration.service.analyzer;

import com.codecool.marsexploration.model.Context;
import com.codecool.marsexploration.model.Outcome;
import com.codecool.marsexploration.model.Symbol;

import java.util.Optional;

public class WrongCoordinatesAnalyzer implements Analyzer {


    @Override
    public Optional<Outcome> analyze(Context context) {
        int mapRows = context.getMap().length;
        int mapCols = context.getMap()[0].length;
        int landingX = context.getRover().getPosition().x();
        int landingY = context.getRover().getPosition().y();
        if ((context.getStepNumber() == 1) &&
                ((landingX < 0 || landingX >= mapRows) || (landingY < 0 || landingY >= mapCols) ||
                        context.getMap()[landingX][landingY] == Symbol.MOUNTAIN.getSymbol() ||
                        context.getMap()[landingX][landingY] == Symbol.PIT.getSymbol())) {
            context.setHasOutcomeBeenReached(true);
            context.setExplorationOutcome(Outcome.WRONG_LANDING_COORDINATES);
        }
        return Optional.empty();
    }
}
