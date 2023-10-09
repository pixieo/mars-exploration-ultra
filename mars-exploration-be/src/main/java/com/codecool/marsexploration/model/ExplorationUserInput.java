package com.codecool.marsexploration.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExplorationUserInput {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String mapFilePath;
    private String logFilePath;
    private String roverId;
    private int roverSight;
    private int timeout;
    private int mineralCount;
    private int waterCount;
    private int xCoordinate;
    private int yCoordinate;
}
