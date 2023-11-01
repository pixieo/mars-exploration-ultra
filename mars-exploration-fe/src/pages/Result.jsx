import React, { useState } from "react";
import watcher from "../img/flame-searching.gif";
import { Link, useLocation} from "react-router-dom";
import MapResult from "../components/MapResult";
import ExplorationResult from "../components/ExplorationResult";

const Result = () => {
    const location = useLocation();
    const [clicked, setClicked] = useState(false);
    const [isHidden, setIsHidden] = useState(false);
    
    const handleClick = () => {
        setClicked(!clicked);
        setIsHidden(!isHidden);
    }

    const className = isHidden ? "hidden-content" : "visible-content";

    return (
        <div className="result-container">          
            <div className={className}>
                <p 
                    style={{ 
                        visibility : isHidden ? "hidden" : "visible",
                    }}
                >
                    Data successfully submited!
                </p>
                <img 
                    src={watcher} 
                    alt="A GIF of a an eye inspecting a planet"
                    style={{ 
                        opacity: isHidden ? 0 : 1,
                        transition: "opacity 1s",
                    }}
                />  
            </div>
            <div className="result-buttons">    
                <button type="button" className="btn btn-outline-dark" onClick={handleClick}>Show data</button>
                <Link to="/" type="button" className="btn btn-outline-dark">Go back home</Link>  
            </div>
            {location.pathname === '/result/map' && <MapResult clicked={clicked}/>}
            {location.pathname === '/result/exploration' && <ExplorationResult clicked={clicked}/>}
        </div>
    );
};

export default Result;
