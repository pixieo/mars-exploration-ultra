package com.codecool.marsexploration.model;

public class Context {
    private Coordinate startingCoords;
    private int stepNumber;
    private int timeout;
    private char[][] map;
    private Rover rover;
    private int numberOfMineralToCollect;
    private int numberOfWaterToCollect;
    private Outcome explorationOutcome;
    private boolean hasOutcomeBeenReached;
    private String logFile;

    public Context(int stepNumber, Coordinate startingCoords, int timeout, char[][] map, Rover rover, int numberOfMineralToCollect, int numberOfWaterToCollect, Outcome explorationOutcome, boolean hasOutcomeBeenReached, String logFile) {
        this.stepNumber = stepNumber;
        this.startingCoords = startingCoords;
        this.timeout = timeout;
        this.map = map;
        this.rover = rover;
        this.numberOfMineralToCollect = numberOfMineralToCollect;
        this.numberOfWaterToCollect = numberOfWaterToCollect;
        this.explorationOutcome = explorationOutcome;
        this.hasOutcomeBeenReached = hasOutcomeBeenReached;
        this.logFile = logFile;
    }

    public Coordinate getStartingCoords() {
        return startingCoords;
    }

    public void setStartingCoords(Coordinate startingCoords) {
        this.startingCoords = startingCoords;
    }

    public long getStepNumber() {
        return stepNumber;
    }

    public void setStepNumber(int stepNumber) {
        this.stepNumber = stepNumber;
    }

    public long getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public char[][] getMap() {
        return map;
    }

    public void setMap(char[][] map) {
        this.map = map;
    }

    public Rover getRover() {
        return rover;
    }

    public void setRover(Rover rover) {
        this.rover = rover;
    }

    public int getNumberOfMineralToCollect() {
        return numberOfMineralToCollect;
    }

    public void setNumberOfMineralToCollect(int numberOfMineralToCollect) {
        this.numberOfMineralToCollect = numberOfMineralToCollect;
    }

    public int getNumberOfWaterToCollect() {
        return numberOfWaterToCollect;
    }

    public void setNumberOfWaterToCollect(int numberOfWaterToCollect) {
        this.numberOfWaterToCollect = numberOfWaterToCollect;
    }

    public Outcome getExplorationOutcome() {
        return explorationOutcome;
    }

    public void setExplorationOutcome(Outcome explorationOutcome) {
        this.explorationOutcome = explorationOutcome;
    }

    public boolean hasOutcomeBeenReached() {
        return hasOutcomeBeenReached;
    }

    public void setHasOutcomeBeenReached(boolean hasOutcomeBeenReached) {
        this.hasOutcomeBeenReached = hasOutcomeBeenReached;
    }

    public String getLogFile() {
        return logFile;
    }

    public void setLogFile(String logFile) {
        this.logFile = logFile;
    }
}
