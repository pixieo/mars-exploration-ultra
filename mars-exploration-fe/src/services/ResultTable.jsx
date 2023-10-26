import React, { useEffect, useState } from "react";

const ResultTable = ({ endpoint, clicked, columns, property }) => {
    const [data, setData] = useState([]);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await fetch(endpoint, {
                    method: "GET",
                    headers: {
                        "Content-Type": "application/json",
                    },
                });

                if (!response.ok) {
                    throw new Error("Failed to fetch data: " + response.status);
                }

                const result = await response.json();
                setData(result);
            } catch (error) {
                console.error("Error fetching data:", error);
            }
        };

        fetchData();
    }, [endpoint]);

    return (
        <div className="result-table">
            {clicked ? 
            <table className="table table-danger table-striped table-hover" >
                <thead>
                    <tr>
                        {columns.map((col, index) => (
                            <th key={index} scope="col">{col}</th>
                        ))}
                    </tr>
                </thead>
                <tbody>
                    {data.map((item, index) => (
                        <tr key={index}>
                            <th scope="rox">{index + 1}</th>
                            <td key={index}>{item[property]}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
            : null}
        </div>
    );
};

export default ResultTable;
