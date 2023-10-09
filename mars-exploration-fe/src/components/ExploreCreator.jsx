import React from "react";
import { useNavigate } from "react-router-dom";
import ExploreForm from "./ExploreForm";

const createExplore = (input) => {
  return fetch("http://localhost:6543/exploration", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(input),
  })
  .then((res) => {
    console.log(res)
    if (!res.ok) {
      throw new Error("Failed.");
    }
    return res.json();
  })
  .catch((err) => {
    console.error("Error:", err);
  });
};

const ExploreCreator = () => {
  const navigate = useNavigate();

  const handleExplore = (input) => {
    createExplore(input)
      .then((result) => {
        console.log("Result:", result);
        navigate("/result");
      })
      .catch((err) => {
        console.error("Failure", err);
      });
  };

  return (
    <ExploreForm 
        onSave={handleExplore}
    />
  );
};

export default ExploreCreator;