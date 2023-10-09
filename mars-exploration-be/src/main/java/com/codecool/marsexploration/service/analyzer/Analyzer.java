package com.codecool.marsexploration.service.analyzer;

import com.codecool.marsexploration.model.Context;
import com.codecool.marsexploration.model.Outcome;

import java.util.Optional;

public interface Analyzer {
    Optional<Outcome> analyze(Context context);
}
