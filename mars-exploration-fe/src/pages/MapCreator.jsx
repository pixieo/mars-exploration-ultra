import React from "react";
import MapForm from "../components/MapForm";
import ItemCreator from "../services/ItemCreator";

const MapCreator = () => {
  return (
    <ItemCreator
      formComponent={MapForm}
      url="map"
      successMessage="Map created successfully" 
    />
  );
};

export default MapCreator;