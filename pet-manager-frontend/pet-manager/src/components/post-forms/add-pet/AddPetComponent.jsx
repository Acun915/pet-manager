import React, { useState } from "react";
import * as petsApi from "../../../api/petsApi.js";

const AddPetComponent = ({ closeModal }) => {
  const [pet, setPet] = useState();

  const handleInputChange = (e) => {
    const value = e.target.value;
    const name = e.target.name;

    setPet({ ...pet, [name]: value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    petsApi.addPet(pet);

    closeModal();
  };

  return (
    <div>
      <form onSubmit={handleSubmit}>
        <div>
          <label htmlFor="name">Your Pet Name:</label>
          <input
            type="text"
            name="name"
            onChange={(e) => {
              handleInputChange(e);
            }}
          ></input>
        </div>
        <div>
          <label htmlFor="type">Select type of yout pet:</label>
          <select
            name="type"
            onChange={(e) => {
              handleInputChange(e);
            }}
          >
            <option value="select-option">selec an option</option>
            <option value="Dog">Dog</option>
            <option value="Cat">Cat</option>
            <option value="Other">Other</option>
          </select>
        </div>
        <button type="submit">Add</button>
      </form>
    </div>
  );
};

export default AddPetComponent;
