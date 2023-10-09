import React from "react";
import { Link } from "react-router-dom";

const MapForm = ({ onSave }) => {
    const onSubmit = (e) => {
        e.preventDefault();
        const formData = new FormData(e.target);
        const entries = [...formData.entries()];

        const map = entries.reduce((acc, entry) => {
            const [k, v] = entry;
            acc[k] = v;
            return acc;
        }, {});

        return onSave(map);
    }


    return (
        <div className="create-map-form">
            <form className="row g-3" onSubmit={onSubmit}>
                <div className="col-md-6">
                    <label className="form-label">File name</label>
                    <input type="text" name="fileName" className="form-control"
                    defaultValue={"my-first-map.map"}/>
                </div>
                <div className="col-md-6">
                    <label className="form-label">Map width</label>
                    <input type="number" name="mapWidth" className="form-control"
                    defaultValue={45}/>
                </div>
                <div className="col-md-6">
                    <label className="form-label">Number of mountains</label>
                    <input type="number" name="numOfMountains" className="form-control"
                    defaultValue={2}/>
                </div>
                <div className="col-md-6">
                    <label className="form-label">Number of pits</label>
                    <input type="number" name="numOfPits" className="form-control"
                    defaultValue={2}/>
                </div>
                <div className="col-md-6">
                    <label className="form-label">Number of minerals</label>
                    <input type="number" name="numOfMinerals" className="form-control"
                    defaultValue={10}/>
                </div>
                <div className="col-md-6">
                    <label className="form-label">Number of bodies of water</label>
                    <input type="number" name="numOfWaters" className="form-control"
                    defaultValue={10}/>
                </div>
                <div className="col-12 d-flex justify-content-between">
                    <Link to="/" type="button" className="btn btn-outline-dark">Go back</Link>
                    <button type="submit" className="btn btn-outline-dark">Submit</button>
                </div>
            </form>
        </div>
    )
}

export default MapForm;