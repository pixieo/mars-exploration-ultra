import React, { useEffect, useState } from "react";

const MapResult = ({ clicked }) => {
    const [data, setData] = useState([]);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await fetch("http://localhost:8080/map", {
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
    }, []);

    return (
        <div className="result-table">
            {clicked ? 
            <table className="table table-danger table-striped table-hover" >
                <thead>
                    <tr>
                    <th scope="col">#</th>
                    <th scope="col">File name</th>
                    </tr>
                </thead>
                <tbody>
                    {data.map((item, index) => (
                        <tr key={index}>
                            <th scope="row"> {index} </th>
                            <td> {item.filePath} </td>
                        </tr>
                    ))}
                </tbody>
            </table>
            : null}
        </div>
    );
};

export default MapResult;
