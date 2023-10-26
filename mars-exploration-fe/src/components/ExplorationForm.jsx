import React from "react";
import { Link } from "react-router-dom";

const ExplorationForm = ({ onSave }) => {
    const onSubmit = (e) => {
        e.preventDefault();
        const formData = new FormData(e.target);
        const entries = [...formData.entries()];

        const input = entries.reduce((acc, entry) => {
            const [k, v] = entry;
            acc[k] = v;
            return acc;
        }, {});
        return onSave(input);
    }
    
    return (
        <div className="exploration-form">
            <form className="row g-3" onSubmit={onSubmit}>
                <div className="col-md-6">
                    <label className="form-label">File path</label>
                    <input type="text" name="mapFilePath" className="form-control" placeholder="my-map.example"
                        defaultValue={"/Users/sarat/IdeaProjects/mars-exploration/src/main/resources/exploration-1.map"}/>
                </div>
                <div className="col-md-6">
                    <label className="form-label">Save as</label>
                    <input type="text" name="logFilePath" className="form-control" placeholder="my-first-log.example"
                    defaultValue={"/Users/sarat/IdeaProjects/mars-exploration/src/main/resources/my-exploration-1.log"}/>
                </div>
                <div className="col-md-6">
                    <label className="form-label">Rover's Id</label>
                    <input type="text" name="roverId" className="form-control"
                    defaultValue={1}/>
                </div>
                <div className="col-md-6">
                    <label className="form-label">Rover's sight</label>
                    <input type="number" name="roverSight" className="form-control"
                    defaultValue={20}/>
                </div>
                <div className="col-12">
                    <label className="form-label">Timeout</label>
                    <input type="number" name="timeout" className="form-control"
                    defaultValue={700}/>
                </div>
                <div className="col-md-6">
                    <label className="form-label">Minerals to collect</label>
                    <input type="number" name="mineralCount" className="form-control"
                    defaultValue={1}/>
                </div>
                <div className="col-md-6">
                    <label className="form-label">Bodies of water to collect</label>
                    <input type="number" name="waterCount" className="form-control"
                    defaultValue={1}/>
                </div>
                <div className="col-md-6">
                    <label className="form-label">Landing coordinate X</label>
                    <input type="number" name="xCoordinate" className="form-control"
                    defaultValue={12}/>
                </div>
                <div className="col-md-6">
                    <label className="form-label">Landing coordinate Y</label>
                    <input type="number" name="yCoordinate" className="form-control"
                    defaultValue={12}/>
                </div>
                <div className="col-12 d-flex justify-content-between">
                    <Link to="/" type="button" className="btn btn-outline-dark">Go back</Link>
                    <button type="submit" className="btn btn-outline-dark">Submit</button>
                </div>
            </form>
        </div>
    )
}

export default ExplorationForm;