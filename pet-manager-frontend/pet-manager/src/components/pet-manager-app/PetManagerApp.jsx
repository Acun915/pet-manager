import React, { useEffect, useState } from "react";
import FooterComponent from "../footer/FooterComponent";
import HeaderComponent from "../header/HeaderComponent";
import YourPetsComponent from "../your-pets/YourPetsComponent";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import "./PetManagerApp.css";
import PetComponent from "../pet/PetComponent";
import HomePageComponet from "../home-page/HomePageComponent";
import DailyFeedingComponent from "../daily-feeding/DailyFeedingComponent";

const PetManagerApp = () => {
  const [pets, setPets] = useState([]);
  const [isLoading, setIsLoading] = useState(true);

  useEffect(() => {
    getPets();
  }, []);

  const getPets = async () => {
    console.log("getPets() used");
    const response = await fetch(`http://localhost:8080/rest/pets`);
    const data = await response.json();
    setPets(data);
    setIsLoading(false);
  };

  return (
    <div className="app">
      <Router>
        <div className="header">
          <HeaderComponent />
        </div>

        <div className="main-container">
          <Switch>
            <Route path="/" exact component={HomePageComponet} />

            <Route
              path="/pets"
              exact
              render={(props) => {
                if (!isLoading) {
                  return (
                    <YourPetsComponent
                      pets={pets}
                      onDataChange={getPets}
                      {...props}
                    />
                  );
                }
              }}
            />

            <Route
              path="/dailyfeeding"
              exact
              render={() => {
                if (!isLoading) {
                  return <DailyFeedingComponent pets={pets} />;
                }
              }}
            />

            <Route
              path="/pets/:id"
              exact
              render={(props) => {
                if (!isLoading) {
                  const petId = Number(props.match.params.id);
                  const [currentPet] = pets.filter((pet) => pet.id === petId);
                  return (
                    <PetComponent pet={currentPet} onDataChange={getPets} />
                  );
                }
              }}
            />
          </Switch>
        </div>

        <div className="footer">
          <FooterComponent />
        </div>
      </Router>
    </div>
  );
};

export default PetManagerApp;
