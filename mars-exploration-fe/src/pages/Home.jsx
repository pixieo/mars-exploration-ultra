import React from "react";
import { Link } from "react-router-dom";
import drawMapGif from "../img/flame-design-science.gif";
import astronautFloating from "../img/flame-space-adventures.gif";

const Home = () => {
    return (
        <div className="home-container">
            <div className="cards-container">
                <div className="create-map-card">
                    <img src={drawMapGif} className="card-img-top" alt="A GIF of a hand drawing a map"/>
                    <div className="card-body">
                        <h5 className="card-title">Create your own map</h5>
                        <p className="card-text">Use your imagination and create a brand new map that you can exploration later.</p>
                        <Link to="/map" type="button" className="btn btn-dark" id="create-map-btn">Create map</Link>
                    </div>
                </div>

                <div className="exploration-card">
                    <img src={astronautFloating} className="card-img-top" alt="A GIF of an astronaut floating in space"/>
                    <div className="card-body">
                        <h5 className="card-title">Explore a map</h5>
                        <p className="card-text">Now you can travel across a map using a rover's point of view.</p>
                        <Link to="/exploration" type="button" className="btn btn-dark" id="exploration-btn">Explore</Link>
                    </div>
                </div>
            </div>

            <div className="credits">
            Illustration by <a target="_blank" rel="noreferrer" href="https://icons8.com/illustrations/author/oZpGJx8ts63Q">Thierry Fousse</a> from <a target="_blank" rel="noreferrer" href="https://icons8.com/illustrations">Ouch!</a>
            </div>
        </div>
    )
}

export default Home;