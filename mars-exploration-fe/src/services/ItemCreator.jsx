import React from "react";
import { useNavigate } from "react-router-dom";

const createItem = (item, url, successMessage) => {
    return fetch(`http://localhost:8080/${url}`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(item),
    })
    .then((res) => {
        if (!res.ok) {
            throw new Error(`Failed to create the ${url}.`);
        }
        return res.json();
    })
    .catch((err) => {
        console.error(`Error creating ${url}:`, err);
    });
};

const ItemCreator = ({ formComponent, url, successMessage }) => {
    const navigate = useNavigate();

    const handleCreateItem = (item) => {
        createItem(item, url, successMessage)
            .then((result) => {
                console.log(`${successMessage}. Id:`, result);
                navigate(`/result/${url}`);
            })
            .catch((err) => {
                console.error(`Failed to create ${url}:`, err);
            });
    };

    const FormComponent = formComponent;

    return (
        <FormComponent onSave={handleCreateItem} />
    );
};

export default ItemCreator;
