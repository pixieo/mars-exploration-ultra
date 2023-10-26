import React from "react";
import ExplorationForm from "../components/ExplorationForm";
import ItemCreator from "../services/ItemCreator";

const ExplorationCreator = () => {
    return (
        <ItemCreator
            formComponent={ExplorationForm}
            url="exploration"
            successMessage="Exploration created successfully"
        />
    );
};

export default ExplorationCreator;
