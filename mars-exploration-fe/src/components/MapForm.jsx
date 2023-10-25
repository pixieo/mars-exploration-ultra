import React, { useState } from "react";
import { Link } from "react-router-dom";

const MapForm = ({ onSave }) => {
    const [step, setStep] = useState(1);
    const [formData, setFormData] = useState({
      fileName: "my-first-map.map",
      mapWidth: 45,
      numOfMountains: 2,
      numOfPits: 2,
      mountainValues: [],
      pitValues: [],
      numOfMinerals: 10,
      numOfWaters: 10,
    });

    const incrementStep = () => {
      setStep(step + 1);
    }

    const decrementStep = () => {
        setStep(step - 1);
    }
    
    const handleChange = (e, field, index) => {
      const { name, value } = e.target;
      setFormData((prevData) => {
        const parsedValue = parseInt(value);
        const updatedArray = [...prevData[field === "mountain" ? "mountainValues" : "pitValues"]];
        updatedArray[index] = parsedValue;
    
        return {
          ...prevData,
          [name]: field === "fileName" ? value : parsedValue,
          [field === "mountain" ? "mountainValues" : "pitValues"]: updatedArray,
        };
      });
    };

    const renderMountainPitInputs = (type) => {
      const count = type === "mountain" ? formData.numOfMountains : formData.numOfPits;
  
      return [...Array(Number(count))].map((_, index) => (
        <div className="col-md-6" key={index}>
          <label className="form-label">
            {type.charAt(0).toUpperCase() + type.slice(1)} {index + 1}
          </label>
          <input
            type="number"
            name={`${type}_${index}`}
            className="form-control"
            onChange={(e) => handleChange(e, type, index)}
          />
        </div>
      ));
    };
        
    const onSubmit = (e) => {
      e.preventDefault();
      return onSave(formData);
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
                {renderMountainPitInputs('mountain')}
                {renderMountainPitInputs('pit')}
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