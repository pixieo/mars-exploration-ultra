import React from "react";
import { useNavigate } from "react-router-dom";
import ExplorationForm from "../components/ExplorationForm";

const createExploration = (input) => {
  return fetch("http://localhost:8080/exploration", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(input),
  })
  .then((res) => {
    if (!res.ok) {
      throw new Error("Failed.");
    }
    return res.json();
  })
  .catch((err) => {
    console.error("Error:", err);
  });
};

const ExplorationCreator = () => {
  const navigate = useNavigate();

  const handleExploration = (input) => {
    createExploration(input)
      .then((result) => {
        console.log("Exploration created successfully. Id:", result);
        navigate("/result/exploration");
      })
      .catch((err) => {
        console.error("Failure", err);
      });
  };

  return (
    <ExplorationForm 
        onSave={handleExploration}
    />
  );
};

export default ExplorationCreator;