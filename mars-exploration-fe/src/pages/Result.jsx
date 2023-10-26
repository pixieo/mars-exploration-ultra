import React, { useState } from "react";
import watcher from "../img/flame-searching.gif";
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
                    <img src={watcher} alt="A GIF of a an eye inspecting a planet"/>
                        <button type="button" className="btn btn-outline-dark" onClick={() => setClicked(!clicked)}>Show data</button>
                        <Link to="/" type="button" className="btn btn-outline-dark">Go back home</Link>  
                </div>
            :   <div>
                    <button type="button" className="btn btn-outline-dark" onClick={() => setClicked(!clicked)}>Show data</button>
                    <Link to="/" type="button" className="btn btn-outline-dark">Go back home</Link>
                </div>
            }
            {location.pathname === '/result/map' && <MapResult clicked={clicked}/>}
            {location.pathname === '/result/exploration' && <ExplorationResult clicked={clicked}/>}
        </div>
    );
};

export default Result;
