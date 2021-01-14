import React from "react";
import ToggleSwitchComponent from "../toggle-switch/ToggleSwitchComponent.jsx";
import { getTimeStringFromDateTimeString } from "../../utils/DateMapper.js";

const PetEventsOnDayComponent = ({ scheduledEvents }) => {
  return (
    <div>
      <table>
        <tbody>
          {scheduledEvents.map((scheduledEvent) => {
            const time = getTimeStringFromDateTimeString(
              scheduledEvent.startDate
            );

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
