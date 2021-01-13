import React, { useState } from "react";

const AddPetComponent = ({ refreshPets, closeModal }) => {
  const [pet, setPet] = useState();

  const submit = (e) => {
    e.preventDefault();
    fetch("http://localhost:8080/rest/pets", {
      method: "POST",
      body: JSON.stringify(pet),
      headers: { "Content-Type": "application/json" },
    })
      .then((response) => response.json())
      .then((json) => setPet(json.pet));
    console.log(JSON.stringify(pet));
    refreshPets();
    closeModal();
  };

  return (
    <div>
      <form onSubmit={submit}>
        <div>
          <label htmlFor="name">Your Pet Name:</label>
          <input
            type="text"
            id="name"
            name="pet[name]"
            onChange={(e) => setPet({ ...pet, name: e.target.value })}
          ></input>
        </div>
        <div>
          <label htmlFor="type">Select type of yout pet:</label>
          <select
            id="type"
            name="pet[type]"
            onChange={(e) => setPet({ ...pet, type: e.target.value })}
          >
            <option value="selec-option">selec an option</option>
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
