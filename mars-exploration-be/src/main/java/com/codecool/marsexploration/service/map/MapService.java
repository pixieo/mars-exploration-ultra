package com.codecool.marsexploration.service.map;

import com.codecool.marsexploration.model.map.MapConfiguration;
import com.codecool.marsexploration.model.map.MapUserInput;
import com.codecool.marsexploration.repository.MapRepository;
import com.codecool.marsexploration.service.map.generator.MapFileWriter;
import com.codecool.marsexploration.service.map.generator.MapGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class MapService {
    public final MapRepository mapRepository;
    @Autowired
    public MapService (MapRepository mapRepository) {
        this.mapRepository = mapRepository;
    }
    public void postMapData (MapUserInput mapUserInput) {
        mapRepository.save(mapUserInput);
    }
    public List<MapUserInput> getAllInputs() {
        return mapRepository.findAll();
    }
    public void createMap (Long id) throws IOException {
        Optional<MapUserInput> mapUserInputOptional = mapRepository.findById(id);

        if(mapUserInputOptional.isPresent()) {
            MapUserInput mapUserInput = mapUserInputOptional.get();
            MapConfiguration mapConfiguration = new MapConfiguration(
                    mapUserInput.getFilePath(),
                    mapUserInput.getMapWidth(),
                    mapUserInput.getNumOfMountains(),
                    mapUserInput.getMountainSizes(),
                    mapUserInput.getNumOfPits(),
                    mapUserInput.getPitSizes(),
                    mapUserInput.getNumOfMinerals(),
                    mapUserInput.getNumOfWaters());

            MapGenerator mapGenerator = new MapGenerator(mapConfiguration);
            try {
                mapGenerator.generateMap(mapConfiguration, 1000);

                MapFileWriter.writeMapToFile(mapConfiguration.filename(), mapGenerator.generateMap(mapConfiguration, 1000));
                System.out.println("Map saved to " + mapConfiguration.filename());
            } catch (IOException e) {
                System.out.println("Error saving map: " + e.getMessage());
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println("Error: " + illegalArgumentException.getMessage());
            }
        }
    }
}
