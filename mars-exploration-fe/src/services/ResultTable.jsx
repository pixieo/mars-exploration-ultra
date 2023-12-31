import React, { useEffect, useState } from "react";

const deleteById = (endpoint, id) => {
    return fetch(`${endpoint}/delete/${id}`, { method: "DELETE" });
}

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

    const handleDelete = (endpoint, id) => {
        deleteById(endpoint, id)
        .catch((err) => {
            console.log(err);
        });

        setData((elements) => {
            return elements.filter((element) => element.id !== id);
        });
    }

    return (
        <div className="result-table">
            {clicked ? 
            <table className="table table-danger table-striped table-hover" >
                <thead>
                    <tr>
                        {columns.map((col, index) => (
                            <th key={index} scope="col">{col}</th>
                            
                        ))}
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    {data.map((item, index) => (
                        <tr key={index}>
                            <th scope="rox">{index + 1}</th>
                            <td key={index}>{item[property]}</td>
                            <td className="table-buttons">
                                <button type="button" className="btn btn-sm btn-outline-dark" >Run</button>
                                <button type="button" className="btn btn-sm btn-outline-dark" onClick={() => handleDelete(endpoint, item.id)}>Delete</button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
            : null}
        </div>
    );
};

export default ResultTable;
