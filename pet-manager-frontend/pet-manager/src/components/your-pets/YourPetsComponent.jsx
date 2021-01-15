import React, { useState } from "react";
import { Link } from "react-router-dom";
import AddPetComponent from "../post-forms/add-pet/AddPetComponent";
import ModalComponent from "../modal/ModalComponent";
import "./YourPets.css";

const YourPetsComponent = ({ pets, refreshPets }) => {
  const [isAddPetModalOpen, setIsAddPetModalOpen] = useState(false);

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

      <button
        onClick={() => {
          setIsAddPetModalOpen(true);
        }}
      >
        Add Pet
      </button>
      <ModalComponent
        isOpen={isAddPetModalOpen}
        content={<AddPetComponent />}
        onClose={() => {
          setIsAddPetModalOpen(false);
          refreshPets();
        }}
      />
    </div>
  );
};

export default YourPetsComponent;
