import React from "react";
import ToggleSwitchComponent from "../toggle-switch/ToggleSwitchComponent.jsx";
import { getTimeStringFromDateTimeString } from "../../utils/DateMapper.js";
import * as petsApi from "../../api/petsApi.js";
import { getDateStringFromDateTimeString } from "../../utils/DateMapper.js";

const PetEventsOnDayComponent = ({ scheduledEvents }) => {
  const dateJSON = new Date().toJSON();

  const today = getDateStringFromDateTimeString(dateJSON);

  const addCompletedEvent = (completedOn, scheduledEventId) => {
    petsApi.addCompletedEvent(1, { completedOn, scheduledEventId });
  };

  addCompletedEvent(today, 3);
  return (
    <div>
      <table>
        <tbody>
          {scheduledEvents.map((scheduledEvent) => {
            const time = getTimeStringFromDateTimeString(
              scheduledEvent.startDate
            );

            console.log(scheduledEvent.completedEvents);

            return (
              <tr>
                <td>{time}</td>
                <td>
                  <ToggleSwitchComponent />
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
