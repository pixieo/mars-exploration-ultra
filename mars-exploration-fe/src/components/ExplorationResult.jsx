import React from "react";
import ResultTable from "../services/ResultTable";

const ExplorationResult = ({ clicked }) => {
    const columns = ["#", "Rover id"];
    const property = "roverId";
    const endpoint = "http://localhost:8080/exploration";

    return (
        <ResultTable endpoint={endpoint} clicked={clicked} columns={columns} property={property}/>
    );
};

export default ExplorationResult;