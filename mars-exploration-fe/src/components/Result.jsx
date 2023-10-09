import React, { useEffect, useState } from "react";
import worker from "../img/flame-remote-working.gif";
import { Link } from "react-router-dom";

const Result = () => {
    const [data, setData] = useState([]);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await fetch("http://localhost:6543/exploration", {
                    method: "GET",
                    headers: {
                        "Content-Type": "application/json"
                    },
                });

                if (!response.ok) {
                    throw new Error("Failed to fetch data");
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
            <img src={worker} alt="A GIF of a man working"/>
            <Link to="/" type="button" className="btn btn-outline-dark">Go back home</Link>
            <ul>
                {data.map((item) => (
                    <li key={item.id}>{item.name}</li>
                ))}
            </ul>
        </div>
    );
};

export default Result;
