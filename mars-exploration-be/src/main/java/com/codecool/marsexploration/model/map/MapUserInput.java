package com.codecool.marsexploration.model.map;

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
public class MapUserInput {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String filePath;
    private int mapWidth;
    private int numOfMountains;
    private int[] mountainSizes;
    private int numOfPits;
    private int[] pitSizes;
    private int numOfMinerals;
    private int numOfWaters;
}
