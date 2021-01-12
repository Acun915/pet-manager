import React from "react";
import AddScheduledEventComponent from "../post-forms/add-scheduled-event/AddScheduledEventComponent";
import "../modal.css";

const PetComponent = ({ pet }) => {
  const closeAddScheduledEventModal = () => {
    const addPet = document.querySelector(".modal");
    const overlay = document.querySelector(".overlay");
    addPet.classList.add("hidden");
    overlay.classList.add("hidden");
  };

  const openAddScheduledEventModal = () => {
    const addPet = document.querySelector(".modal");
    const overlay = document.querySelector(".overlay");
    addPet.classList.remove("hidden");
    overlay.classList.remove("hidden");
    overlay.addEventListener("click", closeAddScheduledEventModal);
  };

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

      <button onClick={openAddScheduledEventModal}>Add Event</button>

      <div className="modal hidden">
        <button onClick={closeAddScheduledEventModal}>&times;</button>
        <AddScheduledEventComponent petId={pet.id} />
      </div>

      <div className="overlay hidden"></div>
    </div>
  );
};

export default PetComponent;
