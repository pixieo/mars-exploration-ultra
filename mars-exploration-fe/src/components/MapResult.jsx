import React from "react";
import ResultTable from "../services/ResultTable";

const MapResult = ({ clicked }) => {
    const columns = ["#", "File name"];
    const property = "filePath";
    const endpoint = "http://localhost:8080/map";

    return (
        <ResultTable endpoint={endpoint} clicked={clicked} columns={columns} property={property}/>
    );
};

export default MapResult;