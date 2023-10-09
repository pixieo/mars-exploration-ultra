package com.codecool.marsexploration.service.routine;

import com.codecool.marsexploration.model.Context;
import com.codecool.marsexploration.service.phase.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExplorationRoutine implements Routine{
    private final ExploringMovement exploringMovement;
    private final CollectResource collectResource;
    private final Scan scan;
    private final Analysis analysis;
    private final Log log;
    private final StepIncrement stepIncrement;
    private final ChangeExploringToReturning changeExploringToReturning;
    private final AddCoordOfResourcesToCollect addMinerals;
    private final AddCoordOfResourcesToCollect addWaters;

    public ExplorationRoutine() {
        this.exploringMovement = new ExploringMovement();
        this.collectResource = new CollectResource();
        this.scan = new Scan();
        this.analysis = new Analysis();
        this.log = new Log();
        this.stepIncrement = new StepIncrement();
        this.changeExploringToReturning = new ChangeExploringToReturning();
        this.addMinerals = new AddCoordOfResourcesToCollect('*');
        this.addWaters = new AddCoordOfResourcesToCollect('~');
    }
           @Override
    public void move(Context context) throws IOException {

               List<Phase> phases = new ArrayList<>();
               phases.add(addMinerals);
               phases.add(addWaters);
               phases.add(exploringMovement);
               phases.add(collectResource);
               phases.add(scan) ;
               phases.add(analysis);
               phases.add(log);
               phases.add(stepIncrement);
               phases.add(changeExploringToReturning);
               for (Phase phase : phases){
                   phase.perform(context);
               }
    }
    }

