import React from "react";
import ToggleSwitchComponent from "../toggle-switch/ToggleSwitchComponent.jsx";

const PetEventsOnDayComponent = ({ scheduledEvents }) => {
  return (
    <div>
      <table>
        <tbody>
          {scheduledEvents.map((scheduledEvent) => {
            const [, timeWithSeconds] = scheduledEvent.startDate.split("T");
            const time = timeWithSeconds.split(":", 2).join(":");

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
