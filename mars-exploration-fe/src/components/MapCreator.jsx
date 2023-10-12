import React from "react";
import MapForm from "./MapForm";
import { useNavigate } from "react-router-dom";

const createMap = (map) => {
  return fetch("/map/create", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(map),
  })
  .then((res) => {
    if (!res.ok) {
      throw new Error("Failed to create the map.");
    }
    return res.json();
  })
  .catch((err) => {
    console.error("Error creating map:", err);
  });
};

const MapCreator = () => {
  const navigate = useNavigate();

  const handleCreateMap = (map) => {
    createMap(map)
      .then((result) => {
        console.log("Map created successfully:", result);
        navigate("/result");
      })
      .catch((err) => {
        console.error("Failed to create map:", err);
      });
  };

  return (
    <MapForm onSave={handleCreateMap} />
  );
};

export default MapCreator;