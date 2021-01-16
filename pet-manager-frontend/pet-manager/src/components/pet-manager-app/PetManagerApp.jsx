import React, { useEffect, useState } from "react";
import FooterComponent from "../footer/FooterComponent";
import HeaderComponent from "../header/HeaderComponent";
import YourPetsComponent from "../your-pets/YourPetsComponent";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import "./PetManagerApp.css";
import PetComponent from "../pet/PetComponent";
import HomePageComponet from "../home-page/HomePageComponent";
import DailyFeedingComponent from "../daily-feeding/DailyFeedingComponent";
import * as petsApi from "../../api/petsApi.js";

const PetManagerApp = () => {
  const [pets, setPets] = useState([]);
  const [isLoading, setIsLoading] = useState(true);

  useEffect(() => {
    getPets();
  }, []);

  const getPets = async () => {
    const data = await petsApi.getAllPets();
    setPets(data);
    setIsLoading(false);
  };

  if (isLoading) {
    return <></>;
  }
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
                return (
                  <YourPetsComponent
                    pets={pets}
                    refreshPets={getPets}
                    {...props}
                  />
                );
              }}
            />

            <Route
              path="/daily-feeding"
              exact
              render={() => {
                return <DailyFeedingComponent pets={pets} />;
              }}
            />

            <Route
              path="/pets/:id"
              exact
              render={(props) => {
                const petId = Number(props.match.params.id);
                const [currentPet] = pets.filter((pet) => pet.id === petId);
                return <PetComponent pet={currentPet} refreshPets={getPets} />;
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
