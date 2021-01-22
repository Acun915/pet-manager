import React, { useState } from "react";
import "./ToggleSwitchComponent.css";

const ToggleSwitchComponent = ({ onOn, onOff, checked }) => {
  const [isChecked, setIsChecked] = useState(checked);

  const handleSwitch = () => {
    if (!isChecked) {
      onOn();
    } else {
      onOff();
    }
  };
  return (
    <div>
      <label className="switch">
        <input
          checked={isChecked}
          type="checkbox"
          onChange={() => {
            handleSwitch();
            setIsChecked(!isChecked);
          }}
        ></input>
        <span className="slider round"></span>
      </label>
    </div>
  );
};

export default ToggleSwitchComponent;
