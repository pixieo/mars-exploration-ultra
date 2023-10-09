package com.codecool.marsexploration.service;

import com.codecool.marsexploration.model.Coordinate;
import com.codecool.marsexploration.model.ExplorationUserInput;
import com.codecool.marsexploration.model.SimulationInput;
import com.codecool.marsexploration.repository.ExplorationRepository;
import com.codecool.marsexploration.service.routine.ExplorationRoutine;
import com.codecool.marsexploration.service.routine.ReturningRoutine;
import com.codecool.marsexploration.service.routine.Routine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ExplorationService {
    private final ExplorationRepository explorationRepository;

    @Autowired
    public ExplorationService(ExplorationRepository explorationRepository) {
        this.explorationRepository = explorationRepository;
    }

    public void createSimulation(ExplorationUserInput explorationUserInput) {
        explorationRepository.save(explorationUserInput);
    }

    public List<ExplorationUserInput> getAllInputs() {
        return explorationRepository.findAll();
    }

    public void deleteAll() { explorationRepository.deleteAll(); }

    public void runExploration(Long id) throws IOException {
        Optional<ExplorationUserInput> userInputOptional = explorationRepository.findById(id);

        if (userInputOptional.isPresent()) {
            ExplorationUserInput userInput = userInputOptional.get();

            List<Routine> routines = new ArrayList<>();
            routines.add(new ExplorationRoutine());
            routines.add(new ReturningRoutine());

            ExplorationSimulator simulator = new ExplorationSimulator(routines);

            Coordinate landing = new Coordinate(userInput.getXCoordinate(), userInput.getYCoordinate());
            SimulationInput input = new SimulationInput(
                    userInput.getMapFilePath(),
                    userInput.getRoverId(),
                    userInput.getRoverSight(),
                    landing,
                    userInput.getMineralCount(),
                    userInput.getWaterCount(),
                    userInput.getTimeout(),
                    userInput.getLogFilePath()
            );

            simulator.simulate(input);
        } else {
            System.out.println("No user with this id");
        }
    }

}
