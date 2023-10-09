package com.codecool.marsexploration.controller;

import com.codecool.marsexploration.model.ExplorationUserInput;
import com.codecool.marsexploration.service.ExplorationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/exploration")
public class ExplorationController {
    private final ExplorationService explorationService;
    @Autowired
    public ExplorationController(ExplorationService explorationService) {
        this.explorationService = explorationService;
    }
    @DeleteMapping
    public void deleteAll() {
        explorationService.deleteAll();
    }
    @PostMapping
    public void collectDataFromUser(@RequestBody ExplorationUserInput explorationUserInput) {
        explorationService.createSimulation(explorationUserInput);
    }
    @GetMapping
    public List<ExplorationUserInput> getInputs(){
        return explorationService.getAllInputs();
    }
    @GetMapping("/run/{id}")
    public ResponseEntity<String> runExploration(@PathVariable Long id) {
        try {
            explorationService.runExploration(id);
            return ResponseEntity.ok("Exploration started successfully.");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to start exploration.");
        }
    }
}


