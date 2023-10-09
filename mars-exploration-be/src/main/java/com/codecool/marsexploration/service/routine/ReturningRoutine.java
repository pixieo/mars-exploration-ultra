package com.codecool.marsexploration.service.routine;

import com.codecool.marsexploration.model.Context;
import com.codecool.marsexploration.service.phase.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReturningRoutine implements Routine{
    private final ReturningMovement returningMovement;
    private final Scan scan;
    private final Analysis analysis;
    private final Log log;
    private final StepIncrement stepIncrement;

    public ReturningRoutine() {
        this.returningMovement = new ReturningMovement();
        this.scan = new Scan();
        this.analysis = new Analysis();
        this.log = new Log();
        this.stepIncrement = new StepIncrement();
    }

    @Override
    public void move(Context context) throws IOException {
        List<Phase> phases = new ArrayList<>();
        phases.add(returningMovement);
        phases.add(scan);
        phases.add(analysis);
        phases.add(log);
        phases.add(stepIncrement);
        for (Phase phase : phases){
            phase.perform(context);
        }
    }
}
