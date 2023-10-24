import React, { useState } from "react";
import { Link } from "react-router-dom";

const MapForm = ({ onSave }) => {
    const [step, setStep] = useState(1);
    const [fileName, setFileName] = useState('my-first-map.map');
    const [mapWidth, setMapWidth] = useState(45);
    const [numOfMountains, setNumOfMountains] = useState(2);
    const [numOfPits, setNumOfPits] = useState(2);
    const [mountainValues, setMountainValues] = useState([]);
    const [pitValues, setPitValues] = useState([]);
    const [numOfMinerals, setNumOfMinerals] = useState(10);
    const [numOfWaters, setNumOfWaters] = useState(10);
    const map = {
        "filePath" : fileName,
        "mapWidth" : mapWidth,
        "numOfMountains" : numOfMountains,
        "mountainSizes" : mountainValues,
        "numOfPits" : numOfPits,
        "pitSizes" : pitValues,
        "numOfMinerals" : numOfMinerals,
        "numOfWaters" : numOfWaters
    };

    const onSubmit = (e) => {
        e.preventDefault();
        return onSave(map);
    }

    const handleChange = (e, field, index) => {
        const newValue = e.target.value;
    
        switch (field) {
          case "fileName":
            setFileName(newValue);
            break;
          case "mapWidth":
            setMapWidth(newValue);
            break;
          case "numOfMountains":
            setNumOfMountains(newValue);
            setMountainValues([]);
            break;
          case "numOfPits":
            setNumOfPits(newValue);
            setPitValues([]);
            break;
          case "numOfMinerals":
            setNumOfMinerals(newValue);
            break;
          case "numOfWaters":
            setNumOfWaters(newValue);
            break;
          case "mountain":
            const updatedMountainValues = [...mountainValues];
            updatedMountainValues[index] = newValue;
            setMountainValues(updatedMountainValues);
            break;
          case "pit":
            const updatedPitValues = [...pitValues];
            updatedPitValues[index] = newValue;
            setPitValues(updatedPitValues);
            break;
          default:
            break;
        }
    }

    const incrementStep = () => {
        setStep(step + 1);
    }

    const decrementStep = () => {
        setStep(step - 1);
    }
    
    return (
        <>
            {step === 1 &&         
            <div className="create-map-form">
                <form className="row g-3">
                    <div className="col-md-6">
                        <label className="form-label">File name</label>
                        <input type="text" name="fileName" className="form-control"
                        defaultValue={"my-first-map.map"} 
                        onChange={(e) => handleChange(e, 'fileName')}/>
                    </div>
                    <div className="col-md-6">
                        <label className="form-label">Map width</label>
                        <input type="number" name="mapWidth" className="form-control"
                        defaultValue={45}
                        onChange={(e) => handleChange(e, 'mapWidth')}/>
                    </div>
                    <div className="col-md-6">
                        <label className="form-label">Number of mountains</label>
                        <input type="number" name="numOfMountains" className="form-control"
                        defaultValue={2}
                        onChange={(e) => handleChange(e, 'numOfMountains')}/>
                    </div>
                    <div className="col-md-6">
                        <label className="form-label">Number of pits</label>
                        <input type="number" name="numOfPits" className="form-control"
                        defaultValue={2}
                        onChange={(e) => handleChange(e, 'numOfPits')}/>
                    </div>
                    <div className="col-md-6">
                        <label className="form-label">Number of minerals</label>
                        <input type="number" name="numOfMinerals" className="form-control"
                        defaultValue={10}
                        onChange={(e) => handleChange(e, 'numOfMinerals')}/>
                    </div>
                    <div className="col-md-6">
                        <label className="form-label">Number of bodies of water</label>
                        <input type="number" name="numOfWaters" className="form-control"
                        defaultValue={10}
                        onChange={(e) => handleChange(e, 'numOfWaters')}/>
                    </div>
                    <div className="col-12 d-flex justify-content-between">
                        <Link to="/" type="button" className="btn btn-outline-dark">Go back</Link>
                        <button type="button" className="btn btn-outline-dark" onClick={incrementStep}>Next</button>
                    </div>
                </form>
            </div>
            }
            {step === 2 &&        
            <div className="create-map-form">
            <form className="row g-3" onSubmit={onSubmit}>
                {
                    [...Array(Number(numOfMountains))].map((_, index) => (
                        <div className="col-md-6" key={index}>
                          <label className="form-label">Mountain {index + 1}</label>
                          <input
                            type="number"
                            name={`mountain_${index}`}
                            className="form-control"
                            onChange={(e) => handleChange(e, 'mountain', index)}
                          />
                        </div>
                    ))
                }
                {
                    [...Array(Number(numOfPits))].map((_, index) => (
                        <div className="col-md-6" key={index}>
                          <label className="form-label">Pit {index + 1}</label>
                          <input
                            type="number"
                            name={`pit_${index}`}
                            className="form-control"
                            onChange={(e) => handleChange(e, 'pit', index)}
                          />
                        </div>
                    ))
                }
                <div className="col-12 d-flex justify-content-between">
                    <button type="button" className="btn btn-outline-dark" onClick={decrementStep}>Go back</button>
                    <button type="submit" className="btn btn-outline-dark">Submit</button>
                </div>
            </form>
        </div>
        }
        </>
    )
}

export default MapForm;