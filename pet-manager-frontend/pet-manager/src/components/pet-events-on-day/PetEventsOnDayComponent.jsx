import React from "react";
import ToggleSwitchComponent from "../toggle-switch/ToggleSwitchComponent.jsx";
import { getTimeStringFromDateTimeString } from "../../utils/DateMapper.js";
import * as petsApi from "../../api/petsApi.js";
import { getDateStringFromDateTimeString } from "../../utils/DateMapper.js";

const PetEventsOnDayComponent = ({ scheduledEvents }) => {
  const dateJSON = new Date().toJSON();

  const today = getDateStringFromDateTimeString(dateJSON);

  const addCompletedEvent = (completedOn, scheduledEventId) => {
    petsApi.addCompletedEvent({ completedOn, scheduledEventId });
  };

  const deleteCompletedEvent = (completedOn, scheduledEvent) => {
    petsApi.deleteCompletedEventById({ completedOn, scheduledEvent });
  };

  return (
    <div>
      <table>
        <tbody>
          {scheduledEvents.map((scheduledEvent) => {
            const time = getTimeStringFromDateTimeString(
              scheduledEvent.startDate
            );

            const isCompleted =
              scheduledEvent.completedEvents.filter(
                (e) => e.completedOn === today
              ).length > 0;

            return (
              <tr>
                <td>{time}</td>
                <td>
                  <ToggleSwitchComponent
                    onOn={() => {
                      addCompletedEvent(today, scheduledEvent.id);
                    }}
                    onOff={() => {
                      deleteCompletedEvent(today, scheduledEvent.id);
                    }}
                    checked={isCompleted}
                  />
                </td>
              </tr>
            );
          })}
        </tbody>
      </table>
    </div>
  );
};

export default PetEventsOnDayComponent;
