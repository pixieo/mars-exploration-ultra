import React, { useState } from "react";
import worker from "../img/flame-remote-working.gif";
import { Link, useLocation} from "react-router-dom";
import MapResult from "../components/MapResult";
import ExplorationResult from "../components/ExplorationResult";

const Result = () => {
    const location = useLocation();
    const [clicked, setClicked] = useState(false);
    return (
        <div className="result-container">
            {!clicked ?             
                <div className="result-container-img-btns"> 
                    <p>Data successfully submited!</p>
                    <img src={worker} alt="A GIF of a man working"/>
                        <button type="button" className="btn btn-outline-light" onClick={() => setClicked(!clicked)}>Show data</button>
                        <Link to="/" type="button" className="btn btn-outline-light">Go back home</Link>  
                </div>
            :   <div>
                    <button type="button" className="btn btn-outline-light" onClick={() => setClicked(!clicked)}>Show data</button>
                    <Link to="/" type="button" className="btn btn-outline-light">Go back home</Link>
                </div>
            }
            {location.pathname === '/result/map' && <MapResult clicked={clicked}/>}
            {location.pathname === '/result/exploration' && <ExplorationResult clicked={clicked}/>}
        </div>
    );
};

export default Result;
