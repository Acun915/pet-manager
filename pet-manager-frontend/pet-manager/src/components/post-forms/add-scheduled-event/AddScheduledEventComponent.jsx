import React, { useState } from "react";

const AddScheduledEventComponent = ({ petId }) => {
  {
    console.log(petId);
  }
  const [scheduledEvent, setScheduledEvent] = useState({
    petId: petId,
  });

  const submit = (e) => {
    e.preventDefault();
    fetch(`http://localhost:8080/rest/pets/${petId}/scheduledEvents`, {
      method: "POST",
      body: JSON.stringify(scheduledEvent),
      headers: { "Content-Type": "application/json" },
    })
      .then((response) => response.json())
      .then((json) => setScheduledEvent(json.scheduledEvent));
    console.log("This is the json", JSON.stringify(scheduledEvent));
  };

  return (
    <div>
      <form onSubmit={submit}>
        <div>
          <label htmlFor="type">Select type of the event:</label>
          <select
            id="type"
            name="scheduledEvent[type]"
            onChange={(e) =>
              setScheduledEvent({ ...scheduledEvent, type: e.target.value })
            }
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
            id="frequency"
            name="scheduledEvent[frequency]"
            onChange={(e) =>
              setScheduledEvent({
                ...scheduledEvent,
                frequency: e.target.value,
              })
            }
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
            id="start-time"
            name="scheduledEvent[startDate]"
            defaultValue="2021-01-12T08:30"
            min="2021-01-07T00:00"
            max="2021-12-14T00:00"
            onChange={(e) =>
              setScheduledEvent({
                ...scheduledEvent,
                startDate: e.target.value,
              })
            }
          />
        </div>
        <button
          onClick={() => {
            console.log(this);
          }}
          type="submit"
        >
          Add
        </button>
      </form>
    </div>
  );
};

export default AddScheduledEventComponent;
