import React, { useEffect, useState } from "react";

const ExploreResult = () => {
    const [data, setData] = useState([]);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await fetch("http://localhost:8080/exploration", {
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
        <div>
            <ul>
                {data.map((item) => (
                    <li key={item.id}>Item id: {item.id}, Rover id: {item.roverId}</li>
                ))}
            </ul>
        </div>
    );
};

export default ExploreResult;