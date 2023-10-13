import React from "react";
import worker from "../img/flame-remote-working.gif";
import { Link, useLocation } from "react-router-dom";
import MapResult from "./MapResult";
import ExploreResult from "./ExploreResult";

const Result = () => {
    const location = useLocation();
    return (
        <div>
            <img src={worker} alt="A GIF of a man working"/>
            <Link to="/" type="button" className="btn btn-outline-dark">Go back home</Link>
            {location.pathname === '/result/map' && <MapResult />}
            {location.pathname === '/result/explore' && <ExploreResult />}
        </div>
    );
};

export default Result;
