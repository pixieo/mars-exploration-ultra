package com.codecool.marsexploration.service.phase;

import com.codecool.marsexploration.model.Context;
import com.codecool.marsexploration.model.Outcome;
import com.codecool.marsexploration.service.analyzer.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Analysis implements Phase {
    private final List<Analyzer> analyzers;

    public Analysis() {
        this.analyzers = new ArrayList<>();
        this.analyzers.add(new SuccessAnalyzer());
        this.analyzers.add(new TimeoutAnalyzer());
        this.analyzers.add(new LackOfResourcesAnalyzer());
        this.analyzers.add(new WrongCoordinatesAnalyzer());
        this.analyzers.add(new AlienSpotter());
    }

    @Override
    public void perform(Context context) {
        int mapRows = context.getMap().length;
        int mapCols = context.getMap()[0].length;
        int landingX = context.getRover().getPosition().x();
        int landingY = context.getRover().getPosition().y();
        Optional<Outcome> outcome;


            for (Analyzer analyzer: analyzers) {
                outcome = analyzer.analyze(context);
                outcome.ifPresent(context::setExplorationOutcome);
            }

    }
}
