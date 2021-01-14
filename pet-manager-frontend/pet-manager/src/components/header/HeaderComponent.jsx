import React from "react";
import { Link } from "react-router-dom";
import "./HeaderComponent.css";

const HeaderComponent = () => {
  return (
    <header>
      <nav className="navbar">
        <div className="nav-item">
          <Link to="/">Pet-Manager</Link>
        </div>

        <div className="nav-item">
          <Link to="/pets">Your Pets</Link>
        </div>

        <div className="nav-item">
          <Link to="/dailyfeeding">Daily Feeding</Link>
        </div>
      </nav>
    </header>
  );
};

export default HeaderComponent;
