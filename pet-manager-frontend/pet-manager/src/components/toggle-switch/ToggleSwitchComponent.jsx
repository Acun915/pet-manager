import React from "react";
import "./ToggleSwitchComponent.css";

const ToggleSwitchComponent = () => {
  return (
    <div>
      <label className="switch">
        <input type="checkbox"></input>
        <span className="slider round"></span>
      </label>
    </div>
  );
};

export default ToggleSwitchComponent;
