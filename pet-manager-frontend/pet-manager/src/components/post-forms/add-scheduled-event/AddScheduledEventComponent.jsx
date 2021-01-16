import React, { useState } from "react";
import * as petsApi from "../../../api/petsApi.js";

const AddScheduledEventComponent = ({ petId, closeModal }) => {
  const [scheduledEvent, setScheduledEvent] = useState({
    petId: petId,
  });

  const handleInputChange = (e) => {
    const value = e.target.value;
    const name = e.target.name;

    setScheduledEvent({ ...scheduledEvent, [name]: value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    petsApi.addPetScheduledEvent(petId, scheduledEvent);

    closeModal();
  };

  return (
    <div>
      <form onSubmit={handleSubmit}>
        <div>
          <label htmlFor="type">Select type of the event:</label>
          <select
            name="type"
            onChange={(e) => {
              handleInputChange(e);
            }}
          >
            <option value={null}>Select an option</option>
            <option value="Feeding">Feeding</option>
            <option value="Walking">Walking</option>
            <option value="Other">Other</option>
          </select>
        </div>

        <div>
          <label htmlFor="frequency">Select frequncy of the event:</label>
          <select
            name="frequency"
            onChange={(e) => {
              handleInputChange(e);
            }}
          >
            <option value={null}>Select an option</option>
            <option value="DAILY">Daily</option>
            <option value="WEEKLY">Weekly</option>
            <option value="MONTHLY">Monthly</option>
          </select>
        </div>

        <div>
          <label htmlFor="start-time">Choose a time for event:</label>
          <input
            type="datetime-local"
            name="startDate"
            defaultValue="2021-01-12T08:30"
            min="2021-01-07T00:00"
            max="2021-12-14T00:00"
            onChange={(e) => {
              handleInputChange(e);
            }}
          />
        </div>
        <button type="submit">Add</button>
      </form>
    </div>
  );
};

export default AddScheduledEventComponent;
