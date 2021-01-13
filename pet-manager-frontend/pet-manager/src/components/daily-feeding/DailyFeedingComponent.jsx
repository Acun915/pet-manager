import React from "react";
import PetEventsOnDayComponent from "../pet-events-on-day/PetEventsOnDayComponent";
import "./DailyFeedingComponent.css";

const DailyFeedingComponent = ({ pets }) => {
  return (
    <div className="events">
      {pets.map((pet) => {
        return (
          <div>
            {pet.scheduledEvents.length > 0 && pet.name}
            <PetEventsOnDayComponent
              scheduledEvents={pet.scheduledEvents.filter(
                (scheduledEvent) =>
                  scheduledEvent.type.toLowerCase() === "feeding"
              )}
            />
          </div>
        );
      })}
    </div>
  );
};

export default DailyFeedingComponent;
