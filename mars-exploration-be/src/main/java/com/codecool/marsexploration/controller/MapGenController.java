package com.codecool.marsexploration.controller;

import com.codecool.marsexploration.model.map.MapUserInput;
import com.codecool.marsexploration.service.map.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/map")
public class MapGenController {
    private final MapService mapService;
    @Autowired
    public MapGenController (MapService mapService) {
        this.mapService = mapService;
    }
    @PostMapping
    public void postMapData(@RequestBody MapUserInput mapUserInput) {
        mapService.postMapData(mapUserInput);
    }
    @GetMapping
    public List<MapUserInput> getData () {
        return mapService.getAllInputs();
    }
    @GetMapping("/run/{id}")
    public void getMap(@PathVariable Long id) throws IOException {
        mapService.createMap(id);
    }

}
