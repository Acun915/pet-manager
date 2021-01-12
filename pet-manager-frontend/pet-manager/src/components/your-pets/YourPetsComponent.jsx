import React from "react";
import { Link } from "react-router-dom";
import AddPetComponent from "../post-forms/add-pet/AddPetComponent";
import "./YourPets.css";
import "../modal.css";

const YourPetsComponent = ({ pets }) => {
  const closeAddPetModal = () => {
    const addPet = document.querySelector(".modal");
    const overlay = document.querySelector(".overlay");
    addPet.classList.add("hidden");
    overlay.classList.add("hidden");
  };

  const openAddPetModal = () => {
    const addPet = document.querySelector(".modal");
    const overlay = document.querySelector(".overlay");
    addPet.classList.remove("hidden");
    overlay.classList.remove("hidden");
    overlay.addEventListener("click", closeAddPetModal);
  };

  return (
    <div className="main-container">
      <div className="your-pets">
        {pets.map((pet) => {
          return (
            <Link to={`/pets/${pet.id}`}>
              <div className="pet-container">
                <h1>{pet.name}</h1>
                <h2>{pet.type}</h2>
              </div>
            </Link>
          );
        })}
      </div>

      <button onClick={openAddPetModal}>Add Pet</button>

      <div className="modal hidden">
        <button onClick={closeAddPetModal}>&times;</button>
        <AddPetComponent />
      </div>

      <div className="overlay hidden"></div>
    </div>
  );
};

export default YourPetsComponent;
