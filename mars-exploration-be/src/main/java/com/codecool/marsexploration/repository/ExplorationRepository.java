package com.codecool.marsexploration.repository;

import com.codecool.marsexploration.model.ExplorationUserInput;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExplorationRepository extends JpaRepository <ExplorationUserInput, Long> {
}
