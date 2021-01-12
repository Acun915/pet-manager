import React, { useEffect, useState } from "react";

const HomePageComponent = () => {
  const [counter, setCounter] = useState(0);

  const incrementCounter = () => {
    setCounter(counter + 1);
  };

  useEffect(() => {
    const parsedCounter = Number(localStorage.getItem("counter") || 0);
    setCounter(parsedCounter);
  }, []);

  useEffect(() => {
    localStorage.setItem("counter", counter);
  }, [counter]);

  return (
    <div>
      <h1>Welcome to PET-MANAGER {counter}</h1>
      <button onClick={incrementCounter}>increment</button>
    </div>
  );
};

export default HomePageComponent;
