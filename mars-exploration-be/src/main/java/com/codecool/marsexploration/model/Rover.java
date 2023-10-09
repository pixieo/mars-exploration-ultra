package com.codecool.marsexploration.model;

import com.codecool.marsexploration.service.routine.Routine;

import java.util.List;
import java.util.Set;

public class Rover {
    public int getMineralsCollected() {
        return mineralsCollected;
    }

    public void setMineralsCollected(int mineralsCollected) {
        this.mineralsCollected = mineralsCollected;
    }

    public int getWaterCollected() {
        return waterCollected;
    }

    public void setWaterCollected(int waterCollected) {
        this.waterCollected = waterCollected;
    }

    private final String id;
    private Coordinate position;
    private final int sight;
    private List<Coordinate> coordinatesOfMineralToCollect;
    private List<Coordinate> coordinatesOfWaterToCollect;
    private int mineralsCollected;
    private int waterCollected;
    private Routine routine;
    private Set<Coordinate> trackRecords;
    private boolean alienSpotted;

    public Rover(String id, Coordinate position, int sight, List<Coordinate> numberOfMineralCollected, List<Coordinate> numberOfWaterCollected, int mineralsCollected, int waterCollected, Routine routine, Set<Coordinate> trackRecords, boolean alienSpotted) {
        this.id = id;
        this.position = position;
        this.sight = sight;
        this.coordinatesOfMineralToCollect = numberOfMineralCollected;
        this.coordinatesOfWaterToCollect = numberOfWaterCollected;
        this.mineralsCollected = mineralsCollected;
        this.waterCollected = waterCollected;
        this.routine = routine;
        this.trackRecords = trackRecords;
        this.alienSpotted = alienSpotted;
    }

    public boolean isAlienSpotted() {
        return alienSpotted;
    }

    public void setAlienSpotted(boolean alienSpotted) {
        this.alienSpotted = alienSpotted;
    }

    public String getId() {
        return id;
    }

    public Coordinate getPosition() {
        return position;
    }

    public int getSight() {
        return sight;
    }

    public List<Coordinate> getCoordinatesOfMineralToCollect() {
        return coordinatesOfMineralToCollect;
    }

    public List<Coordinate> getCoordinatesOfWaterToCollect() {
        return coordinatesOfWaterToCollect;
    }

    public Routine getRoutine() {
        return routine;
    }

    public Set<Coordinate> getTrackRecords() {
        return trackRecords;
    }

    public void setPosition(Coordinate position) {
        this.position = position;
    }

    public void setCoordinatesOfMineralToCollect(List<Coordinate> coordinatesOfMineralToCollect) {
        this.coordinatesOfMineralToCollect = coordinatesOfMineralToCollect;
    }
    public void setCoordinatesOfWaterToCollect(List<Coordinate> coordinatesOfWaterToCollect) {
        this.coordinatesOfWaterToCollect = coordinatesOfWaterToCollect;
    }
    public void setRoutine(Routine routine) {
        this.routine = routine;
    }

    public void setTrackRecords(Set<Coordinate> trackRecords) {
        this.trackRecords = trackRecords;
    }
}
