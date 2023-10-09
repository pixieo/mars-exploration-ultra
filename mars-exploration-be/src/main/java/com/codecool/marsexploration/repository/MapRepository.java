package com.codecool.marsexploration.repository;

import com.codecool.marsexploration.model.map.MapUserInput;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MapRepository extends JpaRepository<MapUserInput, Long> {
}
