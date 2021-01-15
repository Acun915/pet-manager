import React, { useState } from "react";
import ModalComponent from "../modal/ModalComponent";
import AddScheduledEventComponent from "../post-forms/add-scheduled-event/AddScheduledEventComponent";

const PetComponent = ({ pet, refreshPets }) => {
  const [
    isAddScheduledEventModalOpen,
    setIsAddScheduledEventModalOpen,
  ] = useState(false);

  return (
    <div>
      <h1>{pet.name}</h1>
      <h3>{pet.type}</h3>
      <div className="scheduled-events-container">
        {pet.scheduledEvents.map((e) => (
          <ul className="scheduled-event">
            <li>{e.type}</li>
            <li>{e.frequency}</li>
            <li>{e.startDate}</li>
            <li>{e.createdAt}</li>
          </ul>
        ))}
      </div>

      <button
        onClick={() => {
          setIsAddScheduledEventModalOpen(true);
        }}
      >
        Add Event
      </button>

      <ModalComponent
        isOpen={isAddScheduledEventModalOpen}
        content={<AddScheduledEventComponent petId={pet.id} />}
        onClose={() => {
          setIsAddScheduledEventModalOpen(false);
          refreshPets();
        }}
      />
    </div>
  );
};

export default PetComponent;
